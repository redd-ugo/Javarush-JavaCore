package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static
    {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String aFile = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(aFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<>();

        while (bufferedReader.ready())
        {
            String line = bufferedReader.readLine();
            list.add(line);
        }

        //bufferedReader.close();
        fileReader.close();

        for (String line:list)
        {
            String[] array = line.split(" ");

            for (String  el: array){
                if (el.matches("^\\d+$"))
                {
                    //try {
                    int a = Integer.parseInt(el);
                    if (map.containsKey(a)) System.out.print(map.get(a)+" ");
                    else System.out.print(a + " ");
                    //}
                    //catch (NumberFormatException e) {System.out.print(el+" ");}
                }
                else System.out.print(el+" ");
            }
            System.out.println();
        }

    }
}
