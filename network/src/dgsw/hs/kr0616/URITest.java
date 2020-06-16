package dgsw.hs.kr0616;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URITest {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=%EB%8C%80%EA%B5%AC+%EB%82%A0%EC%94%A8");
            showURIInfo(uri);
            URL url = new URL("https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=%EB%8C%80%EA%B5%AC+%EB%82%A0%EC%94%A8");
            showURLInfo(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void showURLInfo(URL url) {
        System.out.println("URL info");
        System.out.println("url protocol : " + url.getProtocol());
        System.out.println("url host : " + url.getHost());
        System.out.println("url path : " + url.getPath());
        try {
            System.out.println("url content : " + url.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("url port : " + url.getPort());
        System.out.println("url query : " + url.getQuery());
        System.out.println("url auth : " + url.getAuthority());
        System.out.println("url userinfo : " + url.getUserInfo());
    }

    private static void showURIInfo(URI uri) {
        System.out.println("URI info");
        System.out.println("uri scheme : " + uri.getScheme());
        System.out.println("uri host : " + uri.getHost());
        System.out.println("uri path : " + uri.getPath());
        System.out.println("uri fragment : " + uri.getFragment());
        System.out.println("uri port : " + uri.getPort());
        System.out.println("uri query : " + uri.getQuery());
        System.out.println("uri auth : " + uri.getAuthority());
        System.out.println("uri userinfo : " + uri.getUserInfo());
    }
}
