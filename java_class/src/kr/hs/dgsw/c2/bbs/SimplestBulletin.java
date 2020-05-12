package kr.hs.dgsw.c2.bbs;

import java.util.ArrayList;
import java.util.List;

public class SimplestBulletin implements Bulletin {

	private List<Writing> list = new ArrayList<Writing>();
	
	private int pool = 0;
	
	@Override
	public void write(Writing writing) {
		pool++;
		writing.setIndex(pool);
		
		list.add(writing);
	}

	@Override
	public Writing read(int index) {

		for (Writing writing : list)
		{
			if (writing.getIndex() == index)
			{
				return writing;
			}
		}
		
		return null;
	}

	@Override
	public List<Writing> list() {
		return list;
	}

}