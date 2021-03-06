package dgsw.hs.kr0616;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpChecker {

    public static void main(String[] args) {
        try {
            InetAddress inet = InetAddress.getByName("google.com");
            inet = InetAddress.getLocalHost();
            checkIp(inet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkIp(InetAddress inet) throws IOException{
        System.out.println(inet);

        //도메인 도달 가능성
        System.out.println("isReachable : " + inet.isReachable(1000));
        //
        System.out.println("isAnyLocalAddress : " + inet.isAnyLocalAddress());
        System.out.println("isLoopbackAddress : " + inet.isLoopbackAddress());
        System.out.println("isLinkLocalAddress : " + inet.isLinkLocalAddress());
        System.out.println("isSiteLocalAddress : " + inet.isSiteLocalAddress());
        System.out.println("isMulticastAddress : " + inet.isMulticastAddress());
        System.out.println("isMCGlobal : " + inet.isMCGlobal());
        System.out.println("isMCLinkLocal : " + inet.isMCLinkLocal());
        System.out.println("isMCNodeLocal : " + inet.isMCNodeLocal());
        System.out.println("isMCOrgLocal : " + inet.isMCOrgLocal());
    }
}
