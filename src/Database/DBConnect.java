
package Database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.spi.DirStateFactory;



public class DBConnect {
   
    
    
    public static Connection baglan() throws SQLException{
       
        Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/system","root","12345");
        
        return connect;
    }
    
   
    
    public static void main(String[] args) throws SQLException{
         DBConnect d = new DBConnect();
  
        
       // System.out.println("alisan");
    }
}
