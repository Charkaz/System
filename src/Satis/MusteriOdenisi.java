/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Satis;

import Database.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.swing.JComboBox;


public class MusteriOdenisi {
  
      public void getMusteriler(JComboBox cmb) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select MusteriAdSoyad from musteriler");
    
        while(rs.next()){
            cmb.addItem(rs.getString(1));
        }
        rs.close();
        st.close();
        con.close();
       
    }
      
      
      public int sonMusteriOdenisi() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id from girismusteri");
        int id =0;
        while(rs.next()){
            id=rs.getInt(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
    
       public boolean MusteriOdenisiQeyd(String miqdar,String musteri) throws SQLException, ParseException{
       
        Date current = new Date(new java.util.Date().getTime());
        double miq = Double.parseDouble(miqdar);
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into girismusteri values(?,?,?,?)");
         psmt.setInt(1, sonMusteriOdenisi()+1);
            psmt.setString(2, musteri);
         psmt.setDouble(3, miq);
     
         psmt.setDate(4, current);
      int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
          public Double getQaliqBorc(String AD) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select QaliqBorc from musteriler where MusteriAdSoyad='"+AD+"'");
       Double ode=null;
        while(rs.next()){
            ode=rs.getDouble(1);
        }
        rs.close();
        st.close();
        con.close();
        return ode;
    }
       
        public boolean QaliqBorcUpdate(String ad,String Odenilen) throws SQLException, ParseException{
    
        Connection con = DBConnect.baglan();
        double qaliqBorc = getQaliqBorc(ad);
        
          
        double odenilen = Double.parseDouble(Odenilen);
        
      double yekun = qaliqBorc-odenilen;
        PreparedStatement psmt  = con.prepareStatement("update musteriler set QaliqBorc=? where MusteriAdSoyad='"+ad+"'");
        psmt.setDouble(1, yekun);
  
int i = psmt.executeUpdate();
       return i>0; 
    }
     
      
}
