package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream original = System.out;
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString().replaceAll("te", "??");
        System.setOut(original);
        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
