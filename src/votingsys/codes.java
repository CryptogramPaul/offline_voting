/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votingsys;

import com.voting.main.login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static com.voting.main.login.conn;

/**
 *
 * @author acerpc
 */
public class codes {
        public static Statement stmt = null;
        public static ResultSet rst = null;
        public static  String RecAction="";
        public static PreparedStatement ps;
    
        
        public static ArrayList<studarray> studs(){
            
        ArrayList<studarray> getcus = new ArrayList<>();
        login.setcon();
      
        String query = "SELECT * FROM `tb_students`";
        try{
           stmt = conn.createStatement();
           rst = stmt.executeQuery(query);
           studarray carry;
           while(rst.next()){
               carry = new studarray(rst.getInt("studid"),rst.getString("schoolid"),rst.getString("fname"),rst.getString("mname"),  rst.getString("lname"), rst.getString("course"),
                       rst.getString("username"), rst.getString("password"), rst.getString("status"));
               getcus.add(carry);
           }
        }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
        return getcus;    
   
   
       // the above codes states the connection to the databes. to call all the data under the table : customers

  }
     
         public static void showstudents(){
       ArrayList <studarray> clist = studs();
       DefaultTableModel model = (DefaultTableModel) home111.jTable1.getModel();
       model.setRowCount(0);
       Object[] row = new Object[9];
       
       for(int d = 0; d < clist.size();d++){
           row[0] = clist.get(d).getstudid();
           row[1] = clist.get(d).getschoolid();
           row[2] = clist.get(d).getfname();
           row[3] = clist.get(d).getmname();
           row[4] = clist.get(d).getlname();
           row[5] = clist.get(d).getcourse();
           row[6] = clist.get(d).getusername();
           row[7] = clist.get(d).getpassword();
           row[8] = clist.get(d).getstatus();
           
           
           model.addRow(row);
       }
      }
         
