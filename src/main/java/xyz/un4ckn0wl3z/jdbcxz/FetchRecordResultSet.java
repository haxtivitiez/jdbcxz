package xyz.un4ckn0wl3z.jdbcxz;

import java.sql.*;

public class FetchRecordResultSet {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from emp");
        try{
            //getting the record of 3rd row
            rs.absolute(3);
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));

            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
