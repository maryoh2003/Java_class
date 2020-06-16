package kr.hs.dgsw.c2.bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SimpleDbBulletin2 implements Bulletin
{

	public void executeUpdate(JdbcStrategy strategy) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			Class.forName("org.mariadb.jdbc.driver");
			
			con = DriverManager.getConnection(
					"jdbc:mariadb://10.80.161.224/dgsw", "root", "dgswjava");
			
			pstmt = strategy.makePreparedStatement(con);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			try {
				pstmt.close();
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void write(Writing writing)
	{
		writing.setIndex(3);
		
		JdbcStrategy strategy = new JdbcStrategy() {
			
			@Override
			public PreparedStatement makePreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		executeUpdate(strategy);
		
	}

	public void update(Writing writing)
	{
		JdbcStrategy strategy = new BbsUpdateStrategy(writing);
		executeUpdate(strategy);
	}
	
	@Override
	public Writing read(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Writing> list()
	{
		/*
		 CREATE TABLE `bulletin` (
		  `id` int(11) NOT NULL,
		  `title` varchar(300) NOT NULL,
		  `content` text NOT NULL,
		  `writer` varchar(100) NOT NULL,
		  PRIMARY KEY (`id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 		 */
		
		List<Writing> list = new ArrayList<Writing>();
			
		try
		{
			Class.forName("org.mariadb.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:mariadb://10.80.161.224/dgsw", 
					"root", "dgswjava");
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT	");
			sql.append("	id, 		");
			sql.append("	title, 		");
			sql.append("	content, 	");
			sql.append("	writer 		");
			sql.append("  FROM user		");
			sql.append(" ORDER BY id DESC	");
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
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
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

}