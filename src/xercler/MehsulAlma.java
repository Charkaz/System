/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xercler;

import Database.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

/**
 *
 * @author Charkaz
 */
public class MehsulAlma {
     public int sonMehsulAlma() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id from mehsulalma");
        int id =0;
        while(rs.next()){
            id=rs.getInt(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
     public double getMehsulQiymet( String AD) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select SatisQiymet from mehsullar where MehsulAd='"+AD+"'");
        double id =0;
        while(rs.next()){
            id=rs.getDouble(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
     public boolean MehsulAlmaQeyd(String mehsul,String techizatci,String miqdar) throws SQLException, ParseException{
       
        Date current = new Date(new java.util.Date().getTime());
        double miq = Double.parseDouble(miqdar);
        double qiymet = getMehsulQiymet(mehsul);
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into mehsulalma values(?,?,?,?,?,?)");
         psmt.setInt(1, sonMehsulAlma()+1);
            psmt.setString(2, mehsul);
            psmt.setString(3, techizatci);
         psmt.setDouble(4, miq);
      psmt.setDouble(5, miq*qiymet);
         psmt.setDate(6, current);
      int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
     
     public Double getQaliqBorc(String AD) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select Borcumuz from techizatcilar where techizatciadsoyad='"+AD+"'");
       Double ode=null;
        while(rs.next()){
            ode=rs.getDouble(1);
        }
        rs.close();
        st.close();
        con.close();
        return ode;
    }
      public boolean QaliqBorcUpdate(String ad,String techizatci,String Miqdar,String odenen) throws SQLException, ParseException{
    
        Connection con = DBConnect.baglan();
        double qaliqBorc = getQaliqBorc(techizatci);
        double qiymet = getMehsulQiymet(ad);
        double ode =Double.parseDouble(odenen);
        double miqdar = Double.parseDouble(Miqdar);
        double yekun = qaliqBorc +(qiymet*miqdar)-ode;
      
        PreparedStatement psmt  = con.prepareStatement("update techizatcilar set Borcumuz=? where techizatciadsoyad='"+techizatci+"'");
        psmt.setDouble(1, yekun);
  
int i = psmt.executeUpdate();
       return i>0; 
    }
      public double toplam(String ad,String Miqdar) throws SQLException{
          double qiymet = getMehsulQiymet(ad);
          double miqdar = Double.parseDouble(Miqdar);
          
          return qiymet*miqdar;
      }
      
       public Double getMehsulSay(String AD) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select MehsulSay from mehsullar where MehsulAd='"+AD+"'");
       Double ode=null;
        while(rs.next()){
            ode=rs.getDouble(1);
        }
        rs.close();
        st.close();
        con.close();
        return ode;
    }
              public boolean mehsulUpdate(String Ad,String Miqdar) throws SQLException, ParseException{
        Connection con = DBConnect.baglan();
        double say = getMehsulSay(Ad);
       double miq = Double.parseDouble(Miqdar);
        double yekun = say+miq;
        PreparedStatement psmt  = con.prepareStatement("update mehsullar set  MehsulSay=? where MehsulAd='"+Ad+"'");
        psmt.setDouble(1, yekun);
    
int i = psmt.executeUpdate();
       return i>0; 
    }
      
}
