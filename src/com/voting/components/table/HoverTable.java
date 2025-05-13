package com.voting.components.table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ma. Hazel F. Lastimoso
 */
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.*;

public class HoverTable extends JTable {

    private int rollOverRowIndex = -1;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public HoverTable() {

        setForeground(new java.awt.Color(51,51,51));
        setShowVerticalLines(false);
        setFont(new Font("Poppins", Font.PLAIN, 13));
        setIntercellSpacing(new java.awt.Dimension(0, 0));
        setSelectionBackground(new java.awt.Color(242, 242, 242));
        setGridColor(new java.awt.Color(235, 235, 235));
        setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        setRowHeight(40);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createEmptyBorder());
        setRowSelectionAllowed(false);
        setFocusable(false);
        setAutoCreateRowSorter(true);

        getTableHeader().setDefaultRenderer(new CustomTableHeaderCellRenderer());

        RollOverListener lst = new RollOverListener();
        addMouseMotionListener(lst);
        addMouseListener(lst);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if ( (row == rollOverRowIndex)) {
            c.setForeground(new java.awt.Color(51,51,51));
            c.setBackground(getSelectionBackground());
        } else {
            c.setForeground(getForeground());
            c.setBackground(getBackground());
        }
        ((JLabel) c).setHorizontalAlignment(JLabel.LEFT);
        return c;
    }

    public void addRow(Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRowCount(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Code for listener.
     */
    private class RollOverListener extends MouseInputAdapter {

        @Override
        public void mouseExited(MouseEvent e) {
            rollOverRowIndex = -1;
//            JOptionPane.showMessageDialog(null, "Repiant");
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            int row = rowAtPoint(e.getPoint());
            if (row != rollOverRowIndex) {
                rollOverRowIndex = row;
                repaint();
            }
        }
    }
}
