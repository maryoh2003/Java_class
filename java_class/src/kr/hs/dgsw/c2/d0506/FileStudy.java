package kr.hs.dgsw.c2.d0506;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStudy {

	public static void main(String[] args) {
		
		try {
			
			//c 드라이버에 java_study 라는 디렉토리를 생성한다.
			File directory = new File("c:\\java_study");
			System.out.println(directory.isFile()+" "+directory.isDirectory());
			
			if(directory.exists())
			{
				//디렉토리를 만든다.
				directory.mkdir();
			}
			
			//java_study 아래에 hello_txt라는 파일을 생성한다.
			File file = new File(directory, "hello.txt");
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			OutputStream os = new FileOutputStream(file);
			os.write("Hello Word".getBytes());
			os.close();
			
			InputStream is = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int length = is.read(buffer);
			String txt = new String(buffer, 0, length);
			is.close();
			
			System.out.println("READ : "+ txt);
			
			System.out.println("파일의 크기: "+file.length());
			
			System.out.println("파일 이름: "+file.getName());
			System.out.println("파일 경로: "+file.getAbsolutePath());
			System.out.println("파일 디렉토리: "+file.getParent());
			
			String[] list = directory.list();
			File[] fileList = directory.listFiles();
			
			System.out.println("list : ");
			for(String name : list)
			{
				System.out.println(" "+ name);
			}
			
			System.out.println("fileList : ");
			for(File item : fileList)
			{
				System.out.println(" "+ item.getAbsolutePath()+ " "+ item.isDirectory());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
