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

            // �����ͺ��̽��� �����Ѵ�
            Connection con = DriverManager.getConnection("jdbc:mariadb://10.80.161.224/dgsw", "root", "dgswjava");


            // SQL�� �ۼ��Ѵ�
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ");
            sql.append("    user_id, ");
            sql.append("    user_name, ");
            sql.append("    phone_number, ");
            sql.append("    password ");
            sql.append("  FROM user ");
            sql.append(" ORDER BY user_name ");

            // SELECT user_id, user_name, phone_number, password FROM user;

            // SQL�� �����Ѵ�.
            PreparedStatement pstmt = con.prepareStatement(sql.toString());

            ResultSet rs = pstmt.executeQuery();

            // �����ͺ��̽����� ���� �����͸� ó���Ѵ�.
            while (rs.next())
            {
                String userId = rs.getString("user_id");
                String userName = rs.getString("user_name");
                String phoneNumber = rs.getString("phone_number");
                String password = rs.getString("password");
                System.out.println(userId + " " + userName + " " + phoneNumber + " " + password);
            }

            // �ڿ��� �����Ѵ�.
            con.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
