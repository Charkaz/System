
package hesab;

import Database.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Charkaz
 */
public class hesabProses {
    public static boolean imageYoxla() throws SQLException{
  Connection con = DBConnect.baglan();
  Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from picture");
        int i = 0 ;
        while(rs.next()){
            i++;
        }
        rs.close();
        st.close();
        con.close();
        return i>0;
    }
    
    public static String getAD() throws SQLException{
        Connection con = DBConnect.baglan();
        
        Statement st =con.createStatement();
        ResultSet rs = st.executeQuery("select AdSoyad from hesab");
        rs.next();
        String ad = rs.getString(1);
        rs.close(); 
        st.close();
        con.close();
        return ad;
    }
    
     public static String getCompany() throws SQLException{
        Connection con = DBConnect.baglan();
        
        Statement st =con.createStatement();
        ResultSet rs = st.executeQuery("select sirket from hesab");
        rs.next();
        String ad = rs.getString(1);
        rs.close(); 
        st.close();
        con.close();
        return ad;
    }
    
    public static void main(String args[]) throws SQLException{
        System.out.println(hesabProses.imageYoxla());
    }
}
