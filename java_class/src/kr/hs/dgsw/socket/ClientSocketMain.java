package kr.hs.dgsw.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSocketMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress inet = InetAddress.getLocalHost();
			Socket socket = new Socket(inet, 6000);
			System.out.println("conneting");
			OutputStream output = socket.getOutputStream();
			PrintWriter out = new PrintWriter(output,true);
			InputStream input = socket.getInputStream();
			BufferedReader in = 
					new BufferedReader(new InputStreamReader(input));
			Scanner sc = new Scanner(System.in);
			while(true) {
				String inputData = "";
				if((inputData=in.readLine())!=null){
					System.out.println("Client rev : "+inputData);
				}
				System.out.print("client input data : ");
				inputData = sc.nextLine();
				out.println(inputData);
				
				
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}