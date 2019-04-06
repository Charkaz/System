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
public class DigerOdenisler {
   
     
     public int sonDigerOdenis() throws SQLException{
        
        Connection con =DBConnect.baglan();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select id from digerodenis");
        int id =0;
        while(rs.next()){
            id=rs.getInt(1);
        }
        rs.close();
        st.close();
        con.close();
        return id;
    }
    
     public boolean DigerOdenisiQeyd(String miqdar,String techizatci) throws SQLException, ParseException{
       
        Date current = new Date(new java.util.Date().getTime());
        double miq = Double.parseDouble(miqdar);
         Connection con =DBConnect.baglan();
         PreparedStatement psmt = con.prepareStatement("insert into digerodenis values(?,?,?,?)");
         psmt.setInt(1, sonDigerOdenis()+1);
            psmt.setString(2, techizatci);
         psmt.setDouble(3, miq);
     
         psmt.setDate(4, current);
      int i=   psmt.executeUpdate();
         psmt.close();
         con.close();
         return i>0;
    }
}
