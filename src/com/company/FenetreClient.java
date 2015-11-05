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
    JButton send;
    public FenetreClient() {
        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setTitle("Tchat");


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

    /*public String getText(){
        return this.ta.getText();
    }
    public void update(){
        tf.setVisible(true);
    }*/

    public void actionPerformed(ActionEvent e)
    {

        String label = e.getActionCommand();

        if (label.equals("Envoyer"))
        {
            //envoyer();
            System.out.println(message.getText());
            reception.setText(reception.getText()+"Yann"+"  :\n"+message.getText()+"\n");
            message.setText(null);
            message.requestFocusInWindow();
            //System.out.println(connec.mote);



        }

    }
}
