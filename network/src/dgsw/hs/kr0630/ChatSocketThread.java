package dgsw.hs.kr0630;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ChatSocketThread extends Thread {
    Socket socket;
    String name;
    ChatSocketThread currentHandler;
    public final DataOutputStream out;  //외부 클래스에서 접근하여 출력
    public final DataInputStream in;
    //생성자를 통해 소캣 객체 전달 받음

    public ChatSocketThread(Socket socket, DataOutputStream out, DataInputStream in) {
        //3. 출력 스트림 선언
        this.out = out;
        this.in = in;
        this.socket = socket;
    }

    @Override
    public void run(){
        //1. 문자열 저장 버퍼 할당
        String temp;

//			//2. 입력 스트림 선언
//			InputStream is = socket.getInputStream();
//			DataInputStream in =new DataInputStream(is);

        try {
            //4. client ID 등록
            this.name = in.readUTF(); //한글 utf-8 enter 기준 read
            System.out.println("client id : " + this.name);
            //5. 멀티 채팅 시작
            while (true) {
                //6. 채팅 데이터 저장
                temp = in.readUTF();

                //7. 채팅 데이터 클라언트 전부에 전달
                for (ChatSocketThread handler : ChatServer.clients) {
                    currentHandler = handler;
                    String msg = this.name + " : " + temp;
                    System.out.println(msg);
                    handler.out.writeUTF(msg);
                }
            }
        }catch (Exception ie){
            try{
                ChatServer.clients.remove(currentHandler);
                ChatServer.idx = ChatServer.clients.size();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}