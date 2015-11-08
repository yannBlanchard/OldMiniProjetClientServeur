package com.company;

import java.io.DataOutputStream;
import java.util.logging.SocketHandler;
import java.net.*;

/**
 * Created by yablanch on 06/11/2015.
 */
public class Envoie extends Thread {
        Socket socket;
        Boolean firstCommit;
        String nom;
        ProdCons myPc = null;
        String messageToServer;
        public Envoie(Socket s,String nom,ProdCons prodCons){
            this.socket = s;
            this.nom = nom;
            this.myPc = prodCons;
        }
        public void run(){
            //FenetreClient client = new FenetreClient(nom);
            firstCommit = true;
            try {
                DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
                //Demande d'abo
                outToServer.writeBytes(":S:1:"+ nom + ":" + '\n');

                while (true){
                    messageToServer = (String) myPc.Get();

                    outToServer.writeBytes(messageToServer + ":" + '\n');
                }
            }
            catch (Exception e){

            }
        }
}
