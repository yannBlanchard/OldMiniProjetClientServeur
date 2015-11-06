package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by yablanch on 06/11/2015.
 */
public class General {
    TextArea reception;
    TextArea message;
    class Envoie extends Thread {
        Socket socket;
        Boolean firstCommit;
        String nom;
        public Envoie(Socket s,String nom){
            this.socket = s;
            this.nom = nom;


        }
        public void run(){
            firstCommit = true;
            try {
                DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
                //Demande d'abo
                outToServer.writeBytes(":S:"+ nom + ":" + '\n');
            }
            catch (Exception e){

            }
            while (true){

            }
        }
    }

    class Reception extends Thread {
        Socket socket;
        Boolean firstCommit;
        String nom;
        String modifiedSentence;
        BufferedReader inFromServer;

        public Reception(Socket s) {
            this.socket = s;
        }
        public void run(){
            try {
                inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (Exception e) {}
            while (true) {
                try {
                    modifiedSentence = inFromServer.readLine();
                }
                catch (Exception e){}
            }
        }

    }

    class FenetreClient extends JFrame implements ActionListener {
        /*TextArea reception;
        TextArea message;*/
        String mes;
        JButton send;
        String nomClient;
        Boolean firstCommit;
        public FenetreClient(String nomClient) {
            this.nomClient = nomClient;
            JFrame f = new JFrame();
            f.setSize(500, 500);
            f.setTitle("Tchat");
            firstCommit = true;

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
                reception.setText(reception.getText() + nomClient + "  :\n" + message.getText() + "\n");
                System.out.print(mes);
                //On efface l'ecran
                message.setText(null);
                //On remet le focus sur le champs de saisie
                message.requestFocusInWindow();

                System.out.println(message.getText());
                if(firstCommit == true){
                    mes = ":S:1:" + message.getText();
                }
                else {

                }

                //Envoie envoieToServ = new Envoie(;

                //System.out.println(connec.mote);



            }

        }
    }


}
