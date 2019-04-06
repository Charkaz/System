
package Satis;

import Database.DBConnect;
import TableDatalar.getDatalar;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;


public class BarkodluSatis {
  
    
      public int sonSatis() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id from Satis");
        int id =0;
        while(rs.next()){
            id=rs.getInt(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
      
        public Double getMehsulSay(String Barkod) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select MehsulSay from mehsullar where Barkod='"+Barkod+"'");
       Double ode=null;
        while(rs.next()){
            ode=rs.getDouble(1);
        }
        rs.close();
        st.close();
        con.close();
        return ode;
    }
          public Double getMehsulSayAd(String AD) throws SQLException{
        
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
      
        
          public boolean SatisiSil(int id) throws SQLException{
        Connection con = DBConnect.baglan();
        PreparedStatement psmt = con.prepareStatement("delete from Satis where id = ?");
       
        psmt.setInt(1, id);
  int i = psmt.executeUpdate();
        con.close();
        return i>0;
    }
      
         public boolean mehsulUpdateSatis(String barkod) throws SQLException, ParseException{
       
        Connection con = DBConnect.baglan();
        double say = getMehsulSay(barkod);
       
        double yekun = say-1;
        PreparedStatement psmt  = con.prepareStatement("update mehsullar set  MehsulSay=? where Barkod='"+barkod+"'");
        psmt.setDouble(1, yekun);
    
int i = psmt.executeUpdate();
       return i>0; 
    }
         
          public boolean mehsulUpdateAd(String Ad,String Miqdar) throws SQLException, ParseException{
       
        Connection con = DBConnect.baglan();
        double say = getMehsulSayAd(Ad);
       double miq = Double.parseDouble(Miqdar);
        double yekun = say-miq+1;
        PreparedStatement psmt  = con.prepareStatement("update mehsullar set  MehsulSay=? where MehsulAd='"+Ad+"'");
        psmt.setDouble(1, yekun);
    
int i = psmt.executeUpdate();
       return i>0; 
    }
         
         
        public boolean mehsulUpdateSatisSil(String barkod,String Miqdar) throws SQLException, ParseException{
       
        Connection con = DBConnect.baglan();
        double miqdar = Double.parseDouble(Miqdar);
        double say = getMehsulSayAd(barkod);
       
        double yekun = say+miqdar;
        PreparedStatement psmt  = con.prepareStatement("update mehsullar set  MehsulSay=? where MehsulAd='"+barkod+"'");
        psmt.setDouble(1, yekun);
    
int i = psmt.executeUpdate();
       return i>0; 
    }
         
        public boolean SatisUpdate(int id,String Ad,String Miqdar) throws SQLException, ParseException{
    
        Connection con = DBConnect.baglan();
        
        double yekunTutar = Double.parseDouble(Miqdar) * getMehsulQiymetAd(Ad);
        
        PreparedStatement psmt  = con.prepareStatement("update satis set Miqdar=?,Tutar=? where id="+id+"");
        psmt.setDouble(1, Double.parseDouble(Miqdar));
        psmt.setDouble(2, yekunTutar);
  
int i = psmt.executeUpdate();
       return i>0; 
    }
        
        
        public int sonQaime() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id from Qaime");
        int id =0;
        while(rs.next()){
            id=rs.getInt(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
      
         public double getMehsulQiymet( String Barkod) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select SatisQiymet from mehsullar where Barkod='"+Barkod+"'");
        double id =0;
        while(rs.next()){
            id=rs.getDouble(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
     
          public double getMehsulQiymetAd( String Ad) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select SatisQiymet from mehsullar where MehsulAd='"+Ad+"'");
        double id =0;
        while(rs.next()){
            id=rs.getDouble(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
        
          public String getMehsulAd(String Barkod) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select MehsulAd from mehsullar where Barkod='"+Barkod+"'");
  String ad = null;
        while(rs.next()){
            ad=rs.getString(1);
        }
        rs.close();
        st.close();
        con.close();
        return ad;
    }
     
          public Double Toplam() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select sum(tutar) from satis where qaime = (Select Max(qaime) from satis)");
  double say=0;
        while(rs.next()){
            say=rs.getDouble(1);
        }
        rs.close();
        st.close();
        con.close();
        
        return say;
    }
          
           public String MehsulVahid(String ad) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select olcu from mehsullar where Barkod='"+ad+"'");
        String id =null;
        while(rs.next()){
          id=rs.getString(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
      public boolean SatisQeyd(String Barkod) throws SQLException, ParseException{
       
        Date current = new Date(new java.util.Date().getTime());
        
        String mehsul = getMehsulAd(Barkod);
        double say=1;
        double satQiymet = getMehsulQiymet(Barkod);
        
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into Satis values(?,?,?,?,?,?,?,?,?,?)");
          psmt.setInt(1, sonSatis()+1);
         psmt.setString(2, mehsul);
         psmt.setDouble(3, say);
         psmt.setDouble(4, satQiymet);
         psmt.setDouble(5, 0);
         psmt.setDouble(6, say*satQiymet);
         psmt.setInt(7, sonQaime()+1);
         psmt.setString(8, "barkodlu");
         psmt.setDate(9, current);
         psmt.setString(10,MehsulVahid(Barkod));
         int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
      
      
      public boolean QaimeQeyd() throws SQLException, ParseException{
       
        Date current = new Date(new java.util.Date().getTime());
        
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into qaime values(?,?,?,?,?)");
         psmt.setInt(1, sonQaime()+1);
         psmt.setString(2, "barkodlu");
       psmt.setDouble(3,Toplam());
       psmt.setDouble(4, Toplam());
         psmt.setDate(5, current);
      int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
      
      
      
      public static void main(String args[]) throws SQLException, ParseException{
          BarkodluSatis sat = new BarkodluSatis();
          String barkod="45646";
       System.out.println(sat.mehsulUpdateSatis(barkod));
      }
}
