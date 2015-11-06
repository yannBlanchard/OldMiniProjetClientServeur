package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Yann on 05/11/2015.
 */
public class FenetreClient extends JFrame implements ActionListener{
    TextArea reception;
    TextArea message;
    String mes;
    JButton send;
    String nomClient;
    Boolean firstCommit;
    ProdCons myPc = null;
    public FenetreClient(String nomClient,ProdCons prodCons) {
        this.nomClient = nomClient;
        this.myPc = prodCons;



        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setTitle("Tchat ("+ nomClient + ")" );
        firstCommit = false;

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setLayout(new FlowLayout());

        reception = new TextArea(20,40);
        message = new TextArea(10,40);
        send = new JButton("Envoyer");

        reception.setEditable(false);
        f.add(reception);
        f.add(message);

        f.add(send);


        f.setVisible(true);

        send.addActionListener(this);
    }



    public void actionPerformed(ActionEvent e)
    {

        String label = e.getActionCommand();

        if (label.equals("Envoyer"))
        {
            //On affiche le message dans la zone de reception
            reception.setText(reception.getText() + nomClient + "  :\n" + message.getText() + "\n");
            //On construit le message
            mes = ":D:Bob:"+ nomClient +":" + message.getText();
            myPc.Put(mes);
            //On efface l'ecran
            message.setText(null);
            //On remet le focus sur le champs de saisie
            message.requestFocusInWindow();

        }

    }
}
