package xyz.un4ckn0wl3z.jdbcxz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementUpdate {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");
        PreparedStatement pstmt=con.prepareStatement("update emp set name=? where id=?");

        try {
            pstmt.setString(1,"Sonoo");//1 specifies the first parameter in the query i.e. name
            pstmt.setInt(2,5);
            int i=pstmt.executeUpdate();
            System.out.println(i+" records updated");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            con.close();
        }

    }
}
