/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.swing.jlabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author CEC-PC3
 */
public class TextboxLabel extends JLabel{
    public TextboxLabel(){
        setOpaque(false);
        setForeground(new Color(255, 255, 255));
        setFont(new Font("Poppins Medium", 1, 14));
    }
}
