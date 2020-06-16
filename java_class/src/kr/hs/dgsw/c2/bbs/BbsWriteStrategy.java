package kr.hs.dgsw.c2.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BbsWriteStrategy implements JdbcStrategy {

	private Writing writing;

	public BbsWriteStrategy(Writing writing) {
		this.writing = writing;
	}

	@Override
	public PreparedStatement makePreparedStatement(Connection con) throws SQLException{

		StringBuilder sql = new StringBuilder();
		sql.append("insert bulletin ");
		sql.append(" (id, title, content, writer) ");
		sql.append(" values ");
		sql.append(" (?,?,?,?)");

		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		pstmt.setInt(1, writing.getIndex());
		pstmt.setString(2, writing.getTitle());
		pstmt.setString(3, writing.getContent());
		pstmt.setString(4, writing.getWriter());

		return pstmt;
	}
}