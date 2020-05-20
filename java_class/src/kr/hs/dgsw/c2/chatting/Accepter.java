package kr.hs.dgsw.c2.chatting;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 클라이언트가 접속하면 소켓을 만든다.
 */
public class Accepter implements Runnable
{
	protected ServerSocket serverSocket;
	
	protected ConnectionReceiver receiver;
	
	
	public Accepter(ServerSocket serverSocket, ConnectionReceiver connectionReceiver)
	{
		this.serverSocket = serverSocket;
		this.receiver = connectionReceiver;
	}
	

	@Override
	public void run()
	{
		try
		{
			System.out.println("클라이언트의 접속을 기다립니다.");
			
			while (true)
			{
				Socket socket = serverSocket.accept();
				
				if (receiver != null)
				{
					receiver.onClientConnected(socket);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}