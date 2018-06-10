package xyz.un4ckn0wl3z.jdbcxz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecord {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");
        Statement stmt = con.createStatement();
        try {
            // stmt.executeUpdate("insert into emp values(33,'Irfan',50000)");
            //int result=stmt.executeUpdate("update emp set name='Vimal' where id=33");
            int result=stmt.executeUpdate("delete from emp where id=33");
            System.out.println(result+" records affected");
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
