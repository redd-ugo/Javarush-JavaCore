package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name_of_first_file = reader.readLine();
        String second_file_name = reader.readLine();
        reader.close();

        BufferedReader file_reader = new BufferedReader(new FileReader(name_of_first_file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(second_file_name));

        while (file_reader.ready())
        {
            String line = file_reader.readLine();
            String[] array = line.split("\\s");

            for (String el: array)
            {

                if (el.matches("-?\\d+")) writer.write(el+" ");
            }
        }
        file_reader.close();
        writer.close();

    }
}
