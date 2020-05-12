package kr.hs.dgsw.c2.bbs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SimpleFileBulletin implements Bulletin {

	private static final String PATH = "C:\\java_study\\bulletin.dat";
	
	private File file;
	
	public SimpleFileBulletin() {

		// TODO 파일 시스템에서 파일을 가져온다.
		
		// TODO 만약 파일이 없다면 생성한다.
	}
	
	@Override
	public void write(Writing writing) {
		
		try {
			
			PrintWriter out = new PrintWriter(new FileWriter(this.file, true));
			
			String line = null;	// TODO writing 타입의 데이터를 문자열로 변환합니다.
			out.println(line);
			
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Writing read(int index) {
		// TODO Auto-generated method stub
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
				
				result.add(writing);
			}
			
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}