package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_double = reader.readLine(), file_round = reader.readLine();
        reader.close();

        InputStream filereader = new FileInputStream(file_double);
        OutputStreamWriter writer = new FileWriter(file_round);
        String str = "";


        while (filereader.available()>0)
        {
            char c = (char)filereader.read();
            if (c!=' ') str += c;
            else
            {
                double d = Double.parseDouble(str);
                int round = (int)Math.round(d);
                writer.write(round+" ");
                str = "";

            }
        }

        if (!str.equals(""))
        {
            double d = Double.parseDouble(str);
            int round = (int)Math.round(d);
            writer.write(round+" ");
        }

        filereader.close();
        writer.close();



    }
}
