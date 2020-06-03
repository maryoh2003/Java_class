package kr.hs.dgsw.c2.bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest {
    public static void main(String[] args) {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("OK");

            // 데이터베이스에 접속한다
            Connection con = DriverManager.getConnection("jdbc:mariadb://10.80.161.224/dgsw", "root", "dgswjava");


            // SQL을 작성한다
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ");
            sql.append("    user_id, ");
            sql.append("    user_name, ");
            sql.append("    phone_number, ");
            sql.append("    password ");
            sql.append("  FROM user ");
            sql.append(" ORDER BY user_name ");

            // SELECT user_id, user_name, phone_number, password FROM user;

            // SQL을 수행한다.
            PreparedStatement pstmt = con.prepareStatement(sql.toString());

            ResultSet rs = pstmt.executeQuery();

            // 데이터베이스에서 받은 데이터를 처리한다.
            while (rs.next())
            {
                String userId = rs.getString("user_id");
                String userName = rs.getString("user_name");
                String phoneNumber = rs.getString("phone_number");
                String password = rs.getString("password");
                System.out.println(userId + " " + userName + " " + phoneNumber + " " + password);
            }

            // 자원을 해제한다.
            con.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
