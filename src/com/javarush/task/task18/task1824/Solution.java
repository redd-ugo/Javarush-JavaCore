package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name = null;

        try {
            while (true) {
                    file_name = reader.readLine();

                    InputStream file;
                    file = new FileInputStream(file_name);
                    file.close();
                }}
                catch (FileNotFoundException e)
                {
                    System.out.println(file_name);
                        reader.close();



            }



    }
}
