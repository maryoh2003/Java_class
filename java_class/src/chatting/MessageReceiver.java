package chatting;

public interface MessageReceiver
{
	public void receiveMessage(String message);
	
	/*
	 * 클라이언트의 접속이 끊겼을 경우 호출된다.
	 * */
	public void notifyDisconnected();
}