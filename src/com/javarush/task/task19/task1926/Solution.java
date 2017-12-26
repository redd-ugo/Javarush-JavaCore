package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String aFile = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(aFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready())
        {
            String line = bufferedReader.readLine();
            String result = String.valueOf(new StringBuilder(line).reverse());
            System.out.println(result);
        }

        fileReader.close();

    }
}
