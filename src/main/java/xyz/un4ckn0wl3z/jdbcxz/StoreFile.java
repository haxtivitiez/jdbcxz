package xyz.un4ckn0wl3z.jdbcxz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreFile {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");

        PreparedStatement ps=con.prepareStatement("insert into file values(?,?)");
        File f=new File("d:\\myfile.txt");
        FileReader fr=new FileReader(f);

        ps.setInt(1,101);
        ps.setCharacterStream(2,fr,(int)f.length());
        int i=ps.executeUpdate();
        System.out.println(i+" records affected");

        con.close();
    }
}
