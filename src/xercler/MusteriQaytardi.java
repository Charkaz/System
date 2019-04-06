/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xercler;

import Database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

/**
 *
 * @author Charkaz
 */
public class MusteriQaytardi {
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
  
    public Double getQaliqBorc(String AD) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select QaliqBorc from musteriler where musteriadsoyad='"+AD+"'");
       Double ode=null;
        while(rs.next()){
            ode=rs.getDouble(1);
        }
        rs.close();
        st.close();
        con.close();
        return ode;
    }
     public boolean QaliqBorcUpdate(String ad,String musteri,String Miqdar) throws SQLException, ParseException{
    
        Connection con = DBConnect.baglan();
        double qaliqBorc = getQaliqBorc(musteri);
        double qiymet = getMehsulQiymet(ad);
        double miqdar = Double.parseDouble(Miqdar);
        double yekun = qaliqBorc -(qiymet*miqdar);
      
        PreparedStatement psmt  = con.prepareStatement("update musteriler set QaliqBorc=? where musteriadsoyad='"+musteri+"'");
        psmt.setDouble(1, yekun);
  
int i = psmt.executeUpdate();
       return i>0; 
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
      
        public boolean SatisUpdate(int id,String Ad,String Miqdar) throws SQLException, ParseException{
    
        Connection con = DBConnect.baglan();
        double yekunTutar = Double.parseDouble(Miqdar) * getMehsulQiymet(Ad);
        PreparedStatement psmt  = con.prepareStatement("update satis set Miqdar=?,Tutar=? where id="+id+"");
        psmt.setDouble(1, Double.parseDouble(Miqdar));
        psmt.setDouble(2, yekunTutar);
  
int i = psmt.executeUpdate();
       return i>0; 
    }
     
         public Double getQaimeMehsul(int id) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select sum(tutar) from satis where qaime="+id+"");
       Double ode=null;
        while(rs.next()){
            ode=rs.getDouble(1);
        }
        rs.close();
        st.close();
        con.close();
        return ode;
    }
         
         public Double getQaimeOdenildi(int id) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select Odenildi from qaime where id="+id+"");
       Double ode=null;
        while(rs.next()){
            ode=rs.getDouble(1);
        }
        rs.close();
        st.close();
        con.close();
        return ode;
    }
         
       
        
        
        public boolean QaimeUpdate(int id,String mehsulAd ,String miqdar) throws SQLException, ParseException{
    
        Connection con = DBConnect.baglan();
        double yekunTutar = getQaimeMehsul(id);
       
        PreparedStatement psmt  = con.prepareStatement("update qaime set Odenecek=?  where id="+id+"");
        psmt.setDouble(1, yekunTutar);
 
  
int i = psmt.executeUpdate();
       return i>0; 
    }
        
        public static void main(String args[]) throws SQLException, ParseException{
            MusteriQaytardi m = new MusteriQaytardi();
           //System.out.println(m.SatisUpdate(69, "jalaSoft", "2"));
        }
        
}
