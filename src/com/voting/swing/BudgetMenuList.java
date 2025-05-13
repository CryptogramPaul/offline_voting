/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.swing;

//import com.budget_monitoring.model.MenuModel;
import java.awt.Component;
import java.awt.MenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/**
 *
 * @author CEC-PC3
 * @param <E>
 */
public class BudgetMenuList <E extends Object> extends JList<E>{
//    private final DefaultListModel model;
//    private int selectedIndex = -1;
    
//    public ListMenu() {
//        model = new DefaultListModel();
//        setModel(model);
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent me) {
//                if (SwingUtilities.isLeftMouseButton(me)) {
//                    int index = locationToIndex(me.getPoint());
//                    Object o = model.getElementAt(index);
//                    if (o instanceof Model_Menu) {
//                        Model_Menu menu = (Model_Menu) o;
//                        if (menu.getType() == Model_Menu.MenuType.MENU) {
//                            selectedIndex = index;
//                        }
//                    } else {
//                        selectedIndex = index;
//                    }
//                    repaint();
//                }
//            }
//        });
//
//    }
//    
//    @Override
//    public ListCellRenderer<? super E> getCellRenderer() {
//        return new DefaultListCellRenderer() {
//            @Override
//            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
//                MenuModel data;
//                if (o instanceof MenuModel) {
//                    data = (MenuModel) o;
//                } else {
//                    data = new MenuModel("", o + "", MenuModel.MenuType.EMPTY);
//                }
//                MenuItem item = new MenuItem(data);
//                item.setSelected(selectedIndex == index);
//                return item;
//            }
//
//        };
//    }
}
