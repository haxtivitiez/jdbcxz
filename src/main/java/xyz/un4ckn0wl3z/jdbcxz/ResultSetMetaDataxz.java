package xyz.un4ckn0wl3z.jdbcxz;

import java.sql.*;

public class ResultSetMetaDataxz {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","1234");
        PreparedStatement pstmt=con.prepareStatement("select * from emp");
      try {
          ResultSet rs=pstmt.executeQuery();
          ResultSetMetaData rsmd=rs.getMetaData();

          System.out.println("Total columns: "+rsmd.getColumnCount());
          System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
          System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));
      }catch (Exception e){
          e.printStackTrace();
      }finally {
          con.close();
      }

    }
}
