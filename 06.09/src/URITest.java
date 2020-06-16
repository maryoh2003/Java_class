import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class URITest{
	public static void main(String[] args) {
		URI uri;
		try {
			uri = new URI("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=104&oid=001&aid=0011664686");
			showURIInfo(uri);
			URL url;
			url = new URL("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=104&oid=001&aid=0011664686");
			showURLInfo(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void showURLInfo(URL url) {
		System.out.println("URI info");
		System.out.println("uri protocol : "+ url.getProtocol());
		System.out.println("uri host : "+ url.getHost());
		System.out.println("uri path : "+ url.getPath());
		try {
			System.out.println("uri content : "+ url.getContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("uri port : "+ url.getPort());
		System.out.println("uri query : "+ url.getQuery());
		System.out.println("uri auth : "+ url.getAuthority());
		System.out.println("uri userinfo : "+ url.getUserInfo());
		
	}

	private static void showURIInfo(URI uri) {
		System.out.println("URI info");
		System.out.println("uri scheme : "+ uri.getScheme());
		System.out.println("uri host : "+ uri.getHost());
		System.out.println("uri path : "+ uri.getPath());
		System.out.println("uri fragment : "+ uri.getFragment());
		System.out.println("uri port : "+ uri.getPort());
		System.out.println("uri query : "+ uri.getQuery());
		System.out.println("uri auth : "+ uri.getAuthority());
		System.out.println("uri userinfo : "+ uri.getUserInfo());
	}
  }

