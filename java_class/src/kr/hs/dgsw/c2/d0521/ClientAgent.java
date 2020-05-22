package kr.hs.dgsw.c2.d0521;

import java.awt.List;
import java.net.Socket;
import java.util.ArrayList;

public interface ClientAgent
{

	public void start(Socket socket, ArrayList<Socket> list_client);
	
}