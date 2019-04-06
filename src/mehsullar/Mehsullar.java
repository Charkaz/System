/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mehsullar;

import Database.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Charkaz
 */
public class Mehsullar {
    
    public int sonMehsul() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id from mehsullar");
        int id =0;
        while(rs.next()){
            id=rs.getInt(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
    
     public boolean mehsulQeyd(String MehsulAd,String Olcu,String Barkod,String MehsulSay ,String AlisQiymet,String SatisQiymet,String SonTarix) throws SQLException, ParseException{
        
        
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date tarix = sim.parse(SonTarix);
        Date SonIstifadeTarix = new Date(tarix.getTime());
        Date current = new Date(new java.util.Date().getTime());
        
        
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into mehsullar values(?,?,?,?,?,?,?,?,?)");
         psmt.setInt(1, sonMehsul()+1);
         psmt.setString(2, MehsulAd);
         psmt.setString(3, Olcu);
         psmt.setString(4, Barkod);
         psmt.setDouble(5, Double.parseDouble(MehsulSay));
         psmt.setDouble(6, Double.parseDouble(AlisQiymet));
         psmt.setDouble(7, Double.parseDouble(SatisQiymet));
         psmt.setDate(8,SonIstifadeTarix);
         psmt.setDate(9, current);
      int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
     
     
       public boolean mehsulSil(int id) throws SQLException{
        Connection con = DBConnect.baglan();
        PreparedStatement psmt = con.prepareStatement("delete from mehsullar where id = ?");
       
        psmt.setInt(1, id);
  int i = psmt.executeUpdate();
        con.close();
        return i>0;
    }
    
       
        public boolean mehsulUpdate(int id,String mehsulAd ,String Olcu ,String Barkod,String AlisQiymet,String SatisQiymet,String SonTarix) throws SQLException, ParseException{
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date tarix = sim.parse(SonTarix);
        Date sonTar = new Date(tarix.getTime());
        
        Connection con = DBConnect.baglan();
        
        PreparedStatement psmt  = con.prepareStatement("update mehsullar set MehsulAd=? , Olcu = ? , Barkod =? , AlisQiymet = ? , SatisQiymet=? , SonTarix =? where id="+id+"");
        psmt.setString(1, mehsulAd);
        psmt.setString(2, Olcu);
        psmt.setString(3, Barkod);
        psmt.setDouble(4, Double.parseDouble(AlisQiymet));
        psmt.setDouble(5, Double.parseDouble(SatisQiymet));
        psmt.setDate(6, sonTar);
int i = psmt.executeUpdate();
       return i>0; 
    }
   
        
   
    
    public static void main(String args[]) throws SQLException, ParseException{
        Mehsullar m = new Mehsullar();
        //System.out.println(m.mehsulQeyd("java book", "dene", "4618768419", "20", "22", "44", "2019-09-09"));
       // System.out.println(m.mehsulSil(1));
      // System.out.println(m.mehsulUpdate(1, "c++", "dene", "465489", "50", "50", "2019-12-19"));
       
    }
}
