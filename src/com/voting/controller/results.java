package com.voting.controller;

import com.voting.connection.database;
import static com.voting.result.Result.bsed;
import static com.voting.result.Result.bsict;
import static com.voting.result.Result.no_votes;
import static com.voting.result.Result.total_students;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class results {
    private static String query;
//    private static int total
    public static void GetNoOfStudents(){
        
        try{            
            
            database.openConn();
            
           
            query = "SELECT count(*) as count_student FROM `tb_students` ";
            database.ps = database.conn.prepareStatement(query);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                total_students.setText(database.rs.getString("count_student"));
//                System.out.print(database.rs.getInt("count_student"));
            }
            
         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetNoOfVotes(){
        
        try{            
            database.openConn();
            
            query = "SELECT count(*) as votes FROM `tb_vote` ";
            database.ps = database.conn.prepareStatement(query);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                no_votes.setText(database.rs.getString("votes"));
//                System.out.print(database.rs.getInt("count_student"));
            }
            
         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetBSED(){
        
        try{     
            int bsed_count = 0;
            int students_count = 0;
            
            database.openConn();
            
            String sql_bsed = "SELECT count(*) as votes " +
"                              FROM tb_vote a " +
"                              LEFT JOIN tb_students b ON a.studid = b.studid " +
"                              WHERE b.course = 'BSED' OR b.course = 'BTVTED' OR b.course = 'BEED' ";
            database.ps = database.conn.prepareStatement(sql_bsed);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                bsed_count = database.rs.getInt("votes");
            }
            
            String total_students = "SELECT count(*) as students FROM tb_students WHERE course = 'BSED' OR course = 'BTVTED' OR course = 'BEED' ";
            database.ps = database.conn.prepareStatement(total_students);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                students_count = database.rs.getInt("students");
            }
            
            double percentage = (bsed_count * 100) / students_count;
            
            bsed.setValue((int) Double.parseDouble(String.format("%.2f", percentage)));
            System.out.println(String.format("%.2f", percentage) + "%" );
            System.out.println(bsed_count);
            System.out.print(students_count);
            
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
       
    }
    
    public static void GetIct(){
        
        try{     
            int vote_count = 0;
            int students_count = 0;
            
            database.openConn();
            
            String sql_bsed = "SELECT count(*) as votes " +
"                                                FROM tb_vote a \n" +
"                                                LEFT JOIN tb_students b ON a.studid = b.studid \n" +
"                                                WHERE b.course = 'BSICT' ";
            database.ps = database.conn.prepareStatement(sql_bsed);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                vote_count = database.rs.getInt("votes");
            }
            
            String total_students = "SELECT count(*) as students FROM tb_students WHERE course = 'BSICT' ";
            database.ps = database.conn.prepareStatement(total_students);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                students_count = database.rs.getInt("students");
            }
            
            double percentage = (vote_count * 100) / students_count;
            
            bsict.setValue((int) Double.parseDouble(String.format("%.2f", percentage)));
            System.out.println(String.format("%.2f", percentage) + "%" );
            System.out.println(vote_count);
            System.out.print(students_count);
            
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
       
    }
}
