package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int max = 0;
        HashMap<Integer, Integer> byteMap = new HashMap<>();

        while (fileInputStream.available()>0)
        {
            int data = fileInputStream.read();
            if (!byteMap.containsKey(data)) byteMap.put(data,1);
            else {
                int number = byteMap.get(data) + 1;
                max = (number>max) ? number:max;
                byteMap.put(data,number);
            }
        }

        fileInputStream.close();
        for (Map.Entry<Integer,Integer> entry:byteMap.entrySet())
        {
            if (entry.getValue() == max) System.out.print(entry.getKey()+" ");
        }

    }
}
