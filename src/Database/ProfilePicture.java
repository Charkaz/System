/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProfilePicture {

    
    public boolean insertImage(String path) throws SQLException, FileNotFoundException{
        Connection con = DBConnect.baglan();
        PreparedStatement psmt = con.prepareStatement("insert into picture values(?,?)");
        File f = new File(path);
        FileInputStream fin = new FileInputStream(f);
        
        psmt.setInt(1, 1);
        psmt.setBlob(2,fin);
        
      int i=  psmt.executeUpdate();
        psmt.close();
       con.close();
       return i>0;
    }
    
    public static void main(String args[]) throws SQLException, FileNotFoundException{
        ProfilePicture p = new ProfilePicture();
    System.out.println(p.insertImage("C:\\Users\\Charkaz\\Documents\\NetBeansProjects\\CharkazSystem\\src\\hesab\\Default.png"));
    }
}
