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
		System.out.println("클라이언트 메시지 : " + message);
		
		// 클라이언트로 message을 보내준다.
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