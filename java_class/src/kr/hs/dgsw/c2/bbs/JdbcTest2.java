package kr.hs.dgsw.c2.bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcTest2 {
	
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("org.mariadb.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:mariadb://10.80.161.224/dgsw",
					"root",
					"dgswjava");
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO user ");
			sql.append(" (user_id, user_name, phone_number, password) ");
			sql.append("VALUES ");
			sql.append(" (?, ?, ?, ?)");
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "noah");
			pstmt.setString(2, "³ë¾Æ");
			pstmt.setString(3, "010-1111-2222");
			pstmt.setString(4, "zzaaf");
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
