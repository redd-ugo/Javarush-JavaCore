package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

        byte[] buffer = new byte[fileInputStream.available()];
        byte[] reverse = new byte[fileInputStream.available()];

        int length = fileInputStream.read(buffer);
        //System.out.println(buffer);
        for (int i = 0; i < buffer.length; i++)
        {
            reverse[reverse.length-i-1] = buffer[i];
        }
        //
        fileOutputStream.write(reverse,0,length);

        fileInputStream.close();
        fileOutputStream.close();

    }
}
