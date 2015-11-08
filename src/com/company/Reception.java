package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.security.spec.ECField;

/**
 * Created by Yann on 05/11/2015.
 */
public class Reception extends Thread {
    Socket socket;
    Boolean firstCommit;
    String nom;
    String messageRecu;
    BufferedReader inFromServer;

    ProdCons myPcRecept = null;

    public Reception(Socket s,ProdCons pc) {
        this.socket = s;
        this.myPcRecept = pc;
    }
    public void run(){
        try {
            inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {}
        while (true) {
            try {
                System.out.println("Attente de message");
                messageRecu = inFromServer.readLine();
                System.out.println("Message recu : " + messageRecu);
                myPcRecept.Put(messageRecu + "\n");
            }
            catch (Exception e){}
        }
    }

}
