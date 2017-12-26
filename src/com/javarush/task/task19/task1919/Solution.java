package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> buffer = new ArrayList<>();
        TreeMap<String, Double> map = new TreeMap<>();

        while (reader.ready())
        {
            buffer.add(reader.readLine());
        }

        reader.close();

        for (String el:buffer)
        {
            String[] medium = el.split(" ");
            if (map.containsKey(medium[0])) map.put(medium[0],Double.parseDouble(medium[1])+map.get(medium[0]));
            else map.put(medium[0], Double.parseDouble(medium[1]));
        }

        //String[] medium = new String[map.size()];

        for (Map.Entry<String, Double> entry: map.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }



    }
}
