package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List <String> lines = new ArrayList<>();
        String tag = args[0], closeTag = "</"+tag+">", openTag = "<"+tag;
        StringBuilder line = new StringBuilder();

        while (bufferedReader.ready())
        {
            line.append(bufferedReader.readLine());

        }
        bufferedReader.close();
        String result = line.toString();
        result.replaceAll("\\n", "");
//        int depth = 0;

        int aTagLength = openTag.length();

        //if (i>0) depth++;


        while (result.contains(openTag))
        {
            result = result.substring(result.indexOf(openTag));
            String tmp = returnTag(result, tag);
            lines.add(tmp.trim());
            result = result.substring(aTagLength);
            /*int nextI = result.indexOf(openTag, (i+aTagLength));
            if (nextI > j || nextI == -1) {
                lines.add(result.substring(i,j+closeTag.length()));
                depth--;
                i = nextI;
                if (i>0) j = result.indexOf(closeTag,j+closeTag.length());
            }*/

        }

        for (String el:lines)
        {
            System.out.println(el);
        }

    }

    public static String returnTag(String line, String tag)
    {
        String closeTag = "</"+tag+">", openTag = "<"+tag;
        int i = line.indexOf(openTag);
        int aTagLength = openTag.length();
        int beginTag = line.indexOf(openTag);
        int j = line.indexOf(closeTag)+aTagLength+2;

        while (line.substring(beginTag+aTagLength,j).contains(openTag))
        {
            beginTag += line.substring(beginTag + aTagLength, j).indexOf((openTag)) + aTagLength;
            j += line.substring(j).indexOf((closeTag)) + aTagLength + 2;
        }


        return line.substring(i,j);
    }

}
