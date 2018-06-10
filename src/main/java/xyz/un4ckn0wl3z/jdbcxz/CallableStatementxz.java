package xyz.un4ckn0wl3z.jdbcxz;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementxz {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");

        CallableStatement stmt=con.prepareCall("{call addEmp(?,?,?)}");
        stmt.setInt(1,1011);
        stmt.setString(2,"Amit");
        stmt.setString(3,"26");
        stmt.execute();

        System.out.println("success");
    }
}
