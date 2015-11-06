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
