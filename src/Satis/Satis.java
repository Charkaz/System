
package Satis;

import Database.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;


public class Satis {
    
    
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
       public String[] getMehsulDatalar(String MehsulAdi) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select MehsulAd,SatisQiymet from mehsullar where MehsulAd='"+MehsulAdi+"'");
    String [] data =new String[2];
        while(rs.next()){
        data[0]=rs.getString(1);
        data[1] = rs.getString(2);
        }
        rs.close();
        st.close();
        con.close();
       return data;
    }
     
        public String MehsulVahid(String ad) throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select olcu from mehsullar where MehsulAd='"+ad+"'");
        String id =null;
        while(rs.next()){
          id=rs.getString(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
 
     
     public boolean SatisQeyd(String MehsulAd,String Miqdar,String Qiymet,String Endrim ,String tutar,String Musteri) throws SQLException, ParseException{
       
        Date current = new Date(new java.util.Date().getTime());
        
        
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into Satis values(?,?,?,?,?,?,?,?,?,?)");
         psmt.setInt(1, sonSatis()+1);
         psmt.setString(2, MehsulAd);
         psmt.setDouble(3, Double.parseDouble(Miqdar));
         psmt.setDouble(4, Double.parseDouble(Qiymet));
         psmt.setDouble(5, Double.parseDouble(Endrim));
         psmt.setDouble(6, Double.parseDouble(tutar));
         psmt.setInt(7, sonQaime()+1);
         psmt.setString(8, Musteri);
         psmt.setDate(9, current);
         psmt.setString(10,MehsulVahid(MehsulAd));
      int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
     
     public boolean SatisiSil(int id) throws SQLException{
        Connection con = DBConnect.baglan();
        PreparedStatement psmt = con.prepareStatement("delete from Satis where id = ?");
       
        psmt.setInt(1, id);
  int i = psmt.executeUpdate();
        con.close();
        return i>0;
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
     
         public boolean SatisUpdate(int id,String Ad,String Miqdar) throws SQLException, ParseException{
    
        Connection con = DBConnect.baglan();
        double yekunTutar = Double.parseDouble(Miqdar) * getMehsulQiymet(Ad);
        PreparedStatement psmt  = con.prepareStatement("update satis set Miqdar=?,Tutar=? where id="+id+"");
        psmt.setDouble(1, Double.parseDouble(Miqdar));
        psmt.setDouble(2, yekunTutar);
  
int i = psmt.executeUpdate();
       return i>0; 
    }
     
        //Yuxari Musteri adi ile crud emeliyyatlaridir
         
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
         
             public String sonMusteri() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select Musteri from Satis where Qaime=(select max(Qaime) from Satis)");
       String ad=null;
        while(rs.next()){
            ad=rs.getString(1);
        }
        rs.close();
        st.close();
        con.close();
        return ad;
    }
          public Double Odenecek() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select sum(tutar) from Satis where Qaime =(select max(Qaime) from Satis)");
       Double ode=null;
        while(rs.next()){
            ode=rs.getDouble(1);
        }
        rs.close();
        st.close();
        con.close();
        return ode;
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
            
             public boolean QaliqBorcUpdate(String ad,String Odenilen) throws SQLException, ParseException{
    
        Connection con = DBConnect.baglan();
        double qaliqBorc = getQaliqBorc(ad);
        
          
        double odenilen = Double.parseDouble(Odenilen);
        
        double yekun = qaliqBorc+(Odenecek()-odenilen);
        PreparedStatement psmt  = con.prepareStatement("update musteriler set QaliqBorc=? where MusteriAdSoyad='"+ad+"'");
        psmt.setDouble(1, yekun);
  
int i = psmt.executeUpdate();
       return i>0; 
    }
     
             
             
             public boolean QaimeQeyd(String odenilen) throws SQLException, ParseException{
       
        Date current = new Date(new java.util.Date().getTime());
        
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into qaime values(?,?,?,?,?)");
         psmt.setInt(1, sonQaime()+1);
         psmt.setString(2, sonMusteri());
       psmt.setDouble(3,Odenecek());
       psmt.setDouble(4, Double.parseDouble(odenilen));
         psmt.setDate(5, current);
      int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
     
              public boolean mehsulUpdateAd(String Ad,String Miqdar) throws SQLException, ParseException{
        Connection con = DBConnect.baglan();
        double say = getMehsulSay(Ad);
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
        double say = getMehsulSay(barkod);
       
        double yekun = say+miqdar;
        PreparedStatement psmt  = con.prepareStatement("update mehsullar set  MehsulSay=? where MehsulAd='"+barkod+"'");
        psmt.setDouble(1, yekun);
    
int i = psmt.executeUpdate();
       return i>0; 
    }
             
             
             
                   public boolean mehsulUpdateSatis(String mehsulAd,String Miqdar) throws SQLException, ParseException{
       
        Connection con = DBConnect.baglan();
        double say = getMehsulSay(mehsulAd);
        double miqdar = Double.parseDouble(Miqdar);
        double yekun = say-miqdar;
        PreparedStatement psmt  = con.prepareStatement("update mehsullar set  MehsulSay=? where MehsulAd='"+mehsulAd+"'");
        psmt.setDouble(1, yekun);
    
int i = psmt.executeUpdate();
       return i>0; 
    }
             
     public static void main(String [] args) throws SQLException, ParseException{
         Satis s = new Satis();
       // System.out.println(s.SatisQeyd("java", "4", "10", "10", "20", "ayxan"));
      // System.out.println(s.SatisiSil(1));
      //System.out.println(s.SatisUpdate(2, "15"));
    // System.out.print(s.QaimeQeyd("332"));
    //System.out.println(s.getMehsulSay("java") > 50);
   // System.out.println(s.QaliqBorcUpdate("alisan cerkez", "5"));
   
   System.out.println(s.SatisUpdate(24, "java", "10"));
     }
}
