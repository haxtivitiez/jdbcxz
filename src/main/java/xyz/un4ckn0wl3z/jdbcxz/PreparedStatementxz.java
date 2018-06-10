package xyz.un4ckn0wl3z.jdbcxz;

import java.sql.*;

public class PreparedStatementxz {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");
        PreparedStatement pstmt = con.prepareStatement("insert into Emp values(?,?,?)");

        try {

            pstmt.setInt(1,5);
            pstmt.setString(2,"Neo");
            pstmt.setString(3,"22");
            int i=pstmt.executeUpdate();
            System.out.println(i+" records inserted");

            con.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
