package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        int count_space = 0, count_char = 0, symbol;
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        char character;

        while (reader.ready())
        {
            symbol = reader.read();
            character = (char)symbol;
            count_char++;
            if (character == ' ') count_space++;
        }

        double percentage = (((double)count_space/count_char)*100);
        reader.close();

        System.out.printf("%.2f", percentage);

    }
}
