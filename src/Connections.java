import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connections {
        public static void main(String[] args) {
        Connection conn=null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver LOADED");
       conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ujjwal","root","rajesh");
        System.out.println("Connection Established ");
      
    }
    catch (ClassNotFoundException e){
        System.out.println("Exception "+e.getMessage());
    }
    catch(SQLException e){
        System.out.println("Sql Exception "+e.getMessage());
    }
    try{
    conn.close();
    }
    catch (SQLException e){
        System.out.println("exception");
    }
    }
    }