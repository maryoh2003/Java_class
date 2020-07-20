package dgsw.hs.kr.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class InetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			InetAddress address = InetAddress.getLocalHost();
//			InetAddress address = InetAddress.getByName("google.com");
//			System.out.println("address : "+address);
//			System.out.println
//			   ("address : "+address.getHostAddress());
//			System.out.println
//			   ("host : "+address.getHostName());
//			//NIO
//			SocketChannel sockCannel = SocketChannel.open();
//			sockCannel.connect(new InetSocketAddress(address, 80));
//			while(!sockCannel.finishConnect()) {
//				
//			}
//			System.out.println("connet success");
//			String sendData = "GET / HTTP/1.1\n";
//			ByteBuffer sendBuff = ByteBuffer.allocate(1024);
//			sendBuff.put(sendData.getBytes());
//			sendData = "Host: google.com\n";
//			sendBuff.put(sendData.getBytes());
//			sendData = "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36\n";
//			sendBuff.put(sendData.getBytes());
//			sockCannel.write(sendBuff);
//			sendBuff.clear();
			
			URL url = new URL("http://google.com:80");
			URLConnection uc = url.openConnection();
			InputStream input = uc.getInputStream();
			ReadableByteChannel sockCannel = Channels.newChannel(input);
			
			
			
			ByteBuffer buffer = ByteBuffer.allocate(1280);
			System.out.println("buffer : "+buffer);
			int readSize = sockCannel.read(buffer);
			System.out.println("read data : "+readSize);
			if(readSize >0 ) {
				String str = new String(buffer.array());
				System.out.println(str);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}