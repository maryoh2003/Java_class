package kr.hs.dgsw.c2.bbs;

import java.util.List;

public interface Bulletin {

	public void write(Writing writing);
	
	public Writing read(int index);
	
	public List<Writing> list();
	
}