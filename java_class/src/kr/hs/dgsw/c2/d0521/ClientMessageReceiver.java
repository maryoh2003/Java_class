package kr.hs.dgsw.c2.d0521;

import java.io.PrintWriter;
import java.net.Socket;

public interface ClientMessageReceiver
{

	public void onMessageReceive(String message, Socket temp);
	
	public void onClientDisconnected();
	
}