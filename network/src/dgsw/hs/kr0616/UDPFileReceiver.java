package dgsw.hs.kr0616;

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class UDPFileReceiver {
	public static final int PORT = 8500;
	public static final int BUFF_SIZE = 10000; 
	public static final String DOWNLOAD = "C:\\download\\a.txt";
	
	public static void main(String[] args) {
		System.out.println("udp server start");
		try {
			DatagramSocket ds = new DatagramSocket(PORT);
			//���� ����
			byte[] buff = new byte[BUFF_SIZE];
			
			//������ ���� ����
			FileOutputStream fout = new FileOutputStream(DOWNLOAD);
			
			DatagramPacket dp = new DatagramPacket(buff, BUFF_SIZE);
			ds.receive(dp);
			//1.���ϸ� ����
			String temp = new String (dp.getData()).trim(); //trim���� ��������
			System.out.println("file name" +temp);
			//2.���� ������ ����
			dp = new DatagramPacket(buff, BUFF_SIZE);
			ds.receive(dp);
			temp = new String(dp.getData()).trim(); //���� ������
			long fileSize = Long.parseLong(temp);
			//3.���� ����
			dp = new DatagramPacket(buff, BUFF_SIZE);
			long totalReadSize = 0;
			int readSize = 0;
			while(true) {
				ds.receive(dp); //���ϼ���
				readSize = dp.getLength();
				totalReadSize += readSize;
				//���� ����
				fout.write(dp.getData(), 0, readSize);
				if(totalReadSize >= fileSize) {
					break;
				}
			}
			System.out.println("file save complete");
			fout.close(); //���� ����
			ds.close(); //OS�� ��Ʈ ��ȯ
			
		} catch(Exception e) {
			
		}
		
	}
}
