package Insanlar;


import Database.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Insan {
//asagi musteriler ucun emeliyyatlardir
    public int sonMusteri() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id from musteriler");
        int id =0;
        while(rs.next()){
            id=rs.getInt(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
    
    
    public boolean musteriQeyd(String AdSoyad,String Telefon,String Email,String Adres ,String dogumTarixi) throws SQLException, ParseException{
        
        
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date tarix = sim.parse(dogumTarixi);
        Date dogum = new Date(tarix.getTime());
        Date current = new Date(new java.util.Date().getTime());
        
        
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into musteriler values(?,?,?,?,?,?,?,?)");
         psmt.setInt(1, sonMusteri()+1);
         psmt.setString(2, AdSoyad);
         psmt.setString(3, Telefon);
         psmt.setString(4, Email);
         psmt.setString(5, Adres);
         psmt.setDate(6, dogum);
         psmt.setDate(7, current);
           psmt.setDouble(8, 0);
      int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
    
    public boolean musteriSil(int id) throws SQLException{
        Connection con = DBConnect.baglan();
        PreparedStatement psmt = con.prepareStatement("delete from musteriler where id = ?");
       
        psmt.setInt(1, id);
  int i = psmt.executeUpdate();
        con.close();
        return i>0;
    }
    
    
    public boolean musteriUpdate(int id,String AdSoyad ,String telefon ,String email,String adres,String dogumtarix) throws SQLException, ParseException{
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date tarix = sim.parse(dogumtarix);
        Date dogum = new Date(tarix.getTime());
        
        Connection con = DBConnect.baglan();
        
        PreparedStatement psmt  = con.prepareStatement("update musteriler set MusteriAdSoyad=? , Telefon = ? , Email =? , Adres = ? , DogumTarixi=? where id="+id+"");
        psmt.setString(1, AdSoyad);
        psmt.setString(2, telefon);
        psmt.setString(3, email);
        psmt.setString(4, adres);
        psmt.setDate(5, dogum);
int i = psmt.executeUpdate();
       return i>0; 
    }
    
    
    //yuxari musteriler ucun emeliyyatlardir
    //asagidakilar isciler ucun emeliyyatlardir
    
    public int sonIsci() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id from isciler");
        int id =0;
        while(rs.next()){
            id=rs.getInt(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
    
    
    public boolean IsciQeyd(String AdSoyad,String Telefon,String Email,String Adres ,String dogumTarixi) throws SQLException, ParseException{
        
        
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date tarix = sim.parse(dogumTarixi);
        Date dogum = new Date(tarix.getTime());
        Date current = new Date(new java.util.Date().getTime());
        
        
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into isciler values(?,?,?,?,?,?,?)");
         psmt.setInt(1, sonIsci()+1);
         psmt.setString(2, AdSoyad);
         psmt.setString(3, Telefon);
         psmt.setString(4, Email);
         psmt.setString(5, Adres);
         psmt.setDate(6, dogum);
         psmt.setDate(7, current);
      int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
    
    public boolean IsciSil(int id) throws SQLException{
        Connection con = DBConnect.baglan();
        PreparedStatement psmt = con.prepareStatement("delete from isciler where id = ?");
       
        psmt.setInt(1, id);
  int i = psmt.executeUpdate();
        con.close();
        return i>0;
    }
    
    
    public boolean isciUpdate(int id,String AdSoyad ,String telefon ,String email,String adres,String dogumtarix) throws SQLException, ParseException{
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date tarix = sim.parse(dogumtarix);
        Date dogum = new Date(tarix.getTime());
        
        Connection con = DBConnect.baglan();
        
        PreparedStatement psmt  = con.prepareStatement("update isciler set IsciAdSoyad=? , Telefon = ? , Email =? , Adres = ? , DogumTarix=? where id="+id+"");
        psmt.setString(1, AdSoyad);
        psmt.setString(2, telefon);
        psmt.setString(3, email);
        psmt.setString(4, adres);
        psmt.setDate(5, dogum);
int i = psmt.executeUpdate();
       return i>0; 
    }
    //yuxaridakilar isciler ucun olan emeliyyatlardir
    //asagidakilar techizatcilar  ucun olan emeliyyatlardir 
    
    
    
    public int sonTechizatci() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id from techizatcilar");
        int id =0;
        while(rs.next()){
            id=rs.getInt(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
    
    
    public boolean TechizatciQeyd(String AdSoyad,String Telefon,String Email,String Adres ,String dogumTarixi) throws SQLException, ParseException{
        
        
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date tarix = sim.parse(dogumTarixi);
        Date dogum = new Date(tarix.getTime());
        Date current = new Date(new java.util.Date().getTime());
        
        
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into techizatcilar values(?,?,?,?,?,?,?,?)");
         psmt.setInt(1, sonTechizatci()+1);
         psmt.setString(2, AdSoyad);
         psmt.setString(3, Telefon);
         psmt.setString(4, Email);
         psmt.setString(5, Adres);
         psmt.setDate(6, dogum);
         psmt.setDate(7, current);
         psmt.setDouble(8, 0);
      int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
    
    public boolean TechizatciSil(int id) throws SQLException{
        Connection con = DBConnect.baglan();
        PreparedStatement psmt = con.prepareStatement("delete from techizatcilar where id = ?");
       
        psmt.setInt(1, id);
  int i = psmt.executeUpdate();
        con.close();
        return i>0;
    }
    
    
    public boolean TechizatciUpdate(int id,String AdSoyad ,String telefon ,String email,String adres,String dogumtarix) throws SQLException, ParseException{
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date tarix = sim.parse(dogumtarix);
        Date dogum = new Date(tarix.getTime());
        
        Connection con = DBConnect.baglan();
        
        PreparedStatement psmt  = con.prepareStatement("update techizatcilar set TechizatciAdSoyad=? , Telefon = ? , Email =? , Adres = ? , DogumTarix=? where id="+id+"");
        psmt.setString(1, AdSoyad);
        psmt.setString(2, telefon);
        psmt.setString(3, email);
        psmt.setString(4, adres);
        psmt.setDate(5, dogum);
int i = psmt.executeUpdate();
       return i>0; 
    }
    
    
    
    public static void main(String []args) throws SQLException, ParseException{
        Insan i = new Insan();
       
     // insert System.out.println(i.musteriQeyd("alisan", "055", "alisanc20@", "new york", "1998-08-28"));
    // update System.out.println(i.musteriUpdate(1,"Hamid", "077", "hamid@", "new york", "1970-04-06"));
   //  delete System.out.println(i.musteriSil(4));
      
    // insert   System.out.println(i.IsciQeyd("hamid", "077", "hamid@", "new york", "1970-08-28"));
   // update   System.out.println(i.isciUpdate(1,"Ayxan", "050", "Ayxannesibzade@", "baku", "1996-04-06"));
  // delete    System.out.println(i.IsciSil(2));
  
   //insert    System.out.println(i.TechizatciQeyd("alisan", "055", "alisan@", "new york", "1998-08-28"));
  // update    System.out.println(i.TechizatciUpdate(2,"Ayxan", "050", "Ayxannesibzade@", "baku", "1996-04-06"));
 // delete   System.out.println(i.TechizatciSil(2));
    }
    
}
