/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.components.table;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

/**
 *
 * @author Ma. Hazel F. Lastimoso
 */
public class CustomJScrollPane extends JScrollPane {

    public CustomJScrollPane() {
        setBorder(BorderFactory.createEmptyBorder());
        getViewport().setBackground(Color.decode("#FFFFFF"));
   
        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
    }

    public int getSelectedRow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getValueAt(int row, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
