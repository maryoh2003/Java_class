package dgsw.hs.kr0616;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileSend {
	public static final String SERVER_IP = "127.0.0.1";
	public static final int PORT = 9000;
	public static final int BUFF_SIZE = 10000; 
	public static final String SENDFILE = "C:\\download\\b.txt";
	public static void main(String[] args) {
		try{
			File file = new File(SENDFILE);
			if(file.exists()) {
				Socket socket = new Socket(SERVER_IP,PORT);
				
				//파일에서 데이터를 읽음
				FileInputStream fin = new FileInputStream(file);
				//데이터르 서버로 전송
				OutputStream out = socket.getOutputStream();
				
				int totalSize = 0;
				byte[] buff = new byte[BUFF_SIZE];
				int readSize=0;
				while( (readSize = fin.read(buff))!= -1 ) {
					out.write(buff,0,readSize);
					totalSize += readSize;
					System.out.println("send size : "+totalSize);
				}
				System.out.println("send out");
				fin.close(); //파일 읽기 종료
				out.close(); //서버 전송 종료
				socket.close(); //서버 접속 종료
				
			}
		}catch(Exception e) {
			
		}
	}
}