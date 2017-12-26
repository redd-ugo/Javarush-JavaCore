package com.javarush.task.task18.task1804;

/*
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int min = 1;
        HashMap<Integer, Integer> byteMap = new HashMap<>();

        while (fileInputStream.available()>0)
        {
            int data = fileInputStream.read();
            if (!byteMap.containsKey(data)) byteMap.put(data,1);
            else byteMap.put(data,byteMap.get(data) + 1);
            min = byteMap.get(data);
        }

        fileInputStream.close();


        for (Map.Entry<Integer,Integer> entry:byteMap.entrySet())
        {
            if (entry.getValue() < min)  min = entry.getValue();
        }

        for (Map.Entry<Integer,Integer> entry:byteMap.entrySet()) {
            if (entry.getValue() == min) System.out.print(entry.getKey() + " ");
        }
    }
}