package dgsw.hs.kr0630;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	public static final int PORT = 9000;  //서버 포트
	public static int idx = 0;            //현재 접속 중인 클라이언트 수
	public static ArrayList<ChatSocketThread> clients;      //접속중인 클라이언트들
	public static void main(String[] args) {
		try {
			clients = new ArrayList<ChatSocketThread>();
			//1. OS로 부터 포트 할당
			System.out.println("server start");
			ServerSocket server = new ServerSocket(PORT);
			//2. Super Loop (최대 10번)
			while(true) {
			if (idx != 10) {
				//3. 서버 접속 대기
				Socket socket = server.accept();
				idx++;           //클라언트 접속 성공
				System.out.println("connect Client cnt : "+idx);
				
				//4.쓰레드 생성
				ChatSocketThread thread = new ChatSocketThread(
						socket,
						new DataOutputStream(socket.getOutputStream()),
						new DataInputStream(socket.getInputStream())
						);
				
				//5. 쓰레드 배열 저장
				clients.add(thread);
				idx = clients.size();
				
				//6. 쓰레드 동작
				thread.start();
			   }
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}