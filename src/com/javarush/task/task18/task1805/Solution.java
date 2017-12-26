package com.javarush.task.task18.task1805;

import java.io.FileInputStream;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        HashSet<Integer> byteSet = new HashSet<>();

        while (fileInputStream.available()>0)
        {
            int data = fileInputStream.read();
            if (!byteSet.contains(data)) byteSet.add(data);
        }

        fileInputStream.close();
        int[] array = new int[byteSet.size()];
        int count = 0;
        for (Integer element:byteSet)
        {
            array[count] = element;
            count++;
        }
        Arrays.sort(array);

        for (Integer element:array)
        {
            System.out.print(element+" ");
        }


    }
}
