package kr.hs.dgsw.c2.d0521;

import java.awt.List;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SimpleServer implements Server, ConnectionReceiver
{
	public static final int PORT = 930;
	
	protected int port;
	
	protected ArrayList<Socket> list_client = new ArrayList<Socket>();
	

	@Override
	public void start(int port)
	{
		System.out.println("서버를 시작합니다. " + port);
	
		this.port = port;
		
		try
		{
			ServerSocket serverSocket = new ServerSocket(port);
			
			Accepter accepter = new Accepter(serverSocket, this);
			new Thread(accepter).start();
			
		}
		catch (Exception e)
		{
			System.out.println("[FATAL] 프로그램을 종료합니다.");
			e.printStackTrace();
		}
	}
	
	@Override
	public void onClientConnected(Socket socket)
	{
		System.out.println("클라이언트가 접속했습니다. " + socket.toString());
		
		list_client.add(socket);
		
		ClientAgent agent = new EchoServerAgent();
		agent.start(socket, list_client);
	}

	@Override
	public void terminate()
	{
		System.out.println("서버가 종료되었습니다.");
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
