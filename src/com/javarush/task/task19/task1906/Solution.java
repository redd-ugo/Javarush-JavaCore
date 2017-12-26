package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first_file = reader.readLine();
        String second_file = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(first_file);
        FileWriter writer = new FileWriter(second_file);

        int count = 0;

        while (fileReader.ready())
        {
            int temp = fileReader.read();
            count++;
            if (count%2==0) writer.write(temp);

        }

        fileReader.close();
        writer.close();


    }
}
