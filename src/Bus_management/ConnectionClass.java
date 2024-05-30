package Bus_management;
import java.sql.*;
public class ConnectionClass{
    Connection con;
    Statement stm;
   ConnectionClass()
   {
       try{
       Class.forName("com.mysql.cj.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_management","root","password");
     stm = con.createStatement();
       if(con.isClosed())
           System.out.println("yes");
       else
       {
           System.out.println("No");
       }
       }
       catch (ClassNotFoundException e) {
           System.err.println("JDBC Driver not found: " + e.getMessage());
       } catch (SQLException e) {
           System.err.println("SQL Exception: " + e.getMessage());
       }

}
public static void  main (String args[])
{

    new ConnectionClass();
}
}
