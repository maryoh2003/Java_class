package kr.hs.dgsw.c2.chatting;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

public class EchoServerAgent implements ClientAgent, ClientMessageReceiver
{
    protected Socket socket;
    protected InputStream is;
    protected OutputStream os;
    private List<Socket> socketList = null;

    @Override
    public void start(Socket socket, List<Socket> socketList)
    {
        this.socket = socket;
        this.socketList = socketList;

        try
        {
            this.is = this.socket.getInputStream();
            this.os = this.socket.getOutputStream();

            ClientReader reader = new ClientReader(is, this);
            new Thread(reader).start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessageReceive(String message)
    {
        System.out.println("클라이언트 메시지 : " + message);

        // 클라이언트로 message을 보내준다.
        send(message);
    }

    @Override
    public void onClientDisconnected()
    {
        System.out.println("클라이언트의 접속이 끊어졌습니다.");
        try
        {
            this.is.close();
            this.os.close();
            this.socket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    protected void send(String message)
    {
        byte[] bytes = message.getBytes();

        try
        {
            for(Socket socket : socketList){
                this.os = socket.getOutputStream();
                this.os.write(bytes);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}