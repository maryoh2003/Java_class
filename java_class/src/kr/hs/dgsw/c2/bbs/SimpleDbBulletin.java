package kr.hs.dgsw.c2.bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SimpleDbBulletin implements Bulletin
{

	@Override
	public void write(Writing writing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Writing read(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Writing> list() {
		
		List<Writing> list = new ArrayList<Writing>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:mariadb://10.80.161.224/dgsw", 
					"root", "dgswjava");
			
			StringBuilder sql = new StringBuilder();		
			sql.append("SELECT	");
			sql.append("	id, 	");
			sql.append("	title, 	");
			sql.append("	conent, ");
			sql.append("	writer 	");
			sql.append("  FROM user	");
			sql.append(" ORDER BY id DESC	");
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				
				Writing writing = new Writing();
				writing.setIndex(id);
				writing.setTitle(title);
				writing.setContent(content);
				writing.setWriter(writer);
				
				list.add(writing);
				
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}
	
}
	