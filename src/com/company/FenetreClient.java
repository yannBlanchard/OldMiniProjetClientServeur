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
    ProdCons myPcEnvoie = null;
    ProdCons myPcRecept = null;

    public void waitMessage(){
        String messReception;

        messReception = (String) myPcRecept.Get();
        System.out.println("Recu :" + messReception);
        reception.setText(reception.getText() + messReception);
    }

    public FenetreClient(String nomClient,ProdCons prodConsEnv,ProdCons prodConsRec) {
        this.nomClient = nomClient;
        this.myPcEnvoie = prodConsEnv;
        this.myPcRecept = prodConsRec;


        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setTitle("Tchat (" + nomClient + ")");
        firstCommit = false;

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setLayout(new FlowLayout());

        reception = new TextArea(20,40);
        message = new TextArea(10,40);
        send = new JButton("Envoyer");

        reception.setText("Syntaxe : \n NomDestinataire:Message\n");

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
            mes = ":D:" +nomClient +":" + message.getText();
            myPcEnvoie.Put(mes);
            //On efface l'ecran
            message.setText(null);
            //On remet le focus sur le champs de saisie
            message.requestFocusInWindow();

        }

    }
}
