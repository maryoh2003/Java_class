package kr.hs.dgsw.c2.d0506;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStudy {

	public static void main(String[] args) {
		
		try {
			
			//c ����̹��� java_study ��� ���丮�� �����Ѵ�.
			File directory = new File("c:\\java_study");
			System.out.println(directory.isFile()+" "+directory.isDirectory());
			
			if(directory.exists())
			{
				//���丮�� �����.
				directory.mkdir();
			}
			
			//java_study �Ʒ��� hello_txt��� ������ �����Ѵ�.
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
			
			System.out.println("������ ũ��: "+file.length());
			
			System.out.println("���� �̸�: "+file.getName());
			System.out.println("���� ���: "+file.getAbsolutePath());
			System.out.println("���� ���丮: "+file.getParent());
			
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
