package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(args[0]);
        FileWriter writer = new FileWriter(args[1]);
        BufferedReader reader = new BufferedReader(fileReader);

        List<String> list = new ArrayList<>();

        while (reader.ready())
        {
            String line = reader.readLine();
            String[] array  = line.split(" ");
            for (String el:array){
                if (el.length()>6) list.add(el);
            }

        }

        fileReader.close();
        for (int i = 0; i<list.size(); i++)
        {
            String string;
            if (i!=list.size()-1) string = list.get(i)+",";
            else string = list.get(i);
            writer.write(string);
        }
        writer.close();

    }
}