         public static void addstud(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_students`(schoolid,fname, mname,lname, course, username, password, status)" + "values(?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField2.getText());
             ps.setString(2, home111.jTextField3.getText());
             ps.setString(3, home111.jTextField4.getText());
             ps.setString(4, home111.jTextField5.getText());
             ps.setString(5, home111.jComboBox1.getSelectedItem().toString());
             ps.setString(6, home111.jTextField6.getText());
             ps.setString(7, home111.jTextField7.getText());
             ps.setString(8, "Registered");
             
             
             ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showstudents();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }
         
         public static void textrefresh(){
         home111.jTextField2.setText(" ");
         home111.jTextField3.setText(" ");
         home111.jTextField4.setText(" ");
         home111.jTextField5.setText(" ");
         home111.jTextField6.setText(" ");
         home111.jTextField7.setText(" ");
         home111.jComboBox1.setSelectedItem("BSED");
         
         home111.jTextField9.setText(" ");
         home111.jTextField10.setText(" ");
         home111.jTextField11.setText(" ");
         
         }
         
         public static void setSTUD(){
            int row = home111.jTable1.getSelectedRow();
            home111.jTextField2.setText(home111.jTable1.getValueAt(row, 1).toString());
            home111.jTextField3.setText(home111.jTable1.getValueAt(row, 2).toString());
            home111.jTextField4.setText(home111.jTable1.getValueAt(row, 3).toString());
            home111.jTextField5.setText(home111.jTable1.getValueAt(row, 4).toString());
            home111.jComboBox1.setSelectedItem(home111.jTable1.getValueAt(row, 5).toString());
            home111.jTextField6.setText(home111.jTable1.getValueAt(row, 6).toString());
            home111.jTextField7.setText(home111.jTable1.getValueAt(row, 7).toString());
         
         
         }
         
         public static void editstud(){
            String equery;
            login.setcon();
            try{
                int row = home111.jTable1.getSelectedRow();
                String id = home111.jTable1.getValueAt(row, 0).toString();

                equery = "UPDATE `tb_students` SET schoolid =?, fname = ?, mname = ?, lname = ?, course = ?,username = ?, password = ?, status = ? WHERE studid = ?";
                ps = conn.prepareStatement(equery);

                ps.setString(1, home111.jTextField2.getText());
                ps.setString(2, home111.jTextField3.getText());
                ps.setString(3, home111.jTextField4.getText());
                ps.setString(4, home111.jTextField5.getText());
                ps.setString(5, home111.jComboBox1.getSelectedItem().toString());
                ps.setString(6, home111.jTextField6.getText());
                ps.setString(7, home111.jTextField7.getText());
                ps.setString(8, "Registered");
                ps.setString(9, id);

                ps.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Record Updated");
                showstudents();
                textrefresh();
            }catch(Exception ee){JOptionPane.showMessageDialog(null, ee);} 
  
             // this code enable to system to edit a van data into the database and automatically show the record to the table "vanlist"

            } 
         
         public static void deletecus(){  
              int dialogButton;
            dialogButton =  JOptionPane.showConfirmDialog(null, "CONTINUE TO DELETE STUDENT?");
       int row = home111.jTable1.getSelectedRow();
    String id = home111.jTable1.getValueAt(row, 0).toString();
            
     if(!id.equals("") && dialogButton == JOptionPane.YES_OPTION){
         try{
             login.setcon();
             ps = conn.prepareStatement("DELETE FROM `tb_students` WHERE studid = ?");
             int ad = Integer.parseInt(id);
             ps.setInt(1, ad);
             ps.executeUpdate();
             JOptionPane.showMessageDialog(null, "Record Deleted");
            showstudents();
            textrefresh();
         }catch(Exception ee){JOptionPane.showMessageDialog(null, ee);}
     }else if(dialogButton == JOptionPane.NO_OPTION)
    JOptionPane.showMessageDialog(null, "Cancelled");
{   
    
 } 
         }   
   
         public static void deleteCAN(){  
              int dialogButton;
            dialogButton =  JOptionPane.showConfirmDialog(null, "CONTINUE TO DELETE STUDENT?");
       int row = home111.jTable2.getSelectedRow();
    String id = home111.jTable2.getValueAt(row, 0).toString();
            
     if(!id.equals("") && dialogButton == JOptionPane.YES_OPTION){
         try{
             login.setcon();
             ps = conn.prepareStatement("DELETE FROM `tb_candidates` WHERE studid = ?");
             int ad = Integer.parseInt(id);
             ps.setInt(1, ad);
             ps.executeUpdate();
             JOptionPane.showMessageDialog(null, "Record Deleted");
            showstudents();
            textrefresh();
         }catch(Exception ee){JOptionPane.showMessageDialog(null, ee);}
     }else if(dialogButton == JOptionPane.NO_OPTION)
    JOptionPane.showMessageDialog(null, "Cancelled");
{   
    
 } 
         }   
   
         public static void searchstud(){
     DefaultTableModel model = (DefaultTableModel)home111.jTable1.getModel();
       model.setRowCount(0);
       
    String vn = home111.jComboBox2.getSelectedItem().toString();
    
    
    try{
        login.setcon();
        rst = stmt.executeQuery("SELECT * FROM `tb_students` WHERE `course` = '"+vn+"' ");
        while(rst.next()){
            model.addRow(new Object[]{
        rst.getInt("studid"),
        rst.getString("schoolid"),
        rst.getString("fname"),
        rst.getString("mname"),
        rst.getString("lname"),
        rst.getString("course"),
        rst.getString("username"),
        rst.getString("password")
                    
                    
                   
            });
          
            
            }
   
        
    }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
    
 }
         
         public static void addchairman(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_chairman`(fname, mname,lname, course, pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
             
             ps.executeUpdate();
             
             
               
             ps = conn.prepareStatement("INSERT INTO `tb_candidates`(fname, mname,lname, course, sy, position,pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }  
                  
         public static void addvc(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_vicechairman`(fname, mname,lname, course, pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
             
             ps.executeUpdate();
             
             
               
                 
             ps = conn.prepareStatement("INSERT INTO `tb_candidates`(fname, mname,lname, course, sy, position,pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }  
        
         public static void addsec(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_sec`(fname, mname,lname, course, pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
             
             ps.executeUpdate();
             
             
               
                 
             ps = conn.prepareStatement("INSERT INTO `tb_candidates`(fname, mname,lname, course, sy, position,pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }  
     
         public static void addasssec(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_assec`(fname, mname,lname, course, pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
             
             ps.executeUpdate();
             
             
               
                 
             ps = conn.prepareStatement("INSERT INTO `tb_candidates`(fname, mname,lname, course, sy, position,pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }  
     
         public static void addtres(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_treas`(fname, mname,lname, course, pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
             
             ps.executeUpdate();
             
             
               
                 
             ps = conn.prepareStatement("INSERT INTO `tb_candidates`(fname, mname,lname, course, sy, position,pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }  
     
         public static void addasstreas(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_astreas`(fname, mname,lname, course, pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
             
             ps.executeUpdate();
             
             
               
                 
             ps = conn.prepareStatement("INSERT INTO `tb_candidates`(fname, mname,lname, course, sy, position,pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }  
     
         public static void addaud(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_aud`(fname, mname,lname, course, pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
             
             ps.executeUpdate();
             
             
               
                 
             ps = conn.prepareStatement("INSERT INTO `tb_candidates`(fname, mname,lname, course, sy, position,pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }  
     
         public static void addassaud(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_asaud`(fname, mname,lname, course, pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
             
             ps.executeUpdate();
             
             
               
                 
             ps = conn.prepareStatement("INSERT INTO `tb_candidates`(fname, mname,lname, course, sy, position,pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }  
     
         public static void addbm(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_bm`(fname, mname,lname, course, pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
             
             ps.executeUpdate();
             
             
               
                 
             ps = conn.prepareStatement("INSERT INTO `tb_candidates`(fname, mname,lname, course, sy, position,pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }  
     
         public static void addabm(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_abm`(fname, mname,lname, course, pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
             
             ps.executeUpdate();
             
             
               
                 
             ps = conn.prepareStatement("INSERT INTO `tb_candidates`(fname, mname,lname, course, sy, position,pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }  
     
         public static void addpio(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_pio`(fname, mname,lname, course, pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
             
             ps.executeUpdate();
             
             
               
                 
             ps = conn.prepareStatement("INSERT INTO `tb_candidates`(fname, mname,lname, course, sy, position,pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }  
     
         public static void addcoun(){
          try{
             login.setcon();
               
              
             ps = conn.prepareStatement("INSERT INTO `tb_coun`(fname, mname,lname, course, pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
             
             ps.executeUpdate();
             
             
               
                 
             ps = conn.prepareStatement("INSERT INTO `tb_candidates`(fname, mname,lname, course, sy, position,pic, coc,biodata,tor,rf,gm,party)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Added");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           }  
     
        public static void showchair(){
            DefaultTableModel model = (DefaultTableModel)home111.jTable2.getModel();
                model.setRowCount(0);    
                try{
                    login.setcon();
                    rst = stmt.executeQuery("SELECT * FROM `tb_candidates` ");
                    while(rst.next()){
                        model.addRow(new Object[]{
                        rst.getInt("canid"),
                        rst.getString("fname"),
                        rst.getString("mname"),
                        rst.getString("lname"),
                        rst.getString("course") ,
                        rst.getString("pic"),
                        rst.getString("coc"),
                        rst.getString("biodata"),
                        rst.getString("tor"),
                        rst.getString("rf"),
                        rst.getString("gm"),
                        rst.getString("position"),
                        rst.getString("party")
                        });
                    }
                }catch(Exception error){JOptionPane.showMessageDialog(null, error);}

        }
         
        public static void filterbypos(){
            DefaultTableModel model = (DefaultTableModel)home111.jTable2.getModel();
            model.setRowCount(0);

            String pos = home111.jComboBox4.getSelectedItem().toString();

            try{
               login.setcon();
               rst = stmt.executeQuery("SELECT * FROM `tb_candidates` WHERE `position` = '"+pos+"'");
                    while(rst.next()){
                        model.addRow(new Object[]{
                    rst.getInt("canid"),
                    rst.getString("fname"),
                    rst.getString("mname"),
                    rst.getString("lname"),
                    rst.getString("course") ,
                    rst.getString("pic"),
                    rst.getString("coc"),
                    rst.getString("biodata"),
                    rst.getString("tor"),
                    rst.getString("rf"),
                    rst.getString("gm"),
                    rst.getString("position"),
                    rst.getString("party")     
                 });
            }
            }catch(Exception error){
                JOptionPane.showMessageDialog(null, error);
            }
        }
         
         public static void editcan(){
          try{
             login.setcon();
                int row = home111.jTable2.getSelectedRow();
                String id = home111.jTable2.getValueAt(row, 0).toString();
                String fn = home111.jTable2.getValueAt(row, 1).toString();
                String ln = home111.jTable2.getValueAt(row, 3).toString(); 
              
             ps = conn.prepareStatement("UPDATE `tb_chairman` SET fname=?, mname=?,lname=?, course=?, pic=?, coc=?,biodata=?,tor=?,rf=?,gm=?,party=? WHERE fname = '"+fn+"' AND lname='"+ln+"'");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jLabel21.getText());
             ps.setString(6, home111.jLabel20.getText());
             ps.setString(7, home111.jLabel22.getText());
             ps.setString(8, home111.jLabel23.getText());
             ps.setString(9, home111.jLabel24.getText());
             ps.setString(10, home111.jLabel25.getText());
             ps.setString(11, home111.jComboBox5.getSelectedItem().toString());
            
             ps.executeUpdate();
             
             
               
             ps = conn.prepareStatement("UPDATE `tb_candidates` SET fname=?, mname=?,lname=?, course=?, sy=?, position=?,pic=?, coc=?,biodata=?,tor=?,rf=?,gm=?,party=? WHERE canid = '"+id+"'");
             ps.setString(1, home111.jTextField9.getText());
             ps.setString(2, home111.jTextField10.getText());
             ps.setString(3, home111.jTextField11.getText());
             ps.setString(4, home111.jComboBox3.getSelectedItem().toString());
             ps.setString(5, home111.jComboBox6.getSelectedItem().toString());
             ps.setString(6, home111.jComboBox4.getSelectedItem().toString());
             ps.setString(7, home111.jLabel21.getText());
             ps.setString(8, home111.jLabel20.getText());
             ps.setString(9, home111.jLabel22.getText());
             ps.setString(10, home111.jLabel23.getText());
             ps.setString(11, home111.jLabel24.getText());
             ps.setString(12, home111.jLabel25.getText());
             ps.setString(13, home111.jComboBox5.getSelectedItem().toString());
              ps.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Record Updated");
             showchair();
             textrefresh();
         }catch(Exception error){JOptionPane.showMessageDialog(null, error);}
     
           
       
// this code enable to system to add a van data into the database and automatically show the record to the table "vanlist"

           } 
         
         public static void setcan(){
             int row = home111.jTable2.getSelectedRow();
         home111.jTextField9.setText(home111.jTable2.getValueAt(row, 1).toString());
         home111.jTextField10.setText(home111.jTable2.getValueAt(row, 2).toString());
         home111.jTextField11.setText(home111.jTable2.getValueAt(row, 3).toString());
         home111.jComboBox3.setSelectedItem(home111.jTable2.getValueAt(row, 4).toString());
         home111.jLabel21.setText(home111.jTable2.getValueAt(row, 5).toString());
         home111.jLabel20.setText(home111.jTable2.getValueAt(row, 6).toString());
         home111.jLabel22.setText(home111.jTable2.getValueAt(row, 7).toString());
         home111.jLabel23.setText(home111.jTable2.getValueAt(row, 8).toString());
         home111.jLabel24.setText(home111.jTable2.getValueAt(row, 9).toString());
         home111.jLabel25.setText(home111.jTable2.getValueAt(row, 10).toString());
         home111.jComboBox5.setSelectedItem(home111.jTable2.getValueAt(row, 11).toString());
         home111.jComboBox4.setSelectedItem(home111.jTable2.getValueAt(row, 12).toString());
         
         String pic = home111.jTable2.getValueAt(row, 5).toString();
         String coc = home111.jTable2.getValueAt(row, 6).toString();
         String bd = home111.jTable2.getValueAt(row, 7).toString();
         String tor = home111.jTable2.getValueAt(row, 8).toString();
         String rf  = home111.jTable2.getValueAt(row, 9).toString();
         String gm = home111.jTable2.getValueAt(row, 10).toString();
         String y = "Y";
         
         if(pic.equals(y)){
         home111.jCheckBox1.setSelected(true);
         }else if(pic.equals("")){
         home111.jCheckBox1.setSelected(false);
         }
         
         if(coc.equals(y)){
         home111.jCheckBox2.setSelected(true);
         }else if(coc.equals("")){
         home111.jCheckBox2.setSelected(false);
         }
         
         if(bd.equals(y)){
         home111.jCheckBox3.setSelected(true);
         }else if(bd.equals("")){
         home111.jCheckBox3.setSelected(false);
         }
         
         if(tor.equals(y)){
         home111.jCheckBox4.setSelected(true);
         }else if(tor.equals("")){
         home111.jCheckBox4.setSelected(false);
         }
         
         
         if(rf.equals(y)){
         home111.jCheckBox5.setSelected(true);
         }else if(rf.equals("")){
         home111.jCheckBox5.setSelected(false);
         }
         
         
         if(gm.equals(y)){
         home111.jCheckBox6.setSelected(true);
         }else if(gm.equals("")){
         home111.jCheckBox6.setSelected(false);
         }
         
         }
         
}
