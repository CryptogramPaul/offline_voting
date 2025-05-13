package com.voting.controller;

import com.voting.connection.database;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class results {
    private static String query;
    
    public static void GetNoOfStudents(){
        
        try{            
            
            database.openConn();
            
           
            query = "SELECT count(*) as count_student FROM `tb_students` ";
            database.ps = database.conn.prepareStatement(query);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {                        
                System.out.print(database.rs.getInt("count_student"));
            }
            
         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
}
