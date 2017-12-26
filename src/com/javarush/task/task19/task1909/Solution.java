package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
            writer.write(line.replace('.','!'));
        }

        writer.close();
        file_reader.close();

    }
}
