package kr.hs.dgsw.c2.bbs;

import java.util.List;

public class Executor {

	public static void main(String[] args) {
		
		//Bulletin bulletin = new SimplestBulletin();
		Bulletin bulletin = new SimpleFileBulletin();
		
		Writing writing = null;
		
		writing = new Writing();
		writing.setTitle("개학은 언제죠?");
		writing.setContent("5월 27일이에요.");
		writing.setWriter("이찬민");
		
		bulletin.write(writing);
		
		
		writing = new Writing();
		writing.setTitle("대소고 만세");
		writing.setContent("빨리 학교 가고 싶어");
		writing.setWriter("이영은");
		
		bulletin.write(writing);
		
		
		writing = new Writing();
		writing.setTitle("코로나 싫어");
		writing.setContent("백신이 필요해");
		writing.setWriter("여동민");
		
		bulletin.write(writing);

		
		Writing second = bulletin.read(2);
		System.out.println(second.getTitle() + "  " + second.getContent());
		
		List<Writing> list = bulletin.list();
		for (Writing item : list)
		{
			System.out.println(item.getTitle() + " - " + item.getWriter());
		}
		
	}
	
}