package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static
    {
        threads.add(new FirstThread());
        threads.add(new SecondThread());
        threads.add(new ThirdThread());
        threads.add(new FourthThread());
        threads.add(new FifthThread());

    }

    public static void main(String[] args) {
        /*for (Thread thread:threads)
        {
            thread.start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threads.get(4).showWarning();*/
    }


    public static class FirstThread extends Thread
    {
        @Override
        public void run() {
            while (true);
        }
    }

    public static class SecondThread extends Thread
    {
           @Override
            public void run()
           {
                try {
                    sleep(5000000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
           }

    }
    public static class ThirdThread extends Thread
    {
        @Override
        public void run() {
            try
            {
                while (true){
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e){}
        }
    }

    public static class FourthThread extends Thread implements Message
    {
        private boolean stop=false;
        @Override
        public void showWarning() {
            this.stop = true;
        }

        @Override
        public void run() {
            while (!this.stop);
        }
    }

    public static class FifthThread extends Thread
    {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            try
            {
                while (!interrupted())
                {
                String string = reader.readLine();
                if (string.equalsIgnoreCase("N")){
                    for (int i=0; i<list.size(); i++){
                        sum+=list.get(i);
                    }
                    System.out.println(sum);
                }
                else{
                    list.add(Integer.parseInt(string));
                }
                }

            }
            catch (IOException e){e.printStackTrace();}
            finally {
                try {reader.close();}
                catch (IOException e){e.printStackTrace();}
                }
        }
    }
}