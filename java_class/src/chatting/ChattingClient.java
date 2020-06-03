package chatting;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChattingClient implements MessageReceiver
{
	protected Socket socket;
	protected InputStream is;
	protected OutputStream os;
	protected Scanner scanner;
	
	public void connect(String addr, int port) throws Exception
	{
		this.socket = new Socket(addr, port);
		this.is = this.socket.getInputStream();
		this.os = this.socket.getOutputStream();
	}
	
	public void close() throws Exception
	{
		this.is.close();
		this.os.close();
		this.socket.close();
		this.scanner.close();
	}
	
	public void send(String message) throws Exception
	{
		this.os.write(message.getBytes());
	}
	
	public void startListener()
	{
		Listener listener = new Listener(is, this);
		new Thread(listener).start();
	}
	
	@Override
	public void receiveMessage(String message)
	{
		// 처리해준다.
		System.out.println("RECV : " + message);
	}
	
	@Override
	public void notifyDisconnected() {
		// do nothing
	}
	
	public void startUserInput() throws Exception
	{
		scanner = new Scanner(System.in);
		
		while (true)
		{
			String input = scanner.nextLine();
			
			if ("quit".equals(input))
			{
				break;
			}
			
			send(input);
		}
		
		close();
	}
	
	public static void main(String[] args)
	{
		try
		{
			ChattingClient client = new ChattingClient();
			
			client.connect("10.80.161.224", 1201);
			//client.connect("localhost", 1201);
			client.startListener();
			
			client.startUserInput();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}















}
