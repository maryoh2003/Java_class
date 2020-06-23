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
	public DataOutputStream out;  //�ܺ� Ŭ�������� �����Ͽ� ���
	//�����ڸ� ���� ��Ĺ ��ü ���� ������
	public ChatHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		//1. ���ڿ� ���� ���� �Ҵ�
		String temp;
		
		try {
			//2. �Է� ��Ʈ�� ����
			InputStream is = socket.getInputStream();
			DataInputStream in =new DataInputStream(is);
			
			//3. ��� ��Ʈ�� ����
			OutputStream os = socket.getOutputStream();
			this.out = new DataOutputStream(os);
			
			//4. clinet ID ���
			this.name = in.readUTF(); //�ѱ� utf-8 enter ���� read
			System.out.println("clinet id : " +this.name);
			//5. ��Ƽ ä�� ����
			while(true) {
				//6. ä�� ������ ����
				temp = in.readUTF();
				
				//7. ä�� ������ Ŭ���Ʈ ���ο� ����
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