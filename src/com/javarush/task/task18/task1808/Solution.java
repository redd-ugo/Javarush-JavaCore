package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);
        FileOutputStream file3 = new FileOutputStream(fileName3);

        while(fileInputStream.available() > 0){
            if(fileInputStream.available() % 2 == 0){
                byte[] o1 = new byte[fileInputStream.available()/2];
                byte[] o2 = new byte[fileInputStream.available()/2];
                int count1 = fileInputStream.read(o1);
                int count2 = fileInputStream.read(o2);
                file2.write(o1, 0, count1);
                file3.write(o2, 0, count2);
            } else {
                byte[] o1 = new byte[fileInputStream.available()/2 + 1];
                byte[] o2 = new byte[fileInputStream.available()/2];
                int count1 = fileInputStream.read(o1);
                int count2 = fileInputStream.read(o2);
                file2.write(o1, 0, count1);
                file3.write(o2, 0, count2);
            }
        }


        file2.close();
        file3.close();
        fileInputStream.close();

    }
}
