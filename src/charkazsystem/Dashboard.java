/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charkazsystem;

import Database.DBConnect;
import Database.Report;
import Satislar.ShowSatislar;
import hesab.hesabProses;
import internalframes.BarkodSatis;
import internalframes.DigerOdenis;
import internalframes.GirisCash;
import internalframes.Isciler;
import internalframes.IscininOdenisi;
import internalframes.Mehsul;
import internalframes.MehsulAl;
import internalframes.MusteriSatis;
import internalframes.MusterininOdenisi;
import internalframes.TechMehsulQaytarma;
import internalframes.Techizatcilar;
import internalframes.TechizatcininOdenisi;
import internalframes.musteriler;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Charkaz
 */
public class Dashboard extends javax.swing.JFrame {

    String CheklerYolu = "C://Program Files//CharkazSystem";
    //src
    public void refresh() throws Exception{
        Report r = new Report();
        jLabel16.setText(r.MusteriSay());
        jLabel17.setText(r.IsciSay());
        jLabel19.setText(r.TechizatciSay());
        jLabel22.setText(r.gunlukSatis());
    }
    
    
     public boolean insertImage(String path) throws SQLException, FileNotFoundException{
        Connection con = DBConnect.baglan();
        PreparedStatement psmt = con.prepareStatement("insert into picture values(?,?)");
        File f = new File(path);
        FileInputStream fin = new FileInputStream(f);
        int i=0;
        psmt.setInt(1, 1);
        psmt.setBlob(2,fin);
         if(path.equals("")){
      
        }else{
             i=  psmt.executeUpdate();
        }
     
        psmt.close();
       con.close();
       return i>0;
    }
   
       public boolean UpdateImage(String path) throws SQLException, FileNotFoundException{
        Connection con = DBConnect.baglan();
        PreparedStatement psmt = con.prepareStatement("update picture set  Profil=? where id=1");
        File f = new File(path);
        FileInputStream fin = new FileInputStream(f);
        int i=0;
  
        psmt.setBlob(1,fin);
        if(path.equals("")){
      
        }else{
             i=  psmt.executeUpdate();
        }
        psmt.close();
       con.close();
       return i>0;
    }
     
    public void get() throws SQLException, IOException{
       Connection con = DBConnect.baglan();
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery("select Profil from picture");
       
       while(rs.next()){
       Blob b =rs.getBlob(1);
    
       InputStream f = b.getBinaryStream();
       BufferedImage image = ImageIO.read(f);
   ImageIcon i =new ImageIcon(image);
   Image ii = i.getImage();
   Image esas = ii.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
   ImageIcon son = new ImageIcon(esas);
     jLabel4.setIcon(son);
       }
       
       rs.close();
       st.close();
       con.close();
   }
    
