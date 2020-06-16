import java.io.IOException;
import java.net.InetAddress;

public class IpChecker {

	public static void main(String[] args) {
		try {
			InetAddress inet = InetAddress.getByName("google.com");
			inet = InetAddress.getByName("13.107.42.12");
			checkIp(inet);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static void checkIp(InetAddress inet) throws IOException{
		System.out.println(inet);
		
		System.out.println("isAnyLocalAddress: " + inet.isAnyLocalAddress());
		System.out.println("isLoopbackAddress: " + inet.isLoopbackAddress());
		System.out.println("isLinkLocalAddress: " + inet.isLinkLocalAddress());
		System.out.println("isSiteLocalAddress: " + inet.isSiteLocalAddress());
		System.out.println("isMulticastAddress: " + inet.isMulticastAddress());
		System.out.println("isMCGlobal: " + inet.isMCGlobal());
		System.out.println("isMCLinkLocal: " + inet.isMCLinkLocal());
		System.out.println("isMCNodeLocal: " + inet.isMCNodeLocal());
	}
}
