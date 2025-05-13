package com.voting.swing.combobox;

import javax.swing.JComboBox;
public class MainComboBox<E> extends JComboBox<E>{
   
    public MainComboBox(){
       setUI(new ComboBoxUI());
   }
    
}
