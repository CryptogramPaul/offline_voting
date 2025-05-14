/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.controller;

import com.voting.connection.database;
import com.voting.model.StudentModel;
import com.voting.studentrecords.StudentRecords;
import static com.voting.studentrecords.StudentRecords.Course;
import static com.voting.studentrecords.StudentRecords.CourseFilter;
import static com.voting.studentrecords.StudentRecords.Fname;
import static com.voting.studentrecords.StudentRecords.Lname;
import static com.voting.studentrecords.StudentRecords.Mname;
import static com.voting.studentrecords.StudentRecords.Password;
import static com.voting.studentrecords.StudentRecords.SchoolID;
import static com.voting.studentrecords.StudentRecords.StudentDelete;
import static com.voting.studentrecords.StudentRecords.StudentSave;
import static com.voting.studentrecords.StudentRecords.Username;
import static com.voting.studentrecords.StudentRecords.showRecord;
import static com.voting.studentrecords.StudentRecords.tbm_student;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//import com.voting.studentrecords.StudentRecords.tbm_student;

public class students {
    private static String query;
    
    public static void showrecord(String filter) {  
        tbm_student.setRowCount(0);  
        try{            
            
            database.openConn();
            if (!filter.equalsIgnoreCase("All")) {
                query = "SELECT * FROM `tb_students` WHERE course = ? ORDER BY studid DESC";
                database.ps = database.conn.prepareStatement(query);
                database.ps.setString(1, filter);
            } else {
                query = "SELECT * FROM `tb_students` ORDER BY studid DESC";
                database.ps = database.conn.prepareStatement(query);
            }
            
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {
                tbm_student.addRow(new Object[]{
                     database.rs.getString("studid"),
                     database.rs.getString("schoolid"),
                     database.rs.getString("fname"),      
                     database.rs.getString("mname"),
                     database.rs.getString("lname"),
                     database.rs.getString("course"),
                     database.rs.getString("username"),                    
                     database.rs.getString("password"),
                     database.rs.getString("status"),
                });
            }
//            System.out.print("run......................");
            
         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }

    }
    
    public static void AddStudent(StudentModel model){
         try{
             database.openConn();
            
            query = "INSERT INTO `tb_students`(schoolid,fname, mname,lname, course, username, password, status)values(?,?,?,?,?,?,?,?)";
            
            database.ps =  database.conn.prepareStatement(query);
            database.ps.setString(1, model.getSchoolid());
            database.ps.setString(2, model.getFname());
            database.ps.setString(3, model.getMname());
            database.ps.setString(4, model.getLname());
            database.ps.setString(5, model.getCourse());
            database.ps.setString(6, model.getUsername());
            database.ps.setString(7, model.getPassword());
            database.ps.setString(8, "Registered");
             
            database.ps.executeUpdate();
      
            JOptionPane.showMessageDialog(null, "Save successfully");
            textrefresh();

         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void textrefresh(){
        StudentSave.setText("SAVE");
        SchoolID.setText("");
        Fname.setText("");
        Mname.setText("");
        Lname.setText("");
        Username.setText("");
        Password.setText("");
        CourseFilter.setSelectedIndex(0);
        Course.setSelectedIndex(0);
        StudentDelete.setEnabled(false);
        StudentRecords.OperationUpdate = 0;
        showRecord();       
    }

    public static void UpdateStudent(StudentModel model) {
        try{
            database.openConn();
            
            query = "UPDATE `tb_students` SET schoolid =?, fname = ?, mname = ?, lname = ?, course = ?,username = ?, password = ?, status = ? WHERE studid = ?";
            database.ps = database.conn.prepareStatement(query);

                database.ps.setString(1, model.getSchoolid() );
                database.ps.setString(2, model.getFname());
                database.ps.setString(3, model.getMname());
                database.ps.setString(4, model.getLname());
                database.ps.setString(5, model.getCourse().toString());
                database.ps.setString(6, model.getUsername());
                database.ps.setString(7, model.getPassword());
                database.ps.setString(8, "Registered");
                database.ps.setInt(9, StudentRecords.student_id );

                database.ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Update successfully");
                textrefresh();
             

         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void edit(){
            StudentRecords.OperationUpdate = 1;
            StudentSave.setText("UPDATE");
            int row = StudentRecords.studentrecords.getSelectedRow();
            String studid = StudentRecords.studentrecords.getValueAt(row, 0).toString();
            StudentRecords.student_id = Integer.parseInt(studid);
            StudentRecords.SchoolID.setText(StudentRecords.studentrecords.getValueAt(row, 1).toString());
            StudentRecords.Fname.setText(StudentRecords.studentrecords.getValueAt(row, 2).toString());
            StudentRecords.Mname.setText(StudentRecords.studentrecords.getValueAt(row, 3).toString());
            StudentRecords.Lname.setText(StudentRecords.studentrecords.getValueAt(row, 4).toString());
            StudentRecords.Course.setSelectedItem(StudentRecords.studentrecords.getValueAt(row, 5).toString());
            StudentRecords.Username.setText(StudentRecords.studentrecords.getValueAt(row, 6).toString());
            StudentRecords.Password.setText(StudentRecords.studentrecords.getValueAt(row, 7).toString());
        
    }
    
    public static void delete(){
        try{
            database.openConn();
            
            query = "DELETE FROM tb_students WHERE studid = ?";
            database.ps = database.conn.prepareStatement(query);

                database.ps.setInt(1, StudentRecords.student_id );

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
