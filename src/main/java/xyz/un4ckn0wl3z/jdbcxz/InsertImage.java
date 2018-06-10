package xyz.un4ckn0wl3z.jdbcxz;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImage {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");

        try {
            PreparedStatement ps=con.prepareStatement("insert into image values(?,?)");
            ps.setInt(1,1);
            FileInputStream fin=new FileInputStream("d:\\g.jpg");
            ps.setBinaryStream(2,fin,fin.available());
            int i=ps.executeUpdate();
            System.out.println(i+" records affected");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            con.close();
        }



    }
}
