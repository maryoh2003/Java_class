package kr.hs.dgsw.c2.chatting;

public interface ClientMessageReceiver {
    public void onMessageReceive(String message);
    public void onClientDisconnected();
}
