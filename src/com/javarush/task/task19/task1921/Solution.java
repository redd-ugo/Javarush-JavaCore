package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready())
        {
            String line = reader.readLine();
            String[] decomposite = line.split(" ");
            String name=decomposite[0];
            int length = decomposite.length, year, month, day;
            for (int i=1; i<decomposite.length-3;i++) name=name+" "+decomposite[i];
            year = Integer.parseInt(decomposite[length-1]);
            month = Integer.parseInt(decomposite[length-2])-1;
            day = Integer.parseInt(decomposite[length-3]);
            GregorianCalendar date = new GregorianCalendar(year,month,day);
            PEOPLE.add(new Person(name,date.getTime()));
        }
        reader.close();

        /*for (Person person:PEOPLE)
        {
            System.out.println(person.getName()+" "+person.getBirthday());
        }*/


    }
}
