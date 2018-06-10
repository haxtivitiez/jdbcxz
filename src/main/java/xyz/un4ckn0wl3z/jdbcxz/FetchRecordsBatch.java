package xyz.un4ckn0wl3z.jdbcxz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecordsBatch {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");

        con.setAutoCommit(false);

        Statement stmt=con.createStatement();
        stmt.addBatch("insert into emp values(88,'abshi',40000)");
        stmt.addBatch("insert into emp values(77,'umdesh',50000)");

        stmt.executeBatch();//executing the batch

        con.commit();
        con.close();
    }
}
