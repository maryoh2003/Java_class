package kr.hs.dgsw.c2.d0521;

import java.awt.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class EchoServerAgent implements ClientAgent, ClientMessageReceiver
{
	protected Socket socket;

	protected InputStream is;
	
	protected OutputStream os;
	
	protected ArrayList<Socket> list_client = new ArrayList<Socket>();
	
	
	@Override
	public void start(Socket socket, ArrayList<Socket> list_client)
	{
		this.socket = socket;
		this.list_client = list_client;
		
		try
		{
			this.is = this.socket.getInputStream();
			this.os = this.socket.getOutputStream();
			
			ClientReader reader = new ClientReader(is, os, this, this.socket);
			new Thread(reader).start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onMessageReceive(String message, Socket temp)
	{

		System.out.println("클라이언트로 부터 : " + message);
				
		send(message, temp);
			

	}
	
	@Override
	public void onClientDisconnected()
	{
		System.out.println("클라이언트의 접속이 끊어졌습니다.");
		
		try
		{
			this.is.close();
			this.os.close();
			this.socket.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	protected void send(String message, Socket temp)
	{
		for(int i =0; i < list_client.size(); i++) {
			try {
				if(list_client.get(i).isClosed()) {
					list_client.remove(i);
				}
				if(!list_client.get(i).equals(temp)) {
					os = this.list_client.get(i).getOutputStream();
					
					byte[] bytes = message.getBytes();
					
					this.os.write(bytes);
				}
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
		}
	}
	}

	
	