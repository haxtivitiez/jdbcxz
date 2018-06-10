package xyz.un4ckn0wl3z.jdbcxz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class RetrieveImage {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");

        PreparedStatement ps=con.prepareStatement("select * from image");
        ResultSet rs=ps.executeQuery();
        if(rs.next()){//now on 1st row

            Blob b=rs.getBlob(2);//2 means 2nd column data
            byte barr[]=b.getBytes(1,(int)b.length());//1 means first image

            FileOutputStream fout=new FileOutputStream("d:\\sonoo.jpg");
            fout.write(barr);

            fout.close();
        }//end of if
        System.out.println("ok");

        con.close();
    }
}
