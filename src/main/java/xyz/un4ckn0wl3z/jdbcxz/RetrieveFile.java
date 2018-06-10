package xyz.un4ckn0wl3z.jdbcxz;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;

public class RetrieveFile {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");

        PreparedStatement ps=con.prepareStatement("select * from file");
        ResultSet rs=ps.executeQuery();
        rs.next();//now on 1st row

        Blob b=rs.getBlob(2);
        byte barr[]=b.getBytes(1,(int)b.length());//1 means first image

        FileOutputStream fout=new FileOutputStream("d:\\retrivefile.txt");
        fout.write(barr);

        fout.close();

        System.out.println("success");
    }
}
