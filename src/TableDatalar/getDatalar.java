/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableDatalar;

import Database.DBConnect;
import Satis.Satis;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Charkaz
 */
public class getDatalar {
    
    public void getMusteriler(JTable table,String Text) throws SQLException{
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id as sira,MusteriAdSoyad as 'Adi Soyadi ' , Telefon  as Telefon ,Email as Email,Adres as Adress , QeydTarix as 'Qeydiyyat tarixi', QaliqBorc as 'Qaliq Borc' from musteriler where MusteriAdSoyad like '"+Text+"%'");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
    
    public void getIsciler(JTable table,String Text) throws SQLException{
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id as sira,IsciAdSoyad as 'Adi Soyadi ' , Telefon  as Telefon ,Email as Email,Adres as Adress , QeydTarix as 'Qeydiyyat tarixi' from isciler where IsciAdSoyad like '"+Text+"%'");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
     public void getTechizatcilar(JTable table,String Text) throws SQLException{
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id as sira,TechizatciAdSoyad as 'Adi Soyadi ' , Telefon  as Telefon ,Email as Email,Adres as Adress , QeydTarix as 'Qeydiyyat tarixi' , Borcumuz from techizatcilar where TechizatciAdSoyad like '"+Text+"%'");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
     
      public void getMehsullar(JTable table,String Text) throws SQLException{
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id as sira,MehsulAd as 'Mehsul ' , Barkod  as Barkod ,MehsulSay as Say,Olcu as Olcu , AlisQiymet as 'Alis qiymet' ,SatisQiymet as 'SatisQiymet' ,SonTarix as 'Son muddet',QeydTarix as 'Qeyd Tarix' from mehsullar where MehsulAd like '"+Text+"%'");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
    
      public void getSadeSatis(JTable table) throws SQLException{
          Satis sat = new Satis();
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select satis.id,Mehsul, Miqdar , Olcu , Qiymet ,Endrim,Tutar from satis,mehsullar where satis.Mehsul=mehsullar.MehsulAd and Qaime="+(sat.sonQaime()+1)+"");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
      
       public void getBarkodSatis(JTable table) throws SQLException{
          Satis sat = new Satis();
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select satis.id,Mehsul, Miqdar , Olcu , Qiymet ,Endrim,Tutar from satis,mehsullar where satis.Mehsul=mehsullar.MehsulAd and Musteri='barkodlu'  and Qaime="+(sat.sonQaime()+1)+"");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
       
       
        public void getNagd(JTable table) throws SQLException{
          Satis sat = new Satis();
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from nagd");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
        
        public void getMusteriOdenisi(JTable table,String text) throws SQLException{
          Satis sat = new Satis();
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from girismusteri where ad like '"+text+"%'");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
        
         public void getIsciOdenisi(JTable table,String text) throws SQLException{
          Satis sat = new Satis();
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from isciodenisi where isciad like '"+text+"%'");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
        
          public void getTechizatciOdenisi(JTable table,String text) throws SQLException{
          Satis sat = new Satis();
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from techizatciodenisi where techizatciad like '"+text+"%'");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
           public void getDigerOdenis(JTable table,String text) throws SQLException{
          Satis sat = new Satis();
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from digerodenis where sebeb like '"+text+"%'");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
           public void getMehsulQaytarma(JTable table,String text) throws SQLException{
          Satis sat = new Satis();
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from mehsulqaytarma where mehsulad like '"+text+"%'");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
           public void getMehsulAlma(JTable table,String text) throws SQLException{
          Satis sat = new Satis();
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from mehsulalma where mehsulad like '"+text+"%'");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
           
             public void getSatisMehsullar(JTable table,int id) throws SQLException{
          Satis sat = new Satis();
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from satis where qaime="+id+"");
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
           
            public void getQaimeler(JTable table,String text,String brkd) throws SQLException{
          Satis sat = new Satis();
     
          String sql ="select * from qaime where musteriadsoyad like '"+text+"%'";
          
          if(brkd.equals("Barkodsuz")){
              sql = sql+ " and musteriadsoyad != 'barkodlu'";
          }else{
               sql = sql+ " and musteriadsoyad = 'barkodlu'";
          }
          
        Connection con = DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
   table.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
        st.close();
        con.close();
    }
}
