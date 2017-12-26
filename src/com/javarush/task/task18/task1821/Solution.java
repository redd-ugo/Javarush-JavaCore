package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file = args[0];
        InputStream inputStream = new FileInputStream(file);
        ArrayList<Character> pre_dictionary = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        while (inputStream.available()>0)
        {
            Character c = (char) inputStream.read();
            if (!map.containsKey(c)) {
                pre_dictionary.add(c);
                map.put(c,1);
            }
            else
            {
                map.put(c,map.get(c)+1);
            }

        }
        inputStream.close();

        char[] dictionary = new char[pre_dictionary.size()];
        for (int i=0; i < pre_dictionary.size(); i++)
        {
            dictionary[i] = pre_dictionary.get(i);
        }

        Arrays.sort(dictionary);

        for (char c: dictionary)
        {
            System.out.println(c+" "+map.get(c));
        }


    }
}
