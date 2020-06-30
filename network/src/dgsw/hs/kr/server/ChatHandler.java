package dgsw.hs.kr.server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatHandler extends Thread {
	Socket socket;
	String name;
	public final DataOutputStream out;  //외부 클래스에서 접근하여 출력
	public final DataInputStream in;
	//생성자를 통해 소캣 객체 전달 받음
	public ChatHandler(Socket socket,DataOutputStream out,DataInputStream in) {
		//3. 출력 스트림 선언
		this.out = out;
		this.in = in;
		this.socket = socket;
	}
	
	@Override
	public void run() {
		//1. 문자열 저장 버퍼 할당
		String temp;
		
		try {
//			//2. 입력 스트림 선언
//			InputStream is = socket.getInputStream();
//			DataInputStream in =new DataInputStream(is);
//					
			//4. client ID 등록
			this.name = in.readUTF(); //한글 utf-8 enter 기준 read
			System.out.println("client id : " +this.name);
			//5. 멀티 채팅 시작
			while(true) {
				//6. 채팅 데이터 저장
				temp = in.readUTF();
				
				//7. 채팅 데이터 클라언트 전부에 전달
				for(ChatHandler handler : MultiServer.clients) {
					String msg = this.name + " : " + temp;
					System.out.println(msg);
					handler.out.writeUTF(msg);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}