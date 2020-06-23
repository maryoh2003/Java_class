package dgsw.hs.kr.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {
	public static final int PORT = 9000;  //서버 포트
	public static int idx = 0;            //현재 접속 중인 클라이언트 수
	public static ArrayList<ChatHandler> clients;      //접속중인 클라이언트들
	public static void main(String[] args) {
		try {
			clients = new ArrayList<ChatHandler>();
			//1. OS로 부터 포트 할당
			ServerSocket server = new ServerSocket(PORT);
			//2. Super Loop (무한 반복)
			while(true) {
				//3. 서버 접속 대기
				Socket socket = server.accept();
				idx++;           //클라언트 접속 성공
				System.out.println("connect Client cnt : "+idx);
				
				//4.쓰레드 생성
				ChatHandler thread = new ChatHandler(socket);
				
				//5. 쓰레드 배열 저장
				clients.add(thread);
				
				//6. 쓰레드 동작
				thread.start();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}