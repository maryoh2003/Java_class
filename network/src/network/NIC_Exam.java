package network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

public class NIC_Exam {

	public static void main(String[] args) {
		NIC_Exam exam = new NIC_Exam();
		exam.printNetworkInfo();
	}
	public void printNetworkInfo() {
		try {
//			NetworkInterface nic = 
					//NetworkInterface.getByName("10.80.163.192");
//					NetworkInterface.getByInetAddress
//					(InetAddress.getLocalHost());
//					System.out.println(nic);
//					showNIC(nic);
			Enumeration<NetworkInterface> nics =
							NetworkInterface.getNetworkInterfaces();
			ArrayList<NetworkInterface> list = 
					 Collections.list(nics);
			for(int i = 0 ;i<list.size();i++) {
				showNIC(list.get(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void showNIC(NetworkInterface nic) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println(nic.getDisplayName());
		System.out.println(nic.getName());
		Enumeration<InetAddress> inets = nic.getInetAddresses();
		ArrayList<InetAddress> list = 
				 Collections.list(inets);
		for(int i = 0 ;i<list.size();i++) {
			System.out.println(i + " : "+list.get(i));
		}
		try {
			byte[] macs = 
					nic.getHardwareAddress();
			String MAC = "";
			if(macs!=null)
			for(int i=0;i<macs.length;i++) {
				//MAC += macs[i] +" ";
				MAC += String.format("%X ", macs[i]);
			}
			System.out.println(MAC);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}