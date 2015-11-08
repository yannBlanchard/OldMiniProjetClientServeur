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
    TextField pseudo;
    String mes;
    JButton send;
    JLabel label;
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
        f.setSize(520, 600);
        f.setTitle("Tchat (" + nomClient + ")");
        firstCommit = false;

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //f.setLayout(new FlowLayout());
        f.setLayout(null);
        //reception = new TextArea(20,40);
       // message = new TextArea(10,40);

        label = new JLabel("Destinataire :");
        pseudo = new TextField();
        reception = new TextArea();
        message = new TextArea();
        send = new JButton("Envoyer");



        //reception.setText("Syntaxe : \n NomDestinataire:Message\n");

        reception.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reception);
        // On positionne les elements
        label.setBounds(1, 1, 99, 20);
        pseudo.setBounds(100, 1, 70, 30);
        reception.setBounds(1, 40, 499, 400);
        message.setBounds(1, 450, 499, 70);
        send.setBounds(200,520,100,25);
        //Ajout des composant au panel

        f.add(label);
        f.add(pseudo);
        f.add(scrollPane);
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

            mes = ":D:"+ nomClient +":"+ pseudo.getText() +":" + message.getText();
            myPcEnvoie.Put(mes);
            //On efface l'ecran
            message.setText(null);
            //On remet le focus sur le champs de saisie
            message.requestFocusInWindow();

        }

    }
}
