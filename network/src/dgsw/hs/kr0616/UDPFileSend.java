package dgsw.hs.kr0616;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import javax.sound.sampled.Port;

public class UDPFileSend {
	public static final String SERVER_IP = "127.0.0.1";
	public static final int PORT = 8500;
	public static final int BUFF_SIZE = 10000; 
	public static final String SENDFILE = "C:\\download\\b.txt";
	public static void main(String[] args) {
		try {
			File file = new File(SENDFILE);
			if(file.exists()) {
				//Socket socket = new Socket(SERVER_IP,PORT);
				DatagramSocket ds = new DatagramSocket();
				//파일 읽기
				FileInputStream fin = new FileInputStream(file);
				//버퍼 생성
				byte[] buff = new byte[BUFF_SIZE];
				
				//1. 파일 네임
				String temp = file.getName();
				DatagramPacket dp = 
						new DatagramPacket(temp.getBytes(),//파일명(배열)
								temp.getBytes().length, //파일명배열 크기
								InetAddress.getByName(SERVER_IP),
								PORT);
			
				ds.send(dp);
				//2. 파일 사이즈
				temp = String.valueOf( file.length()) ; 
 				dp = new DatagramPacket(temp.getBytes(),//파일명(배열)
								temp.getBytes().length, //파일명배열 크기
								InetAddress.getByName(SERVER_IP),
								PORT);
			
				ds.send(dp);
				//3. 파일 전송
				int readSize=0;
				Thread.sleep(100);
				long totalSize = 0;
				while( (readSize = fin.read(buff))!= -1 ) {
					Thread.sleep(5);
					dp = new DatagramPacket(buff,//파일
							readSize, //읽은 사이즈
							InetAddress.getByName(SERVER_IP),
							PORT);
		
					ds.send(dp);
					totalSize += readSize;
					System.out.println("tt : "+totalSize);
				}
				fin.close(); //파일 읽기 종료
				ds.close(); //데이터 소캣 반환
				
			}
		}catch(Exception e) {
			
		}
	}
}