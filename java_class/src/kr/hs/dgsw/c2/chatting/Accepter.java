package kr.hs.dgsw.c2.chatting;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Ŭ���̾�Ʈ�� �����ϸ� ������ �����.
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
			System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�.");
			
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