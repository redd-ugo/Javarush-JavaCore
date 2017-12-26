package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine(), file2=reader.readLine(), file3=reader.readLine();
        reader.close();

        OutputStream writer = new FileOutputStream(file1);
        InputStream reader_f1 = new FileInputStream(file2);
        InputStream reader_f2 = new FileInputStream(file3);



        while (reader_f1.available()>0)
        {
            writer.write(reader_f1.read());
        }

        reader_f1.close();
        writer.flush();


        while (reader_f2.available()>0)
        {
            writer.write(reader_f2.read());
        }

        reader_f2.close();
        writer.flush();
        writer.close();


    }
}
