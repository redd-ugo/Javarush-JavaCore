package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean run = true;
        //ArrayList<FileInputStream> inputStreams = new ArrayList<>();
        while (run) {
            String fileName = reader.readLine();

            FileInputStream inputStreams = (new FileInputStream(fileName));

            if (inputStreams.available() < 1000) {
                reader.close();
                inputStreams.close();
                run = !run;
                throw new DownloadException();}
            inputStreams.close();


        }
    }

    public static class DownloadException extends Exception {

    }
}
