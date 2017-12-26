package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        PrintStream original = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name = reader.readLine();
        FileOutputStream writer = new FileOutputStream(file_name);
        reader.close();

        testString.printSomething();
        String result = outputStream.toString();

        System.setOut(original);
        writer.write(outputStream.toByteArray());
        System.out.println(result);
        writer.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

