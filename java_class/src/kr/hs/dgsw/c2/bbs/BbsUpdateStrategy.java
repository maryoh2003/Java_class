package kr.hs.dgsw.c2.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BbsUpdateStrategy implements JdbcStrategy{
	
	Writing writing = null;
	
	public BbsUpdateStrategy(Writing writing) {

		this.writing=writing;
	}
	
	@Override
	public PreparedStatement makePreparedStatement(Connection con) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("update bulletin set ");
		sql.append(" title = ? ");
		sql.append(" content = ? ");
		sql.append("where id = ?");

		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, writing.getTitle());
		pstmt.setString(2, writing.getContent());
		pstmt.setInt(3, writing.getIndex());
		
		return null;
	}

}