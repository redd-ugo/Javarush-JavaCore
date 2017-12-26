package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0], file2 = args[1];
        FileReader fileReader = new FileReader(file1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileWriter writer = new FileWriter(file2);

        while (bufferedReader.ready())
        {
            String line = bufferedReader.readLine();
            String[] array = line.split(" ");

            for (String el:array)
            {
                if (el.matches("^.*\\d+.*$")) writer.write(el+" ");
            }
        }

        bufferedReader.close();
        writer.close();


    }
}
