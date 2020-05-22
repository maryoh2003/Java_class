package kr.hs.dgsw.c2.d0521;

import java.net.Socket;


public interface ConnectionReceiver
{
	public void onClientConnected(Socket socket);
	
}
