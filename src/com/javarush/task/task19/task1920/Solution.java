package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;


public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        //ArrayList<String> buffer = new ArrayList<>();
        Map<String, Double> map = new TreeMap<>();

        double max = 0;
        while (reader.ready())
        {
            //buffer.add(reader.readLine());
            String el = reader.readLine();
        //}



        //for (String el:buffer)
        //{
            String[] medium = el.split(" ");
            if (map.containsKey(medium[0])) map.put(medium[0],Double.parseDouble(medium[1])+map.get(medium[0]));
            else map.put(medium[0], Double.parseDouble(medium[1]));
            //max = Double.parseDouble(medium[1]); //для начального отсчета
        }
        reader.close();
/*
        for (Map.Entry<String, Double> entry: map.entrySet())
        {
            if (entry.getValue() > max) max = entry.getValue();

        }*/
        max = Collections.max(map.values());

        for (Map.Entry<String, Double> entry: map.entrySet())
        {
            if (entry.getValue() == max) System.out.print(entry.getKey()+" ");
        }



    }
}