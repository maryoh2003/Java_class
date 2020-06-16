import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileReceiver {
	public static int PORT = 9000;
	public static final int BUFF_SIZE = 10000;
	public static final String DOWNLOAD = "C:\\download\\a.txt";
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("server start");
			Socket socket = server.accept();
			
			FileOutputStream fout;
			fout = new FileOutputStream(DOWNLOAD);
			InputStream is = socket.getInputStream();
			
			byte[] buff = new byte[BUFF_SIZE];
			int readSize=0;
			while( (readSize = is.read(buff))!=1) {
				fout.write(buff, 0, readSize);
			}
			is.close();
			fout.close();
			socket.close();
			server.close();
			
		} catch(Exception e) {
			
		}	
	}
}
