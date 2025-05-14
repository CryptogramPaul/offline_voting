
package com.voting.controller;

import com.voting.candidates.Candidates;
import static com.voting.candidates.Candidates.CandidateDelete;
import static com.voting.candidates.Candidates.CandidateSave;
import static com.voting.candidates.Candidates.biodata;
import static com.voting.candidates.Candidates.can_course;
import static com.voting.candidates.Candidates.candidate_id;
import static com.voting.candidates.Candidates.coc;
import static com.voting.candidates.Candidates.firstname;
import static com.voting.candidates.Candidates.gm;
import static com.voting.candidates.Candidates.lastname;
import static com.voting.candidates.Candidates.middlename;
import static com.voting.candidates.Candidates.party;
import static com.voting.candidates.Candidates.picture;
import static com.voting.candidates.Candidates.rf;
import static com.voting.candidates.Candidates.schoolyear;
import static com.voting.candidates.Candidates.showRecord;
import static com.voting.candidates.Candidates.tbm_candidates;
import static com.voting.candidates.Candidates.tor;
import com.voting.connection.database;
import com.voting.main.login;
import com.voting.model.CandidateModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class candidates {
    private static String query;
    
     public static void showrecord() {  
        tbm_candidates.setRowCount(0);  
        try{            
            
            database.openConn();
            
           
            query = "SELECT * FROM `tb_candidates` ORDER BY canid DESC";
            database.ps = database.conn.prepareStatement(query);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {
                tbm_candidates.addRow(new Object[]{
                        database.rs.getInt("canid"),
                        database.rs.getString("fname"),
                        database.rs.getString("mname"),
                        database.rs.getString("lname"),
                        database.rs.getString("course") ,
                        database.rs.getString("pic"),
                        database.rs.getString("coc"),
                        database.rs.getString("biodata"),
                        database.rs.getString("tor"),
                        database.rs.getString("rf"),
                        database.rs.getString("gm"),
                        database.rs.getString("position"),
                        database.rs.getString("party")
                });
            }
//            System.out.print("run......................");
            
         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }

    }

   
    public void filterbypos(DefaultTableModel tbm, String Filter) {
        tbm_candidates.setRowCount(0);  
        try{            
            database.openConn();
            
            query = "SELECT * FROM `tb_candidates` WHERE `position` = ? ORDER BY canid DESC ";
            database.ps = database.conn.prepareStatement(query);
            database.ps.setString(1, Filter);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {
                tbm_candidates.addRow(new Object[]{
                     database.rs.getInt("canid"),
                        database.rs.getString("fname"),
                        database.rs.getString("mname"),
                        database.rs.getString("lname"),
                        database.rs.getString("course") ,
                        database.rs.getString("pic"),
                        database.rs.getString("coc"),
                        database.rs.getString("biodata"),
                        database.rs.getString("tor"),
                        database.rs.getString("rf"),
                        database.rs.getString("gm"),
                        database.rs.getString("position"),
                        database.rs.getString("party")
                });
            }
//            System.out.print("run......................");
            
         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void textrefresh(){
        CandidateSave.setText("SAVE");
        firstname.setText("");
        middlename.setText("");
        lastname.setText("");
        can_course.setSelectedIndex(0);
        schoolyear.setSelectedIndex(0);
        party.setSelectedIndex(0);
        picture.setSelected(false);
        coc.setSelected(false);
        tor.setSelected(false);
        biodata.setSelected(false);
        rf.setSelected(false);
        gm.setSelected(false);
        CandidateDelete.setEnabled(false);
        Candidates.CandidateUpdate = 0;
        showRecord();       
    }
    
    public static void AddCandidate(CandidateModel model){
         try{
             database.openConn();
            
            query = "INSERT INTO `tb_candidates`(fname, mname, lname, course, sy, position, pic, coc, biodata, tor, rf, gm, party)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            database.ps =  database.conn.prepareStatement(query);
            database.ps.setString(1, model.getFirstname());
            database.ps.setString(2, model.getMiddlename());
            database.ps.setString(3, model.getLastname());
            database.ps.setString(4, model.getCourse());
            database.ps.setString(5, model.getSchoolyear());
            database.ps.setString(6, model.getPosition());
            database.ps.setString(7, model.getPicture());
            database.ps.setString(8, model.getCoc());
            database.ps.setString(9, model.getBiodata());
            database.ps.setString(10, model.getTor());
            database.ps.setString(11, model.getRf());
            database.ps.setString(12, model.getGm());
            database.ps.setString(13, model.getParty());
             
            database.ps.executeUpdate();
      
            JOptionPane.showMessageDialog(null, "Save successfully");
            textrefresh();

         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }

    public static void edit() {
         Candidates.CandidateUpdate = 1;
            CandidateSave.setText("UPDATE");
            int row = Candidates.CandidateTable.getSelectedRow();
            String canid = Candidates.CandidateTable.getValueAt(row, 0).toString();
            Candidates.candidate_id = Integer.parseInt(canid);
            firstname.setText(Candidates.CandidateTable.getValueAt(row, 1).toString());
            middlename.setText(Candidates.CandidateTable.getValueAt(row, 2).toString());
            lastname.setText(Candidates.CandidateTable.getValueAt(row, 3).toString());
            can_course.setSelectedItem(Candidates.CandidateTable.getValueAt(row, 4).toString());
//            Candidates.schoolyear.setSelectedItem(Candidates.CandidateTable.getValueAt(row, 5).toString());
            
            if (Candidates.CandidateTable.getValueAt(row, 5).toString().equals("Y") ) {
                picture.setSelected(true);
            }else{
                picture.setSelected(false);
            }
            
            if (Candidates.CandidateTable.getValueAt(row, 6).toString().equals("Y") ) {
                coc.setSelected(true);
            }else{
                coc.setSelected(false);
            }
            
            if (Candidates.CandidateTable.getValueAt(row, 7).toString().equals("Y") ) {
                biodata.setSelected(true);
            }else{
                biodata.setSelected(false);
            }
            
            if (Candidates.CandidateTable.getValueAt(row, 8).toString().equals("Y") ) {
                tor.setSelected(true);
            }else{
                tor.setSelected(false);
            }
            
            if (Candidates.CandidateTable.getValueAt(row, 9).toString().equals("Y") ) {
                rf.setSelected(true);
            }else{
                rf.setSelected(false);
            }
            
            if (Candidates.CandidateTable.getValueAt(row, 10).toString().equals("Y") ) {
                gm.setSelected(true);
            }else{
                gm.setSelected(false);
            }

            
            Candidates.position.setSelectedItem(Candidates.CandidateTable.getValueAt(row, 11).toString());
            Candidates.party.setSelectedItem(Candidates.CandidateTable.getValueAt(row, 12).toString());
    }
    
    public static void UpdateCandidate(CandidateModel candidate_model) {
        try{
            database.openConn();
            
            query = "UPDATE `tb_candidates` SET fname = ?, mname = ?, lname = ?, course = ?, sy = ?, position = ?, pic = ?, coc = ?, biodata = ?, tor = ?, rf = ?, gm = ?, party = ? WHERE canid = ? ";
            database.ps = database.conn.prepareStatement(query);

                database.ps.setString(1, candidate_model.getFirstname() );
                database.ps.setString(2, candidate_model.getMiddlename());
                database.ps.setString(3, candidate_model.getLastname());
                database.ps.setString(4, candidate_model.getCourse());
                database.ps.setString(5, candidate_model.getSchoolyear());
                database.ps.setString(6, candidate_model.getPosition());
                database.ps.setString(7, candidate_model.getPicture());
                database.ps.setString(8, candidate_model.getCoc());
                database.ps.setString(9, candidate_model.getBiodata());
                database.ps.setString(10, candidate_model.getTor());
                database.ps.setString(11, candidate_model.getRf());
                database.ps.setString(12, candidate_model.getGm());
                database.ps.setString(13, candidate_model.getParty());
                database.ps.setInt(14, Candidates.candidate_id );

                database.ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Update successfully");
                textrefresh();
             

         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void delete() {
        try{
            database.openConn();
            
            query = "DELETE FROM tb_candidates WHERE canid = ?";
            database.ps = database.conn.prepareStatement(query);

                database.ps.setInt(1, Candidates.candidate_id );
                database.ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Delete Successfully");
                textrefresh();
             
         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
}
