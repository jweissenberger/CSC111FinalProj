package com.company;
import java.util.Random;

/**
 * Created by weisja15 on 4/7/2017.
 */
public class EncryptDecrypt {
    private int i;
    int key;
    Random randGen = new Random();

    //encrypts an inputed message given the key
    public String encrypt(String message, int key){
        for (i=0; i<=message.length()-1; i++){
            message = message.substring(0,i) + (char) (message.charAt(i) + key) + message.substring(i+1);
        }
        return message;
    }

    //decrypts a message given then key
    public String decrypt(String message, int key){
        for (i=0; i<=message.length()-1; i++){
            message = message.substring(0,i) + (char) (message.charAt(i) - key) + message.substring(i+1);
        }
        return message;
    }

    //retrieves a random key value
    public int getKey(){
        key = randGen.nextInt(30)+15;
        return key;
    }
}