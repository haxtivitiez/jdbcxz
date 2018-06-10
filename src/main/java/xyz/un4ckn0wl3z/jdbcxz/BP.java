package xyz.un4ckn0wl3z.jdbcxz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BP {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");

        PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){

            System.out.println("enter id");
            String s1=br.readLine();
            int id=Integer.parseInt(s1);

            System.out.println("enter name");
            String name=br.readLine();

            System.out.println("enter age");
            String age=br.readLine();


            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setString(3,age);

            ps.addBatch();
            System.out.println("Want to add more records y/n");
            String ans=br.readLine();
            if(ans.equals("n")){
                break;
            }

        }
        ps.executeBatch();

        System.out.println("record successfully saved");

        con.close();

    }
}
