package dgsw.hs.kr.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkMain {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://google.com");
			System.out.println("Host" + url.getHost()); //google.com
			System.out.println("Protocol" + url.getProtocol()); //http
			System.out.println("Port" + url.getPort()); //공개안함
			System.out.println("FileName" + url.getFile()); 
			System.out.println("Path" + url.getPath());
			
			//바이트 단위 입출력을 위한 최상위 입출력 스트림 클래스
			InputStream input = url.openStream();
			
			//문자 단위 입출력을 위한 하위 스트림 클래스
			InputStreamReader inReader = new InputStreamReader(input);
			
			//많은 양의 데이터를 입력받을 경우 BufferedReader 사용
			BufferedReader in = new BufferedReader(inReader);
			
			String line = "";
			
			while((line = in.readLine()) != null)
			{
				System.out.println("Data" + line);
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
