package kr.hs.dgsw.c2.chatting;

import java.net.Socket;

/**
 * 클라이언트가 접속했을 때, 이를 알려주는 역할을 수행하다.
 *
 */
public interface ConnectionReceiver
{

	/**
	 * 클라이언트가 접속되면 호출된다.
	 * 
	 * @param socket
	 */
	public void onClientConnected(Socket socket);
	
}