package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1=reader.readLine(), file2=reader.readLine();
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
        /*InputStream reader_f1 = new FileInputStream(file2);
        InputStream reader_f2 = new FileInputStream(file1);*/
        BufferedReader reader_f1 = new BufferedReader(new FileReader(file2));
        BufferedReader reader_f2 = new BufferedReader(new FileReader(file1));
        StringBuilder builder = new StringBuilder();

        while (reader_f1.ready())
        {
            builder.append(reader_f1.readLine());
        }
        reader_f1.close();

        while (reader_f2.ready())
        {
            builder.append(reader_f2.readLine());
        }
        reader_f2.close();

        String stringToFile = builder.toString();

        for (int i=0; i<stringToFile.length();i++)
        {
            writer.append(stringToFile.charAt(i));
        }
        writer.close();



    }
}
