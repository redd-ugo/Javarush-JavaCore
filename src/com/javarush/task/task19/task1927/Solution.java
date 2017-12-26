package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);

        testString.printSomething();

        String aString = byteArrayOutputStream.toString();

        String[] array = aString.split("\n");
//        byte[] array = byteArrayOutputStream.toByteArray();
        System.setOut(consoleStream);
//        int count=0;

        for (int i = 0; i<array.length; i++)
        {
//            int num = array[i];
//            char ch = (char)num;
//            System.out.print(ch);
            System.out.println(array[i]);
//            if (array[i]==10) count++;
            if (i%2==1) {System.out.println("JavaRush - курсы Java онлайн");
//            count =0;
            }
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
