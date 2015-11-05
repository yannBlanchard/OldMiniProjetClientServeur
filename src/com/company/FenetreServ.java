package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Yann on 05/11/2015.
 */
public class FenetreServ {
    FenetreServ() {
        JFrame f = new JFrame();
        f.setSize(300, 500);
        f.setTitle("Serveur");
        //	Fermeture c = new Fermeture();
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //f.addWindowListener(new Fermeture());
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        f.add(panel);
        for(int i =0; i<10;i++) {
            JLabel label = new JLabel("salut");
            panel.add(label);
        }
        f.setVisible(true);
    }
}
