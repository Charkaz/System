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

/**
 *
 * @author Charkaz
 */
public class NagdGirisi {
    
     public int sonNagd() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id from Nagd");
        int id =0;
        while(rs.next()){
            id=rs.getInt(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
    
        public boolean QeydSil(int id) throws SQLException{
        Connection con = DBConnect.baglan();
        PreparedStatement psmt = con.prepareStatement("delete from nagd where id = ?");
       
        psmt.setInt(1, id);
  int i = psmt.executeUpdate();
        con.close();
        return i>0;
    }
     
      public boolean NagdQeyd(String miqdar) throws SQLException, ParseException{
       
        Date current = new Date(new java.util.Date().getTime());
        double miq = Double.parseDouble(miqdar);
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into Nagd values(?,?,?)");
         psmt.setInt(1, sonNagd()+1);
         psmt.setDouble(2, miq);
     
         psmt.setDate(3, current);
      int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
      
    
}
