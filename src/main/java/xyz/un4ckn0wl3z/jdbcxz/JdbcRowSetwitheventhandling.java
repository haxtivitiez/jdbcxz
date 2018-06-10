package xyz.un4ckn0wl3z.jdbcxz;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class JdbcRowSetwitheventhandling {

    public static void main(String[] args) throws SQLException {
        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
        rowSet.setUrl("jdbc:mysql://localhost:3306/sonoo");
        rowSet.setUsername("root");
        rowSet.setPassword("1234");
        rowSet.setCommand("select * from emp");

        rowSet.execute();

        //Adding Listener and moving RowSet
        rowSet.addRowSetListener(new MyListener());

        while (rowSet.next()) {
            // Generating cursor Moved event
            System.out.println("Id: " + rowSet.getString(1));
            System.out.println("Name: " + rowSet.getString(2));
            System.out.println("Salary: " + rowSet.getString(3));
        }
    }
}


class MyListener implements RowSetListener {
    public void cursorMoved(RowSetEvent event) {
        System.out.println("Cursor Moved...");
    }
    public void rowChanged(RowSetEvent event) {
        System.out.println("Cursor Changed...");
    }
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("RowSet changed...");
    }
}