
package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Report {
    String CheklerYolu = "C://Program Files//CharkazSystem";
      public void Repting() throws SQLException, JRException{
    Connection con = DBConnect.baglan();
    JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//Qaime.jrxml");
    JRDesignQuery query =new JRDesignQuery();
    query.setText("select hesab.AdSoyad,hesab.Sirket,satis.id,satis.Mehsul,satis.Miqdar,satis.Vahid,satis.Qiymet,satis.Endrim,satis.Tutar,Qaime.id,Qaime.Zaman,satis.musteri,qaime.odenecek,qaime.odenildi,satis.qaime,qaime.odenecek-qaime.odenildi from hesab,satis,qaime where  satis.Qaime =(Select max(qaime) from satis) and qaime.id = satis.Qaime ");
    jd.setQuery(query);
    JasperReport jr = JasperCompileManager.compileReport(jd);
    JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
    JasperViewer.viewReport(jp);
    }
 
       
      public void Repting(int id) throws SQLException, JRException{
    Connection con = DBConnect.baglan();
    JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//Qaime.jrxml");
    JRDesignQuery query =new JRDesignQuery();
    query.setText("select hesab.AdSoyad,hesab.Sirket,satis.id,satis.Mehsul,satis.Miqdar,satis.Vahid,satis.Qiymet,satis.Endrim,satis.Tutar,Qaime.id,Qaime.Zaman,satis.musteri,qaime.odenecek,qaime.odenildi,satis.qaime,qaime.odenecek-qaime.odenildi from hesab,satis,qaime where  satis.Qaime ="+id+" and qaime.id = satis.Qaime ");
    jd.setQuery(query);
    JasperReport jr = JasperCompileManager.compileReport(jd);
    JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
    JasperViewer.viewReport(jp);
    }
     
      public String gunlukSatis() throws Exception{
         double satis;
         Connection con = DBConnect.baglan();
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select sum(tutar) from satis where Day(Tarix) = Day(CURDATE())");
          rs.next();
          satis = rs.getDouble(1);
          
          rs.close();
          st.close();
          con.close();
          return String.valueOf(satis);
      }
      
      public String MusteriSay() throws Exception{
         double satis;
         Connection con = DBConnect.baglan();
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select count(id) from musteriler");
          rs.next();
          satis = rs.getDouble(1);
          
          rs.close();
          st.close();
          con.close();
          return String.valueOf(satis);
      }
      
      public String IsciSay() throws Exception{
         double satis;
         Connection con = DBConnect.baglan();
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select count(id) from isciler");
          rs.next();
          satis = rs.getDouble(1);
          
          rs.close();
          st.close();
          con.close();
          return String.valueOf(satis);
      }   
      
         public String TechizatciSay() throws Exception{
         double satis;
         Connection con = DBConnect.baglan();
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select count(id) from techizatcilar");
          rs.next();
          satis = rs.getDouble(1);
          
          rs.close();
          st.close();
          con.close();
          return String.valueOf(satis);
      }
 
      
    public static void main(String args[]) throws SQLException, JRException{
    Report r = new Report();
    r.Repting(36);
    }
    
}
