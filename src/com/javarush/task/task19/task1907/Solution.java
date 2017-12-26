package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name_of_file = reader.readLine();
        String world = "world";
        BufferedReader fileReader = new BufferedReader(new FileReader(name_of_file));
        int count = 0;

        while (fileReader.ready()){
            String line = fileReader.readLine();
            String[] array = line.split("[\\W]+");

            for (String el:array)
            {
                if (el.equals(world)) count++;
            }

        }
        fileReader.close();
        System.out.println(count);

    }
}
