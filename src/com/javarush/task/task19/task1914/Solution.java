package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream original = System.out;
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String result = outputStream.toString(), equal ="";
        String[] solution = result.split("\\s");

        int a = Integer.parseInt(solution[0]), b = Integer.parseInt(solution[2]);

        switch (solution[1]) {
            case "+" : {equal = String.valueOf(a+b); break;}
            case "-" : {equal = String.valueOf(a-b); break;}
            case "*" : {equal = String.valueOf(a*b); break;}


        }

        System.setOut(original);
        System.out.print(result+equal);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

