package com.company;

import javax.swing.*;

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main{
    public static void main(String s[]) throws IOException {
        //Creates a new chat box
        ChatBox cb1 = new ChatBox();
        cb1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits the program when it is closed
        cb1.setVisible(true); //makes the box visible

        //Creates a new chat box
        ChatBox cb2 = new ChatBox();
        cb2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits the program when it is closed
        cb2.setVisible(true); //makes the box visible

        //Outputs a text flie that explains the encryption and decryption method
        FileOutputStream fileByteStream = null; // File output stream
        PrintWriter outFS = null;
        fileByteStream = new FileOutputStream("Instructions/operation.txt");
        outFS = new PrintWriter(fileByteStream);
        outFS.println("These two chat boxes work by sharing a static variable between them and then update that variable when a message is sent. To update each of the chat boxes (to check for a new message) press ‘enter’ when the cursor is in text field. The static variable is encrypted before the the message is displayed on the other chat box. Then when the message is displayed, the text is decrypted. This can be seen in action performed method of the ChatBox class. The encryption works by generating a random number and then adding that to the ascii value of each of the characters. The randomly generated number (the key) is a static variable shared between the two chat boxes. The other chat box then subtracts the key value from the ascii value of each of the characters and then prints out the original decrypted message. ");
        outFS.flush();
        fileByteStream.close();

    }
}
