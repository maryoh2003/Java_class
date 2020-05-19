package kr.hs.dgsw.c2.d0514;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SimpleFileBulletin implements Bulletin {

	private static final String PATH = "C:\\java_study\\bulletin.dat";
	
	private File file;
	
	private int index, temp, pool = 0;
	
	public SimpleFileBulletin() {

		file = new File(PATH);
		
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	
	}
	
	@Override
	public void write(Writing writing) {
		pool++;
		
		writing.setIndex(pool);
		try {
			
			PrintWriter out = new PrintWriter(new FileWriter(this.file, true));
			
			String line = String.valueOf(writing.getTitle()+"*"+writing.getContent()+"**"+writing.getWriter()+"***"+writing.getIndex()+"****");	// TODO writing 타입의 데이터를 문자열로 변환합니다.
			
			out.println(line);
			
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Writing read(int index2) {
		
		Writing read = new Writing();
		try {
			BufferedReader in = new BufferedReader(new FileReader(this.file));
			String line = null;
			while ((line = in.readLine()) != null)
				{
				index = line.indexOf("*");
				read.setTitle(line.substring(0,index));
				temp = index+1;
				index = line.indexOf("**");
				read.setContent(line.substring(temp ,index));
				temp = index+2;
				index = line.indexOf("***");
				read.setWriter(line.substring(temp ,index));
				temp = index+3;
				index = line.indexOf("****");
				read.setIndex(Integer.valueOf(line.substring(temp ,index)));
				
				if(index2==read.getIndex()) {
					return read;
				}
			}
		} catch (IOException e) {
				
		e.printStackTrace();
	}
		return null;
}

	@Override
	public List<Writing> list() {
		
		List<Writing> result = new ArrayList<Writing>();
		
		try {
			
			BufferedReader in = new BufferedReader(new FileReader(this.file));
			
			String line = null;
			while ((line = in.readLine()) != null)
			{
				// TODO line 에 있는 문자열을 writing type으로 변환한다.
				Writing writing = new Writing();
				index = line.indexOf("*");
				writing.setTitle(line.substring(0,index));
				temp = index;
				index = line.indexOf("**");
				writing.setContent(line.substring(temp ,index));
				temp = index+2;
				index = line.indexOf("***");
				writing.setWriter(line.substring(temp ,index));
				temp = index+3;
				index = line.indexOf("****");
				writing.setIndex(Integer.valueOf(line.substring(temp ,index)));
				
				result.add(writing);
			}
			
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}

