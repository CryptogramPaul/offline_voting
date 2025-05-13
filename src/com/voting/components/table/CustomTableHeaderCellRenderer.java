/**
 * @(#)DefaultTableHeaderCellRenderer.java	1.0 02/24/09
 */
package com.voting.components.table;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 * A default cell renderer for a JTableHeader.
 * <P>
 * CustomTableHeaderCellRenderer attempts to provide identical behavior to the
 * renderer which the Swing subsystem uses by default, the Sun proprietary class
 * sun.swing.table.DefaultTableCellHeaderRenderer.
 * <P>
 * To apply any desired customization, CustomTableHeaderCellRenderer may be
 * suitably extended.
 *
 * @author Darryl
 */
public class CustomTableHeaderCellRenderer extends DefaultTableCellRenderer {

    /**
     * Constructs a <code>DefaultTableHeaderCellRenderer</code>.
     * <P>
     * The horizontal alignment and text position are set as appropriate to a
     * table header cell, and the opaque property is set to false.
     */
    public CustomTableHeaderCellRenderer() {

        setPreferredSize(new Dimension(this.getWidth(), 70));
        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(true);
       
    }

    /**
     * Returns the default table header cell renderer.
     * <P>
     * If the column is sorted, the approapriate icon is retrieved from the
     * current Look and Feel, and a border appropriate to a table header cell is
     * applied.
     * <P>
     * Subclasses may overide this method to provide custom content or
     * formatting.
     *
     * @param table the <code>JTable</code>.
     * @param value the value to assign to the header cell
     * @param isSelected This parameter is ignored.
     * @param hasFocus This parameter is ignored.
     * @param row This parameter is ignored.
     * @param column the column of the header cell to render
     * @return the default table header cell renderer
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);
        JTableHeader tableHeader = table.getTableHeader();
        if (tableHeader != null) {
            setForeground(tableHeader.getForeground());
        }        
        setIcon(getIcon(table, column));
        setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(235, 235, 235)));
//        setForeground(new java.awt.Color(95, 95, 95));
        setForeground(new java.awt.Color(51, 51, 51));
        setFont(new Font("Poppins", Font.PLAIN, 14));

//        setAutoCreateRowSorter(true);
//        setAutoResizeMode(0);
//        setOpaque(false);
//        tableHeader.setBackground(new java.awt.Color(255, 255, 255));
//        setPreferredSize(new Dimension(this.getWidth(), 65));
        return this;
    }

    /**
     * Overloaded to return an icon suitable to the primary sorted column, or
     * null if the column is not the primary sort key.
     *
     * @param table the <code>JTable</code>.
     * @param column the column index.
     * @return the sort icon, or null if the column is unsorted.
     */
    protected Icon getIcon(JTable table, int column) {
        SortKey sortKey = getSortKey(table, column);
        if (sortKey != null && table.convertColumnIndexToView(sortKey.getColumn()) == column) {
            switch (sortKey.getSortOrder()) {
                case ASCENDING:
                    return UIManager.getIcon("Table.ascendingSortIcon");
                case DESCENDING:
                    return UIManager.getIcon("Table.descendingSortIcon");
            }
        }
        return null;
    }

    /**
     * Returns the current sort key, or null if the column is unsorted.
     *
     * @param table the table
     * @param column the column index
     * @return the SortKey, or null if the column is unsorted
     */
    protected SortKey getSortKey(JTable table, int column) {
        RowSorter rowSorter = table.getRowSorter();
        if (rowSorter == null) {
            return null;
        }

        List sortedColumns = rowSorter.getSortKeys();
        if (sortedColumns.size() > 0) {
            return (SortKey) sortedColumns.get(0);
        }
        return null;
    }

}
