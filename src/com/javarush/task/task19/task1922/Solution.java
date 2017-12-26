package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfFile = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(nameOfFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready())
        {
            String aString = bufferedReader.readLine();
            String[] array = aString.split(" ");
            List<String> list = new ArrayList<>();

            for (String el:array)
            {
                if (words.contains(el) && !list.contains(el)) list.add(el);
            }

            if (list.size()==2) System.out.println(aString);
        }

        bufferedReader.close();
        fileReader.close();

    }
}
