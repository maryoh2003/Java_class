package dgsw.hs.kr.url;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class InetTest {
	public static void main(String[] args) {
		try
		{
			// Inet
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("Address : " + address.getHostName());
			System.out.println("Address : " + address.getHostAddress());
			
			// NetWorkIO
			// SocketChannel : TCP를 통해서 네트워크에서 데이터를 읽거나 씁니다.
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress(address, 80));
			while(!socketChannel.finishConnect())
			{
			}
			System.out.println(socketChannel);
			System.out.println(socketChannel.isConnected());
			
			/* Blocking(블로킹)
			블로킹은 말 그대로 작업이 중단된다는 의미이다.
			네트워크 통신에서 요청이 발생하고 완료딜 때까지 모든 일을 중단한 상태로 대기해야 하는 것을 블로킹 방식이라고 한다.
			블로킹 방식의 소켓통신은 결과가 올 때까지 다른 작업을 중단하고 하염없이 기다리게 된다. */
			System.out.println(socketChannel.isBlocking());
			
			// allocate : 할당
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			System.out.println("Buffer : " + buffer);
			int byteRead = socketChannel.read(buffer);
			System.out.println("ByteRead : " + byteRead);
			if(byteRead > 0)
			{
				buffer.flip(); //버퍼의 값을 넣고 빼고 하면서 비워줌(버퍼를 재사용하기 위해서 clear하는거)
				while(buffer.hasRemaining()) 
				{
					System.out.println(buffer.getChar());
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
