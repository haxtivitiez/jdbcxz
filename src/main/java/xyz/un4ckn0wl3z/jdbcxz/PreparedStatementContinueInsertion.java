package xyz.un4ckn0wl3z.jdbcxz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementContinueInsertion {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");
        PreparedStatement pstmt=con.prepareStatement("insert into emp values(?,?,?)");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        try{

            do {
                System.out.println("enter id:");
                int id=Integer.parseInt(br.readLine());
                System.out.println("enter name:");
                String name=br.readLine();
                System.out.println("enter age:");
                String age=br.readLine();

                pstmt.setInt(1,id);
                pstmt.setString(2,name);
                pstmt.setString(3,age);
                int i=pstmt.executeUpdate();
                System.out.println(i+" records affected");

                System.out.println("Do you want to continue: y/n");
                String s=br.readLine();
                if(s.startsWith("n")){
                    break;
                }

            }while (true);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            con.close();
        }

    }
}
