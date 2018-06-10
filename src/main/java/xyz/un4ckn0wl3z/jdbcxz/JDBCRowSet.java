package xyz.un4ckn0wl3z.jdbcxz;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class JDBCRowSet {

    public static void main(String[] args) throws SQLException {
        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
        rowSet.setUrl("jdbc:mysql://localhost:3306/sonoo");
        rowSet.setUsername("root");
        rowSet.setPassword("1234");
        rowSet.setCommand("select * from emp");
        rowSet.execute();

        while (rowSet.next()) {
            // Generating cursor Moved event
            System.out.println("Id: " + rowSet.getString(1));
            System.out.println("Name: " + rowSet.getString(2));
            System.out.println("Salary: " + rowSet.getString(3));
        }
    }
}
