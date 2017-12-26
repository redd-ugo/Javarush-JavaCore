package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        if(args.length < 3) return;
        InputStream inputStream = new FileInputStream(args[1]);
        OutputStream outputStream = new FileOutputStream(args[2]);

        switch (args[0]){
            case "-d" : {
                while (inputStream.available() > 0) {

                    outputStream.write(~(inputStream.read() & 0xff) + 1);

                }
                break;
            }
            case "-e" : {
                while (inputStream.available() > 0) {

                    outputStream.write(~(inputStream.read() - 1) & 0xff);

                }
                break;
            }

        }
        inputStream.close();
        outputStream.close();

        //encrypt("c:\\123\\test1.txt", "c:\\123\\encry.txt");
        //decrypt("c:\\123\\encry.txt","c:\\123\\decry.txt");

    }

   /* private static void encrypt(String fileName, String fileOutputName) throws IOException{
        InputStream inputStream = new FileInputStream(fileName);
        OutputStream outputStream = new FileOutputStream(fileOutputName);


        while (inputStream.available()>0)
        {

            outputStream.write(~inputStream.read() & 0xff);

        }
        inputStream.close();
        outputStream.close();


    }

    private static void decrypt(String fileName, String fileOutputName) throws IOException {
        InputStream inputStream = new FileInputStream(fileName);
        OutputStream outputStream = new FileOutputStream(fileOutputName);

        while (inputStream.available()>0)
        {

            outputStream.write(~inputStream.read() & 0xff);

        }

        inputStream.close();
        outputStream.close();


    }*/

}
