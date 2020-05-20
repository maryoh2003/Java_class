package kr.hs.dgsw.c2.chatting;

import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer implements Server, ConnectionReceiver
{
	public static final int PORT = 1200;
	
	protected int port;
	

	@Override
	public void start(int port)
	{
		System.out.println("������ �����մϴ�. " + port);
	
		this.port = port;
		
		try
		{
			ServerSocket serverSocket = new ServerSocket(port);
			
			Accepter accepter = new Accepter(serverSocket, this);
			new Thread(accepter).start();
			
		}
		catch (Exception e)
		{
			System.out.println("[FATAL] ���α׷��� �����մϴ�.");
			e.printStackTrace();
		}
	}
	
	@Override
	public void onClientConnected(Socket socket)
	{
		System.out.println("Ŭ���̾�Ʈ�� �����߽��ϴ�. " + socket.toString());
		
		ClientAgent agent = new EchoServerAgent();
		agent.start(socket);
	}

	@Override
	public void terminate()
	{
		System.out.println("������ ����Ǿ����ϴ�.");
	}
	
	public static void main(String[] args)
	{
		try
		{
			Server server = new SimpleServer();
			server.start(PORT);
			
			//Thread.sleep(1000L);
			
			//server.terminate();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}