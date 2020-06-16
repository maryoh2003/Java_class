package dgsw.hs.kr0616;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPFileSend {
	public static final String SERVER_IP = "127.0.0.1";
	public static final int PORT = 9000;
	public static final int BUFF_SIZE = 10000; 
	public static final String SENDFILE = "C:\\download\\b.txt";
	public static void main(String[] args) {
		try {
			File file = new File(SENDFILE);
			if(file.exists()) {
				//Socket socket = new Socket(SERVER_IP, PORT);
				DatagramSocket ds = new DatagramSocket();
				//���� �б�
				FileInputStream fin = new FileInputStream(file);
				//���� ����
				byte[] buff = new byte[BUFF_SIZE];			
				//1. ���� �̸�
				String temp = file.getName();
				DatagramPacket dp = 
						new DatagramPacket(temp.getBytes(),  //���ϸ�(�迭)
								temp.getBytes().length,
								InetAddress.getByName(SERVER_IP),
								PORT);	//���ϸ� �迭 ũ��
				ds.send(dp);
				//2. ���� ������ 
				temp = String.valueOf (file.length());
				dp = new DatagramPacket(temp.getBytes(),  //���ϸ�(�迭)
								temp.getBytes().length,	// ���ϸ�迭 ũ��
								InetAddress.getByName(SERVER_IP),
								PORT);	//���ϸ� �迭 ũ��
				ds.send(dp);
				//3. ���� ����
				int readSize = 0;
				while ((readSize = fin.read(buff)) != -1) {
					dp = new DatagramPacket(buff, //����
							readSize, //���� ������
							InetAddress.getByName(SERVER_IP),
							PORT);
					
					ds.send(dp);
				}
				fin.close();
				ds.close();
			}
		} catch(Exception e) {
			
		}
	}
}
