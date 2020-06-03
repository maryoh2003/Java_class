package kr.hs.dgsw.c2.chatting;

import java.net.Socket;
import java.util.List;

public interface ClientAgent {
    public void start(Socket socket, List<Socket> socketList);
}
