package kr.hs.dgsw.c2.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class UrlConntionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://google.com:80");
			URLConnection uc = url.openConnection();
			InputStream input = uc.getInputStream();
			InputStreamReader inReader = new InputStreamReader(input);
			BufferedReader in = new BufferedReader(inReader);
//			uc.setDoOutput(true);
//			uc.connect();
//			OutputStream out = uc.getOutputStream();
			String line = "";
			while( (line = in.readLine()) != null) {
				System.out.println(line);
			}
			in.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}