package kr.hs.dgsw.c2.chatting;

import java.net.Socket;

/**
 * Ŭ���̾�Ʈ�� �������� ��, �̸� �˷��ִ� ������ �����ϴ�.
 *
 */
public interface ConnectionReceiver
{

	/**
	 * Ŭ���̾�Ʈ�� ���ӵǸ� ȣ��ȴ�.
	 * 
	 * @param socket
	 */
	public void onClientConnected(Socket socket);
	
}