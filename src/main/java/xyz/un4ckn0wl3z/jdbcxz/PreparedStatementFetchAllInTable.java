package xyz.un4ckn0wl3z.jdbcxz;

import java.sql.*;

public class PreparedStatementFetchAllInTable {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");
        PreparedStatement pstmt=con.prepareStatement("select * from emp");

        try {
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();
            //
        }finally {
            con.close();
        }

    }
}
