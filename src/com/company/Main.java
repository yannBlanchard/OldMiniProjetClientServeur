package com.company;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Fermeture extends WindowAdapter {
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}



public class Main {

    public static void main(String[] args) {
	// write your code here

        Frame f = new Frame();
        f.setSize(500,500);
        f.setTitle("Tchat");
        //	Fermeture c = new Fermeture();
        f.setLayout(new BorderLayout());
        f.addWindowListener(new Fermeture());
        TextField tf = new TextField(20);
        TextArea ta=new TextArea();
        f.add(tf,BorderLayout.SOUTH);
        f.add(ta);
        f.setVisible(true);
        while (true){

        }
    }
}
