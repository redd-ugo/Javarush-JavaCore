package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name = reader.readLine();
        BufferedReader filereader = new BufferedReader(new FileReader(file_name));

        reader.close();
        int id = Integer.parseInt(args[0]);
        String s_int = args[0];

        while (filereader.ready()) {
            String line = filereader.readLine();
            if (line.startsWith(s_int + " ")) System.out.println(line);

        }

        filereader.close();
    }
}
