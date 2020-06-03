package chatting;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChattingAgent implements Runnable, MessageReceiver
{
	protected Socket socket;
	protected InputStream is;
	protected OutputStream os;
	protected ChattingServer server;
	
	public ChattingAgent(Socket socket, ChattingServer server) throws Exception
	{
		this.socket = socket;
		this.is = socket.getInputStream();
		this.os = socket.getOutputStream();
		this.server = server;
	}
	
	public void close() throws Exception
	{
		this.is.close();
		this.os.close();
		this.socket.close();
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
		server.receiveMessage(message);
	}
	
	@Override
	public void notifyDisconnected() 
	{
		try {
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//서버에서 보고한다.
	}
	
	@Override
	public void run()
	{
		startListener();
		
	}
}