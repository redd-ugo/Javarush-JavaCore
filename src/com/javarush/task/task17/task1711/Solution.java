package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        SimpleDateFormat formatDateIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat formatDateOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int id = 0;


            switch (args[0])
            {
                case "-c":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 3) {
                        if (args[i + 1].equals("м"))
                            allPeople.add(Person.createMale(args[i], formatDateIn.parse(args[i + 2])));
                        else allPeople.add(Person.createFemale(args[i], formatDateIn.parse(args[i + 2])));
                        System.out.println(allPeople.size() - 1);
                        }
                    }
                    break;
                case "-u":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 4) {
                            id = Integer.parseInt(args[i]);
                            allPeople.get(id).setName(args[i + 1]);
                            if (args[i + 2].equals("м")) allPeople.get(id).setSex(Sex.MALE);
                            else allPeople.get(id).setSex(Sex.FEMALE);
                            allPeople.get(id).setBirthDay(formatDateIn.parse(args[i + 3]));
                        }
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++)
                        {
                        id = Integer.parseInt(args[i]);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDay(null);
                        }
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i<args.length; i++) {
                            id = Integer.parseInt(args[i]);
                            String sex = (allPeople.get(id).getSex() == Sex.FEMALE) ? "ж" : "м";
                            System.out.println(allPeople.get(id).getName() + " " + sex + " " + formatDateOut.format(allPeople.get(id).getBirthDay()));
                        }
                    }
                    break;

            }

    }
}
