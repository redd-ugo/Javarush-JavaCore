package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        while (!"exit".equals(input = reader.readLine())){
            new ReadThread(input).start();

        }
        reader.close();


    }

    public static class ReadThread extends Thread {
        private String fileName;

        @Override
        public void run() {
            Map <Integer,Integer> map = new HashMap<>();
            try {
                InputStream file_reader = new FileInputStream(fileName);

                while (file_reader.available()>0)
                {
                    int a = file_reader.read();
                    if (map.containsKey(a)) map.put(a,map.get(a)+1);
                    else map.put(a,1);
                }

                file_reader.close();

            }
            catch (IOException e){e.printStackTrace();}
            int max = 1;
            int value =0;
            for (Map.Entry<Integer,Integer> pair : map.entrySet())
            {
                if (pair.getValue()>max)
                {
                    max = pair.getValue();
                    value = pair.getKey();}
            }

            synchronized (resultMap){resultMap.put(fileName, value);}

        }

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
