package kr.hs.dgsw.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketMain {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(6000);
			System.out.println("waitting connet");
			Socket socket = serverSocket.accept();
			System.out.println("success connect clinet");
			OutputStream output = socket.getOutputStream();
			PrintWriter out = new PrintWriter(output,true);
			InputStream input = socket.getInputStream();
			BufferedReader in = 
					new BufferedReader(new InputStreamReader(input));
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.print("server input data : ");
				String inputData = sc.nextLine();
				out.println(inputData);
				
				if((inputData=in.readLine())!=null){
					System.out.println("server rev : "+inputData);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}