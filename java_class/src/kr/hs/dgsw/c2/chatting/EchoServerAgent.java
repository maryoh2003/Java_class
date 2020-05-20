package kr.hs.dgsw.c2.chatting;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoServerAgent implements ClientAgent, ClientMessageReceiver
{
	protected Socket socket;

	protected InputStream is;
	
	protected OutputStream os;
	
	
	@Override
	public void start(Socket socket)
	{
		this.socket = socket;
		
		try
		{
			this.is = this.socket.getInputStream();
			this.os = this.socket.getOutputStream();
			
			ClientReader reader = new ClientReader(is, this);
			new Thread(reader).start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onMessageReceive(String message)
	{
		System.out.println("Ŭ���̾�Ʈ �޽��� : " + message);
		
		// Ŭ���̾�Ʈ�� message�� �����ش�.
		send(message);
	}
	
	protected void send(String message)
	{
		byte[] bytes = message.getBytes();
		
		try
		{
			this.os.write(bytes);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
}