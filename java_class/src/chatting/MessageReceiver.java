package chatting;

public interface MessageReceiver
{
	public void receiveMessage(String message);
	
	/*
	 * Ŭ���̾�Ʈ�� ������ ������ ��� ȣ��ȴ�.
	 * */
	public void notifyDisconnected();
}