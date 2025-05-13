package com.voting.connection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static com.voting.main.login.conn;
import static com.voting.main.login.stmt;


public class database {
    public static ResultSet rs;
    public static PreparedStatement ps;
    public static Connection conn;
    public static String server, port, db, password, user;
     
    public static void openConn() {

        server = "localhost";
        port = ":3306";
        db = "db_voting";
        password = "";
        user = "root";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + server + port + "/" + db + "", "'" + user + "'", password);
        } catch ( SQLException err ) {
            JOptionPane.showMessageDialog(null, err);
            closeConn();
        }
    }

    public static void closeConn(){

        if ( rs != null ) {
            try {
                rs.close();
            } catch ( SQLException ex ) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if ( ps != null ) {
            try {
                ps.close();
            } catch ( SQLException ex ) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if ( conn != null ) {
            try {
                conn.close();
            } catch ( SQLException ex ) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void setString(int i, String registered) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
