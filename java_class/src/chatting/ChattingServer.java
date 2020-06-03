package chatting;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChattingServer
{
	protected ServerSocket serverSocket;
	
	protected List<ChattingAgent> agentList = new ArrayList<ChattingAgent>();
	
	public void startServer() throws Exception
	{
		serverSocket = new ServerSocket(1201);

		while (true)
		{
			Socket socket = serverSocket.accept();
			ChattingAgent agent = new ChattingAgent(socket, this);
			new Thread(agent).start();
			
			agentList.add(agent);
		}
		
	}
	
	public void receiveMessage(String message) {
		for(ChattingAgent agent : agentList) {
			try {
				agent.send(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void notifyDisconnected(ChattingAgent agent)
	{
		agentList.remove(agent);
	}
		
	public static void main(String[] args)
	{
		try
		{
			ChattingServer server = new ChattingServer();
			server.startServer();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}