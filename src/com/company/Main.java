package com.company;
import v1.*;


import sun.management.snmp.jvminstr.JvmRTBootClassPathEntryImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;



public class Main {

    public static void main(String[] args) throws Exception{
        theServer server = new theServer();
        server.start();
        Client clt1 = new Client("Toto");
        Client clt2 = new Client("Bob");

        clt1.start();
        clt2.start();
    }
}
