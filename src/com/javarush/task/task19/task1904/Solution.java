package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {

        String file_path = "C:\\123\\1.txt";
        Scanner scanner = new Scanner(new File(file_path));
        PersonScanner personScanner= new PersonScannerAdapter(scanner);

        System.out.println(personScanner.read().toString());
        System.out.println(personScanner.read().toString());
        System.out.println(personScanner.read().toString());

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private final Scanner fileScanner;


        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String firstName, middleName, lastName, line;
            int year=0, month=0, day=0;
            line = fileScanner.nextLine();

            String[] array = line.split("\\s");
            //if (array.length >=6) {
            //System.out.println(line + " array: " + array);
            firstName = array[1];
            middleName = array[2];
            lastName = array[0];
            day = Integer.parseInt(array[3]);
            month = Integer.parseInt(array[4])-1;
            year = Integer.parseInt(array[5]);
            // }

            Date birthday = (new GregorianCalendar(year, month,day)).getTime();
            Person person = new Person(firstName, middleName, lastName, birthday);

            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
