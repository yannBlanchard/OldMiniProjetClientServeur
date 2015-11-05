package com.company;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Yann on 05/11/2015.
 */
public class FenetreClient extends JFrame{
    TextField tf;
    TextArea ta;
    public FenetreClient() {
        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setTitle("Tchat");
        //	Fermeture c = new Fermeture();
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.addWindowListener(new Fermeture());
        tf = new TextField(20);
        ta = new TextArea();
        f.add(tf, BorderLayout.SOUTH);
        f.add(ta);
        f.setVisible(true);
    }

    public String getText(){
        return this.ta.getText();
    }
}
