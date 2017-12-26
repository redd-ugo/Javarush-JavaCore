package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int coma = (int) ',';
        int comaCount = 0;
        while (fileInputStream.available()>0)
        {
            if (fileInputStream.read() == coma) comaCount++;
        }
        fileInputStream.close();
        System.out.println(comaCount);

    }
}
