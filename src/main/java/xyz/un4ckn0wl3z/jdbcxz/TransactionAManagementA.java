package xyz.un4ckn0wl3z.jdbcxz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionAManagementA {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");

        con.setAutoCommit(false);

        Statement stmt=con.createStatement();
        stmt.executeUpdate("insert into emp values(190,'abhi',40000)");
        stmt.executeUpdate("insert into emp values(191,'umesh',50000)");

        con.commit();
        con.close();

    }
}
