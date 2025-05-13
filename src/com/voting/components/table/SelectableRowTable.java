/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.components.table;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;

/**
 *
 * @author Ma. Hazel F. Lastimoso
 */
public class SelectableRowTable extends JTable {

    private int rollOverRowIndex = -1;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public SelectableRowTable() {

        setForeground(new java.awt.Color(100, 100, 100));
        setShowVerticalLines(true);
        setShowHorizontalLines(true);
        setFont(new Font("Open Sans", Font.PLAIN, 13));
        setIntercellSpacing(new java.awt.Dimension(0, 0));
        setSelectionBackground(new java.awt.Color(242, 242, 242));
        setSelectionForeground(new java.awt.Color(100, 100, 100));
        setGridColor(new java.awt.Color(240, 240, 240));
        setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        setRowHeight(40);
//        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createEmptyBorder());
//        setRowSelectionAllowed(false);
        setFocusable(false);
        setAutoCreateRowSorter(true);

        getTableHeader().setDefaultRenderer(new CustomTableHeaderCellRenderer());

//        RollOverListener lst = new RollOverListener();
//        addMouseMotionListener(lst);
//        addMouseListener(lst);
    }

//    @Override
//    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
//        Component c = super.prepareRenderer(renderer, row, column);
//        if ((row == rollOverRowIndex)) {
//            c.setForeground(new java.awt.Color(234, 100, 100));
//            c.setBackground(getSelectionBackground());
//        } else {
//            c.setForeground(getForeground());
//            c.setBackground(getBackground());
//        }
//        ((JLabel) c).setHorizontalAlignment(JLabel.LEFT);
//        return c;
//    }
//    /**
//     * Code for listener.
//     */
//    private class RollOverListener extends MouseInputAdapter {
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//            rollOverRowIndex = -1;
////            JOptionPane.showMessageDialog(null, "Repiant");
//            repaint();
//        }
//
//        @Override
//        public void mouseMoved(MouseEvent e) {
//            int row = rowAtPoint(e.getPoint());
//            if (row != rollOverRowIndex) {
//                rollOverRowIndex = row;
//                repaint();
//            }
//        }
//    }
}
