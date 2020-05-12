package kr.hs.dgsw.c2.bbs;

import java.util.List;

public class Executor {

	public static void main(String[] args) {
		
		//Bulletin bulletin = new SimplestBulletin();
		Bulletin bulletin = new SimpleFileBulletin();
		
		Writing writing = null;
		
		writing = new Writing();
		writing.setTitle("������ ������?");
		writing.setContent("5�� 27���̿���.");
		writing.setWriter("������");
		
		bulletin.write(writing);
		
		
		writing = new Writing();
		writing.setTitle("��Ұ� ����");
		writing.setContent("���� �б� ���� �;�");
		writing.setWriter("�̿���");
		
		bulletin.write(writing);
		
		
		writing = new Writing();
		writing.setTitle("�ڷγ� �Ⱦ�");
		writing.setContent("����� �ʿ���");
		writing.setWriter("������");
		
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