    public void profilSekli() throws SQLException, IOException{
        if(hesabProses.imageYoxla()){
          get();
          jLabel5.setText(hesabProses.getAD());
          jLabel6.setText(hesabProses.getCompany());
        }else{
           ImageIcon i =new ImageIcon(CheklerYolu+"//src//hesab//default.png");
            jLabel4.setIcon(i);
           jLabel5.setText(hesabProses.getAD());
             jLabel6.setText(hesabProses.getCompany());
        }
        
    }
    public Dashboard() throws Exception{
        initComponents();
        profilSekli();
        /*  ImageIcon imageIcon = new ImageIcon("C:\\Users\\Charkaz\\Desktop\\ccc.PNG"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        
        jLabel1.setIcon(imageIcon);*/
        
        refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jDialog2 = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jDialog3 = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jDialog4 = new javax.swing.JDialog();
        jPanel12 = new javax.swing.JPanel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane()

        ;
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jDialog1.setMinimumSize(new java.awt.Dimension(518, 251));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton16.setBackground(java.awt.Color.orange);
        jButton16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton16.setText("Sec");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton17.setText("Arxivle");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog2.setMinimumSize(new java.awt.Dimension(815, 319));
        jDialog2.setResizable(false);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("Zaman dilimi");

        jComboBox1.setBackground(java.awt.Color.orange);
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bu gun", "Bu hefte", "Bu ay", "Bu il", "Butun" }));

        jButton19.setBackground(new java.awt.Color(255, 255, 51));
        jButton19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton19.setText("Satislar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(255, 255, 51));
        jButton20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton20.setText("Musteri Odenisi");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(255, 255, 51));
        jButton21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton21.setText("Nagd girisi");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(255, 255, 51));
        jButton22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton22.setText("Mehsul Qaytarmaq");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton22))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog3.setMinimumSize(new java.awt.Dimension(809, 300));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Zaman dilimi");

        jComboBox2.setBackground(java.awt.Color.orange);
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bu gun", "Bu hefte", "Bu ay", "Bu il", "Butun" }));

        jButton24.setBackground(new java.awt.Color(51, 255, 102));
        jButton24.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jButton24.setText("Isci odenisi");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(51, 255, 102));
        jButton25.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jButton25.setText("diger odenisler");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(51, 255, 102));
        jButton26.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jButton26.setText("Mehsul almaq");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(51, 255, 102));
        jButton27.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jButton27.setText("Techizatciya odenis");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jButton24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton27)
                .addGap(27, 27, 27))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog4.setMinimumSize(new java.awt.Dimension(800, 350));
        jDialog4.setPreferredSize(new java.awt.Dimension(800, 350));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMinimumSize(new java.awt.Dimension(783, 308));

        jButton29.setBackground(java.awt.Color.orange);
        jButton29.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jButton29.setText("Ən çox satılan məhsullar");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setBackground(java.awt.Color.orange);
        jButton30.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jButton30.setText("İstifadə müddətinin bitmesine yaxinlasanlar");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setBackground(java.awt.Color.orange);
        jButton31.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jButton31.setText("Ən cox satin alan musteriler");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setBackground(java.awt.Color.orange);
        jButton32.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jButton32.setText("Bazada ən az sayda qalan məhsullar");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setBackground(java.awt.Color.orange);
        jButton33.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jButton33.setText("Ən çox məhsul satan təçhizatçılar");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setBackground(java.awt.Color.orange);
        jButton34.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jButton34.setText("Ən çox ödənilən işçi");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton37.setBackground(java.awt.Color.orange);
        jButton37.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jButton37.setText("Ən çox ödənilən digər xərclər");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton35.setBackground(java.awt.Color.orange);
        jButton35.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jButton35.setText("Ən az satılan məhsullar");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jButton31)
                        .addGap(18, 18, 18)
                        .addComponent(jButton32))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jButton29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton30))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton35))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jButton34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton37)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton29)
                    .addComponent(jButton30))
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton35))
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(120, 120, 120))
        );

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane2.setBackground(new java.awt.Color(51, 0, 102));
        jDesktopPane2.setMinimumSize(new java.awt.Dimension(806, 491));

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/isciIcon/isciIcon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton1);
        jButton1.setBounds(640, 50, 100, 70);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 102), java.awt.Color.darkGray, new java.awt.Color(102, 0, 0), new java.awt.Color(102, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Alishan Charkaz");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Charkaz Company");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Müştəri sayı");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("14");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("14");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("İşçi sayı");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 102));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("14");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Təçhizatçı sayı");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Gunluk satis miqdari");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("1973");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("AZN");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDesktopPane2.add(jPanel2);
        jPanel2.setBounds(80, 50, 340, 440);

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musteriIcon/musteriler.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton2);
        jButton2.setBounds(490, 50, 100, 70);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Işçi");
        jDesktopPane2.add(jLabel1);
        jLabel1.setBounds(660, 130, 60, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Müştəri");
        jDesktopPane2.add(jLabel2);
        jLabel2.setBounds(510, 130, 60, 20);

        jButton3.setBackground(new java.awt.Color(0, 204, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techizatciIcon/techizatci.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton3);
        jButton3.setBounds(790, 50, 100, 70);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Təçhizatçı");
        jDesktopPane2.add(jLabel3);
        jLabel3.setBounds(810, 130, 60, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Məhsullar");
        jDesktopPane2.add(jLabel7);
        jLabel7.setBounds(950, 130, 60, 20);

        jButton4.setBackground(new java.awt.Color(255, 204, 204));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mehsullarIcon/mehsullaricon.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton4);
        jButton4.setBounds(930, 50, 100, 70);

        jButton5.setBackground(java.awt.Color.orange);
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SatisIcon/icons8_Cash_in_Hand_48px.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton5);
        jButton5.setBounds(490, 160, 100, 70);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Musteri satis");
        jDesktopPane2.add(jLabel8);
        jLabel8.setBounds(490, 240, 100, 20);

        jButton6.setBackground(new java.awt.Color(0, 255, 204));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SatisIcon/icons8_Barcode_Reader_50px.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton6);
        jButton6.setBounds(640, 160, 100, 70);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Barkod Satis");
        jDesktopPane2.add(jLabel9);
        jLabel9.setBounds(640, 240, 100, 20);

        jButton7.setBackground(java.awt.Color.darkGray);
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SatisIcon/icons8_Coins_48px_1.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton7);
        jButton7.setBounds(790, 160, 100, 70);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Negd girisi");
        jDesktopPane2.add(jLabel10);
        jLabel10.setBounds(800, 240, 80, 20);

        jButton8.setBackground(java.awt.Color.cyan);
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xerclerİcon/icons8_Budget_50px.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton8);
        jButton8.setBounds(640, 280, 100, 70);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("İşçi ödənişi");
        jDesktopPane2.add(jLabel11);
        jLabel11.setBounds(650, 360, 80, 20);

        jButton9.setBackground(new java.awt.Color(255, 255, 102));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xerclerİcon/icons8_Card_Payment_64px.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton9);
        jButton9.setBounds(790, 280, 100, 70);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Təçhizatçı ödənişi");
        jDesktopPane2.add(jLabel12);
        jLabel12.setBounds(780, 360, 120, 20);

        jButton10.setBackground(new java.awt.Color(204, 255, 204));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xerclerİcon/icons8_Paycheque_50px.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton10);
        jButton10.setBounds(930, 280, 100, 70);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Digər xərclər");
        jDesktopPane2.add(jLabel13);
        jLabel13.setBounds(940, 360, 80, 20);

        jButton11.setBackground(new java.awt.Color(255, 101, 130));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SatisIcon/icons8_Payroll_50px.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton11);
        jButton11.setBounds(930, 160, 100, 70);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Müştərinin ödənişi");
        jDesktopPane2.add(jLabel14);
        jLabel14.setBounds(920, 240, 120, 20);

        jButton12.setBackground(java.awt.SystemColor.activeCaption);
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SatisIcon/icons8_Product_52px.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton12);
        jButton12.setBounds(490, 280, 100, 70);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Məhsul almaq");
        jDesktopPane2.add(jLabel24);
        jLabel24.setBounds(490, 360, 100, 20);

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SatisIcon/icons8_Used_Product_50px.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton13);
        jButton13.setBounds(1070, 160, 100, 70);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Mehsulu Qaytarmaq");
        jDesktopPane2.add(jLabel25);
        jLabel25.setBounds(1060, 240, 130, 20);

        jButton14.setBackground(java.awt.Color.red);
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SatisIcon/icons8_Calculator_48px.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton14);
        jButton14.setBounds(1070, 50, 100, 70);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Kalkulyator");
        jDesktopPane2.add(jLabel26);
        jLabel26.setBounds(1090, 130, 70, 20);

        jButton15.setBackground(new java.awt.Color(255, 102, 51));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SatisIcon/icons8_Bill_48px.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton15);
        jButton15.setBounds(1070, 280, 100, 70);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Satışlara baxmaq");
        jDesktopPane2.add(jLabel27);
        jLabel27.setBounds(1060, 360, 120, 20);

        jButton18.setBackground(new java.awt.Color(51, 204, 0));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hesabaticon/icons8_Area_Chart_50px.png"))); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton18);
        jButton18.setBounds(640, 390, 100, 70);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Gelir hesabati");
        jDesktopPane2.add(jLabel28);
        jLabel28.setBounds(640, 470, 100, 20);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Xerc hesabati");
        jDesktopPane2.add(jLabel30);
        jLabel30.setBounds(790, 470, 100, 20);

        jButton23.setBackground(new java.awt.Color(51, 0, 153));
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hesabaticon/icons8_Accounting_48px.png"))); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton23);
        jButton23.setBounds(790, 390, 100, 70);

        jButton28.setBackground(new java.awt.Color(255, 255, 0));
        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hesabaticon/icons8_Stop_Graph_Report_50px.png"))); // NOI18N
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jDesktopPane2.add(jButton28);
        jButton28.setBounds(930, 390, 100, 70);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Diger hesabatlar");
        jDesktopPane2.add(jLabel32);
        jLabel32.setBounds(930, 470, 100, 20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
        );

        jMenu1.setText("Arxivle");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Arxivlemek");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Yenile");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
      
     
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
musteriler musteriframe;       
        try {
            musteriframe = new musteriler();
            jDesktopPane2.add(musteriframe);
musteriframe.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
JFileChooser jc = new JFileChooser();
jc.showOpenDialog(null);
File f = jc.getSelectedFile();
String path = f.getAbsolutePath();

if(!path.equals(""))
         try {
               if(hesabProses.imageYoxla()){
        UpdateImage(path);
          JOptionPane.showMessageDialog(null, "profil sekili ugurla deyisdi .");
                 profilSekli();
        }else{
                   insertImage(path);
                     JOptionPane.showMessageDialog(null, "profil sekili ugurla deyisdi .");
                 profilSekli();
        }
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Isciler isci;       
         try {
             isci = new Isciler();
             
             jDesktopPane2.add(isci);
isci.setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Techizatcilar tech;       
         try {
             tech = new Techizatcilar();
             
             jDesktopPane2.add(tech);
tech.setVisible(true);
         } catch (Exception ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Mehsul mehsul;       
         try {
             mehsul = new Mehsul();
             
             jDesktopPane2.add(mehsul);
mehsul.setVisible(true);
         } catch (Exception ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
MusteriSatis musteriSat;
         try {
             musteriSat = new MusteriSatis();
             jDesktopPane2.add(musteriSat);
musteriSat.setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        BarkodSatis barkodSat;
         try {
             barkodSat = new BarkodSatis();
             jDesktopPane2.add(barkodSat);
barkodSat.setVisible(true);
         } catch (Exception ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        GirisCash cash;
         try {
             cash = new GirisCash();
             jDesktopPane2.add(cash);
cash.setVisible(true);
         } catch (Exception ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        IscininOdenisi cash;
         try {
             cash = new IscininOdenisi();
             jDesktopPane2.add(cash);
cash.setVisible(true);
         } catch (Exception ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        TechizatcininOdenisi cash;
         try {
             cash = new TechizatcininOdenisi();
             jDesktopPane2.add(cash);
cash.setVisible(true);
         } catch (Exception ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }   // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        DigerOdenis cash;
         try {
             cash = new DigerOdenis();
             jDesktopPane2.add(cash);
cash.setVisible(true);
         } catch (Exception ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }     // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        MusterininOdenisi cash;
         try {
             cash = new MusterininOdenisi();
             jDesktopPane2.add(cash);
cash.setVisible(true);
         } catch (Exception ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }  // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
      MehsulAl cash;
         try {
             cash = new MehsulAl();
             jDesktopPane2.add(cash);
cash.setVisible(true);
         } catch (Exception ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }   // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        TechMehsulQaytarma cash;
         try {
             cash = new TechMehsulQaytarma();
             jDesktopPane2.add(cash);
cash.setVisible(true);
         } catch (Exception ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        /*Connection con;
        try {
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(".//src/pdfler//Qaime.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText("select hesab.AdSoyad,hesab.Sirket,satis.id,satis.Mehsul,satis.Miqdar,satis.Vahid,satis.Qiymet,satis.Endrim,satis.Tutar,Qaime.id,Qaime.Zaman,satis.musteri,qaime.odenecek,qaime.odenildi,satis.qaime,qaime.odenecek-qaime.odenildi from hesab,satis,qaime where  satis.Qaime =(Select max(qaime) from satis) and qaime.id = satis.Qaime ");
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }*/         
        
        Process p ;

try{
    Runtime runtime =Runtime.getRuntime();
    p = runtime.exec("calc.exe");
   
}catch(Exception e){
    
}

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
ShowSatislar  cash;
         try {
             cash = new ShowSatislar();
             jDesktopPane2.add(cash);
cash.setVisible(true);
         } catch (Exception ex) {
             Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }          // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      jDialog1.show();  // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed
 String path;
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
         JFileChooser fc = new JFileChooser();
        
         fc.showOpenDialog(this);
         String date   =new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
         try{
             File f = fc.getSelectedFile();
            path = f.getAbsolutePath();
            path= path.replace('\\', '/');
            path = path+"_"+date+".sql";
            jTextField1.setText(path);
         }catch(Exception e){
             
         }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
Process p ;

try{
    Runtime runtime =Runtime.getRuntime();
    p = runtime.exec("C:/Program Files/Mysql/Mysql Server 5.7/bin/mysqldump.exe -uroot -p12345 --add-drop-database -B system -r"+path);
    
    int proComplate = p.waitFor();
    if(proComplate==0){
    JOptionPane.showMessageDialog(null, "secilen yola ugurla arxivlendi");
    }else{
    JOptionPane.showMessageDialog(null, "arxivlenmedi");    
    }
    
}catch(Exception e){
    
}

    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
jDialog2.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
Connection con;
String sql = null;
if(jComboBox1.getSelectedItem().equals("Bu gun")){
    sql ="select * from qaime where Day(zaman)=Day(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu hefte")){
    sql ="select * from qaime where Week(zaman)=Week(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu ay")){
    sql ="select * from qaime where Month(zaman)=Month(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu il")){
     sql ="select * from qaime where Year(zaman)=Year(CURDATE())";
}else{
     sql ="select * from qaime";
}
        try {
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//Satislar.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }       
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
Connection con;
String sql = null;
if(jComboBox1.getSelectedItem().equals("Bu gun")){
    sql ="select * from girismusteri where Day(zaman)=Day(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu hefte")){
    sql ="select * from girismusteri where Week(zaman)=Week(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu ay")){
    sql ="select * from girismusteri where Month(zaman)=Month(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu il")){
     sql ="select * from girismusteri where Year(zaman)=Year(CURDATE())";
}else{
     sql ="select * from girismusteri";
}
        try {
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//musteriodenisi.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }       // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
Connection con;
String sql = null;
if(jComboBox1.getSelectedItem().equals("Bu gun")){
    sql ="select * from nagd where Day(Tarix)=Day(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu hefte")){
    sql ="select * from nagd where Week(Tarix)=Week(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu ay")){
    sql ="select * from nagd where Month(Tarix)=Month(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu il")){
     sql ="select * from nagd where Year(Tarix)=Year(CURDATE())";
}else{
     sql ="select * from nagd";
}
        try {
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//nagdgirisi.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }           // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
Connection con;
String sql = null;
if(jComboBox1.getSelectedItem().equals("Bu gun")){
    sql ="select * from mehsulqaytarma where Day(Tarix)=Day(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu hefte")){
    sql ="select * from mehsulqaytarma where Week(Tarix)=Week(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu ay")){
    sql ="select * from mehsulqaytarma where Month(Tarix)=Month(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu il")){
     sql ="select * from mehsulqaytarma where Year(Tarix)=Year(CURDATE())";
}else{
     sql ="select * from mehsulqaytarma";
}
        try {
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//mehsulqaytarmaq.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
jDialog3.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
Connection con;
String sql = null;
if(jComboBox1.getSelectedItem().equals("Bu gun")){
    sql ="select * from isciodenisi where Day(Tarixisci)=Day(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu hefte")){
    sql ="select * from isciodenisi where Week(Tarixisci)=Week(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu ay")){
    sql ="select * from isciodenisi where Month(Tarixisci)=Month(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu il")){
     sql ="select * from isciodenisi where Year(Tarixisci)=Year(CURDATE())";
}else{
     sql ="select * from isciodenisi";
}
        try {
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//isciodenisi.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
Connection con;
String sql = null;
if(jComboBox1.getSelectedItem().equals("Bu gun")){
    sql ="select * from digerodenis where Day(Tarixdiger)=Day(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu hefte")){
    sql ="select * from digerodenis where Week(Tarixdiger)=Week(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu ay")){
    sql ="select * from digerodenis where Month(Tarixdiger)=Month(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu il")){
     sql ="select * from digerodenis where Year(Tarixdiger)=Year(CURDATE())";
}else{
     sql ="select * from digerodenis";
}
        try {
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//digerodenisler.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
Connection con;
String sql = null;
if(jComboBox1.getSelectedItem().equals("Bu gun")){
    sql ="select * from mehsulalma where Day(tarix)=Day(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu hefte")){
    sql ="select * from mehsulalma where Week(tarix)=Week(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu ay")){
    sql ="select * from mehsulalma where Month(tarix)=Month(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu il")){
     sql ="select * from mehsulalma where Year(tarix)=Year(CURDATE())";
}else{
     sql ="select * from mehsulalma";
}
        try {
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//mehsulalmaq.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
Connection con;
String sql = null;
if(jComboBox1.getSelectedItem().equals("Bu gun")){
    sql ="select * from techizatciodenisi where Day(tarixTechizatci)=Day(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu hefte")){
    sql ="select * from techizatciodenisi where Week(tarixTechizatci)=Week(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu ay")){
    sql ="select * from techizatciodenisi where Month(tarixTechizatci)=Month(CURDATE())";
}else if(jComboBox1.getSelectedItem().equals("Bu il")){
     sql ="select * from techizatciodenisi where Year(tarixTechizatci)=Year(CURDATE())";
}else{
     sql ="select * from techizatciodenisi";
}
        try {
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//techizatciodenis.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
jDialog4.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            refresh();        // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
 try {
     Connection con ;
     String sql = "select mehsul ,sum(miqdar) from satis group by mehsul order by sum(miqdar) desc";
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//encoxsatilanmehsullar.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
 try {
     Connection con ;
     String sql = "select mehsulAd,sonTarix from mehsullar order by SonTarix";
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//sontarixeyaxinlasanlar.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
 try {
     Connection con ;
     String sql = "select musteri , sum(tutar) from satis group by musteri order by sum(tutar) desc;";
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//encoxsatinalanmusteri.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
 try {
     Connection con ;
     String sql = "select mehsulAd , mehsulSay from mehsullar order by mehsulSay;";
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//bazadaazqalanmehsul.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
try {
     Connection con ;
     String sql = "select techizatciAd , sum(Tutar) from mehsulalma group by techizatciad order by sum(tutar) desc ;";
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//encoxsatantechizatci.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }           // TODO add your handling code here:
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
 try {
     Connection con ;
     String sql = "select isciad, sum(odenisisci) from isciodenisi group by isciad order by sum(odenisisci) desc;";
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//encoxodenenisci.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }         // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
Connection con;
String sql = "select sebeb , sum(miqdar) from digerodenis group by sebeb order by sum(miqdar) desc;";

        try {
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//encoxdigerodenis.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }          // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
 try {
     Connection con ;
     String sql = "select mehsul ,sum(miqdar) from satis group by mehsul order by sum(miqdar) asc";
        con = DBConnect.baglan();
        JasperDesign jd=JRXmlLoader.load(CheklerYolu+"//src/pdfler//enazsatilanmehsul.jrxml");
        JRDesignQuery query =new JRDesignQuery();
        query.setText(sql);
        jd.setQuery(query);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
        //  JasperViewer.viewReport(jp);
        JInternalFrame iframe = new JInternalFrame("Reporte");
        iframe.getContentPane().add(new net.sf.jasperreports.swing.JRViewer(jp));
        iframe.pack();
        iframe.setResizable(true);
        iframe.setClosable(true);
        iframe.setMaximizable(true);
        iframe.setSize(1000,700);
        jDesktopPane2.add(iframe);
        iframe.setVisible(true);
        try{
        iframe.setMaximum(true);
        }catch(Exception e){
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton35ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dashboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
