package kr.hs.dgsw.c2.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress inet = InetAddress.getByName("google.com");
			Socket socket = new Socket(inet, 80);
			System.out.println("connect : "+socket.isConnected());
			PrintStream out = new PrintStream(socket.getOutputStream());
			out.println("GET / HTTP/1.1");		
			out.println("Host: google.com");
			out.println("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_0)"
					+ " AppleWebKit/537.36 (KHTML, like Gecko)"
					+ " Chrome/30.0.1599.101 Safari/537.36");
			out.println();
			
			InputStream input = socket.getInputStream();
			InputStreamReader inReader = new InputStreamReader(input);
			BufferedReader in = new BufferedReader(inReader);

			String line = "";
			while( (line = in.readLine()) != null) {
				System.out.println(line);
			}
			in.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}