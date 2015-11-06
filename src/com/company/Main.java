package com.company;

import v1.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;



public class Main {

    public static void main(String[] args) throws Exception{
        String mess;
        theServer server = new theServer();
        FenetreClient client = new FenetreClient();
        //FenetreServ serv = new FenetreServ();
        BufferedReader in;
	// write your code here

        //
        //in = new BufferedReader( new InputStreamReader(System.in));
        //Socket clientSocket = new Socket("127.0.0.1",1234);
        //String messBase = client.getText();

        Socket clientSocket = new Socket("miage18.miage.u-paris10.fr", 6789);


        while (true){

            //mess = client.getText();
            //System.out.println(mess);
        }
    }
}
