package xyz.un4ckn0wl3z.jdbcxz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDelete {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");
        PreparedStatement pstmt=con.prepareStatement("delete from emp where id=?");

        try {
            pstmt.setInt(1,4);
            int i=pstmt.executeUpdate();
            System.out.println(i+" records deleted");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            con.close();
        }

    }
}
