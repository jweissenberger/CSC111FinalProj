package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ChatBox extends JFrame implements ActionListener{

    EncryptDecrypt message = new EncryptDecrypt();
    private JTextField input = new JTextField(20);
    private JTextArea history = new JTextArea(5,20);
    static int key = 0;
    static String encryptedMessage = " ";

    //initializes the layout of the chatbox
    public ChatBox() {
        super("Chat Window");
        setSize(500, 300);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        history.setEditable(false); // so you are not able to edit the history of the chat
        history.setLineWrap(true);
        JScrollPane spane = new JScrollPane(history);
        input.addActionListener(this);
        contentPane.add(input, BorderLayout.NORTH);
        contentPane.add(spane, BorderLayout.CENTER);
    }

    //when a text is typed, it appears in the history in an encrypted form and a decrypted form
    public void actionPerformed(ActionEvent e) {
        history.append(message.decrypt(encryptedMessage, key));// decrypts and displays previous messages
        String text = input.getText();
        encryptedMessage = text;
        history.append(encryptedMessage + "\n");// add newline at end
        input.setText(""); // clear input text box
        key = message.getKey();
        encryptedMessage = message.encrypt(encryptedMessage, key);//encrypts the message

    }

}