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
import javax.swing.JComboBox;

/**
 *
 * @author Charkaz
 */
public class techizatciOdenisi {
     public void getTechizatcilar(JComboBox cmb) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select techizatciadsoyad from techizatcilar");
    
        while(rs.next()){
            cmb.addItem(rs.getString(1));
        }
        rs.close();
        st.close();
        con.close();
       
    }
     
       public Double getQaliqBorc(String AD) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select Borcumuz from techizatcilar where TechizatciAdSoyad='"+AD+"'");
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
        PreparedStatement psmt  = con.prepareStatement("update techizatcilar set Borcumuz=? where TechizatciAdSoyad='"+ad+"'");
        psmt.setDouble(1, yekun);
  
int i = psmt.executeUpdate();
       return i>0; 
    }
     
     
     public int sonTechizatciOdenisi() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id from techizatciodenisi");
        int id =0;
        while(rs.next()){
            id=rs.getInt(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
    
     public boolean TechOdenisiQeyd(String miqdar,String techizatci) throws SQLException, ParseException{
       
        Date current = new Date(new java.util.Date().getTime());
        double miq = Double.parseDouble(miqdar);
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into techizatciodenisi values(?,?,?,?)");
         psmt.setInt(1, sonTechizatciOdenisi()+1);
            psmt.setString(2, techizatci);
         psmt.setDouble(3, miq);
     
         psmt.setDate(4, current);
      int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
}
