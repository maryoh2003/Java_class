package dgsw.hs.kr.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	public static final String ServerIP = "10.80.163.192";
	public static final int PORT = 9000;
	public static void main(String[] args) {
		try {
			//1 서버 접속
			Socket socket = new Socket(ServerIP, PORT);
			System.out.println("Connected");
			
			//2. 입력 스트림 선언
			InputStream is = socket.getInputStream();
			DataInputStream in =new DataInputStream(is);
			
			//3. 출력 스트림 선언
			OutputStream os = socket.getOutputStream();
			DataOutputStream out = new DataOutputStream(os);
			
			//4. 표준 키보드 입력 스트림 생성
			Scanner sc = new Scanner(System.in);
			
		    //5. 출력 쓰레드 생성
			Thread sendThread = new Thread(new Runnable() {
				@Override
				public void run() {
					//1. ID 등록
					String msg = sc.nextLine();
					try {
						System.out.println("id input : ");
						out.writeUTF(msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
					//2. 무한반복
					while(true) {
						try {
							System.out.println("msg : ");
							msg = sc.nextLine();
							out.writeUTF(msg);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
			//6. 입력 쓰레드 생성
			Thread readThread = new Thread(new Runnable() {
				@Override
				public void run() {
					//1. 무한 반복
					while(true) {
						
					}
				}
			});
			//7 쓰레드 시작
			sendThread.start();
			readThread.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}