package kr.hs.dgsw.c2.d0521;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientReader implements Runnable
{
	protected InputStream is;
	
	protected OutputStream os;
	
	protected BufferedReader br;
	
	protected Socket temp;
	
	protected ClientMessageReceiver receiver;
	

	public ClientReader(InputStream is, OutputStream os, ClientMessageReceiver receiver, Socket temp)
	{
		this.is = is;
		this.os = os;
		this.receiver = receiver;
		this.temp = temp;
	}

	@Override
	public void run()
	{
		byte[] buffer = new byte[1024];
		int length;
		String message;
		
		try
		{
			while (true)
			{
				length = this.is.read(buffer);
				
				if (length < 0)
				{
					break;
				}
				message = new String(buffer, 0, length);
				
				if (receiver != null)
				{
					receiver.onMessageReceive(message, temp);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if (receiver != null)
			{
				receiver.onClientDisconnected();
			}
		}
	}
	
}