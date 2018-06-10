package xyz.un4ckn0wl3z.jdbcxz;

import java.sql.*;

public class DatabaseMetaDataxz {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");

        try{

           DatabaseMetaData dbmd=con.getMetaData();
           System.out.println("Driver Name: "+dbmd.getDriverName());
           System.out.println("Driver Version: "+dbmd.getDriverVersion());
           System.out.println("UserName: "+dbmd.getUserName());
           System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
           System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());

            String table[]={"TABLE"};
            ResultSet rs=dbmd.getTables(null,null,null,table);
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
            }

            con.close();
       }catch (Exception e){
           e.printStackTrace();
       }finally {
            con.close();
       }

    }
}
