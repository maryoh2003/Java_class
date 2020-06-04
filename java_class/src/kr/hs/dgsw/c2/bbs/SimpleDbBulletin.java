package kr.hs.dgsw.c2.bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

	public class SimpleDbBulletin implements Bulletin {

	    private final String className = "org.mariadb.jdbc.Driver";

	    private final String dbUrl = "jdbc:mariadb://10.80.162.230/inquiry";
	    private final String dbUser = "root";
	    private final String dbPassword = "*anna0809";
	    private int pool = 0;

	    @Override
	    public void write(Writing writing) {
	        pool++;

	        try {
	            Class.forName(className);
	            System.out.println("OK");
	            
	            // DB Connect
	            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

	            StringBuilder sql = new StringBuilder();
	            sql.append("INSERT INTO bulletin    ");
	            sql.append("    (id, title, content, writer)    ");
	            sql.append("    VALUES  ");
	            sql.append("    (?, ?, ?, ?)    ");

	            // Play SQL
	            PreparedStatement preparedStatement = con.prepareStatement(sql.toString());
	            preparedStatement.setString(1, pool+"");	
	            preparedStatement.setString(2, writing.getTitle());
	            preparedStatement.setString(3, writing.getContent());
	            preparedStatement.setString(4, writing.getWriter());

	            preparedStatement.executeUpdate();

	            con.close();
	            preparedStatement.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Writing read(int index) {
	        for (Writing writing : list()) {
	            if (writing.getIndex() == index) {
	                return writing;
	            }
	        }
	        return null;
	    }

	    @Override
	    public List<Writing> list() {

	        List<Writing> list = new ArrayList<>();

	        try {
	            Class.forName(className);
	            System.out.println("OK");

	            // DB Connect
	            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

	            StringBuilder sql = new StringBuilder();
	            sql.append("SELECT  ");
	            sql.append("    id, ");
	            sql.append("    title, ");
	            sql.append("    content, ");
	            sql.append("    writer ");
	            sql.append("    FROM Bulletin ");
	            sql.append("    ORDER BY id DESC ");

	            PreparedStatement preparedStatement = con.prepareStatement(sql.toString());
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Writing writing = new Writing();
	                writing.setIndex(resultSet.getInt("id"));
	                writing.setTitle(resultSet.getString("title"));
	                writing.setContent(resultSet.getString("content"));
	                writing.setWriter(resultSet.getString("writer"));
	                list.add(writing);
	                System.out.println(writing.getIndex() + " " + writing.getTitle() + " " + writing.getContent() + " " + writing.getWriter());
	            }

	            resultSet.close();
	            preparedStatement.close();
	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	}
	

	