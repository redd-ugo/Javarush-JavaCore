package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0, symbol;
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        //BufferedReader reader = new BufferedReader(new FileReader("c:\\123\\test1.txt"));
        char character;
        while (reader.ready())
        {
            symbol = reader.read();
            character = (char) symbol;
            if ((character>='a'&& character<='z')||(character>='A'&& character<='Z')) count++;
        }

        reader.close();
        System.out.println(count);

    }
}
