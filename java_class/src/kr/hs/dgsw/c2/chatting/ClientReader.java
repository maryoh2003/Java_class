package kr.hs.dgsw.c2.chatting;

import java.io.InputStream;

/**
 * 클라이언트에서 보내온 메시지를 받아서 서버에 전달한다.
 */
public class ClientReader implements Runnable
{
    protected InputStream is;
    protected ClientMessageReceiver receiver;

    public ClientReader(InputStream is, ClientMessageReceiver receiver)
    {
        this.is = is;
        this.receiver = receiver;
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
                    receiver.onMessageReceive(message);
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