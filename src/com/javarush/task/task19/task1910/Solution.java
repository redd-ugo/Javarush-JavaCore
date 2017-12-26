package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name_of_first_file = reader.readLine();
        String second_file_name = reader.readLine();
        reader.close();

        BufferedReader file_reader = new BufferedReader(new FileReader(name_of_first_file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(second_file_name));

        while (file_reader.ready())
        {
            String line = file_reader.readLine();
            writer.write(line.replaceAll("[^\\w\\dа-яА-ЯёЁ ]",""));
        }

        writer.close();
        file_reader.close();

    }
}
