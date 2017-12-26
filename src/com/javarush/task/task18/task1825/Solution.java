package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> parts_list = new ArrayList<>();
        int count=0;
        String file_result, file_name=null;


        //Прочитаем с консоли имена файлов-частей
        while (!"end".equals(file_name = reader.readLine()))
        {
            parts_list.add(file_name);
        }
        reader.close();

        //Сделаем смелое предположение, что количество файлов равно N последней части

        count = parts_list.size();

        file_result =parts_list.get(0).substring(0,parts_list.get(0).lastIndexOf(".part"));

        OutputStream file = new FileOutputStream(file_result);

        for (int i = 1; i<=count;i++)
        {
            InputStream read_file = new FileInputStream(file_result + ".part" + i);
            int buff_size = read_file.available();
            byte[] buffer = new byte[buff_size];
            while (read_file.available()>0)
            {
                int k = read_file.read(buffer);
                file.write(buffer, 0,k);

            }
            read_file.close();
        }

        file.close();




    }
}
