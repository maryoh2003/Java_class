package chatting;

import java.io.InputStream;

public class Listener implements Runnable
{
	protected InputStream is;
	protected MessageReceiver client;
	
	public Listener(InputStream is, MessageReceiver client)
	{
		this.is = is;
		this.client = client;
	}

	@Override
	public void run()
	{
		try
		{
			byte[] buffer = new byte[128];
			int length;
			
			while (true)
			{
				length = this.is.read(buffer);
				
				if (length <= 0)
				{
					break;
				}
				
				String message = new String(buffer, 0, length);
				//System.out.println("RECV : " + message);
				
				client.receiveMessage(message);
			}
		}
		catch (Exception e)
		{
		}
		
		client.notifyDisconnected();
				
	}
	
}