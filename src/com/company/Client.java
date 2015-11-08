package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by yablanch on 06/11/2015.
 */
public class Client extends Thread {
    String nom;
    String mess;
    public Client(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void run(){

        ProdCons pcEnvoie = new ProdCons(512);
        ProdCons pcRecept = new ProdCons(512);
        FenetreClient client = new FenetreClient(nom,pcEnvoie,pcRecept);
        //BufferedReader in;

        try {
            Socket clientSocket = new Socket("127.0.0.1", 14586);
            Envoie env = new Envoie(clientSocket,nom,pcEnvoie);
            Reception recept = new Reception(clientSocket,pcRecept);


            recept.start();
            env.start();
        }
        catch (Exception e){

        }

        while (true){
            System.out.println("ok");
            client.waitMessage();

        }
    }

}
