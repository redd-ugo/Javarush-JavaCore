package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        //add your code here - добавьте код тут
        t1.run();
        t1.join();
        t2.run();
        t2.join();

        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread{
        private String result;

        public void printResult() {
            System.out.println(this.result);
        }

        @Override
        public void run() {
            StringBuilder builder = new StringBuilder();
            try{
                for (int i = 0; i < 3; i++)
                {
                    builder.append(reader.readLine());
                    builder.append(" ");
                }
            }
            catch (IOException e){e.printStackTrace();}
            this.result = builder.toString();
        }
    }

    //add your code here - добавьте код тут
}
