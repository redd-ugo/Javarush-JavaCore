package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
CrUD — Create, Update, Delete

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name — имя, String
sex — пол, «м» или «ж», одна буква
bd — дата рождения в следующем формате 15/04/1990
-c — добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u — обновляет данные человека с данным id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
id соответствует индексу в списке

Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatDateIn = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
        SimpleDateFormat formatDateOut = new SimpleDateFormat("dd-MMM-yyyy" , Locale.ENGLISH);
        int id;

        switch (args[0])//start here - начни тут
        {
            case "-c":
                if (args[2].equals("м")) allPeople.add(Person.createMale(args[1], formatDateIn.parse(args[3])));
                else allPeople.add(Person.createFemale(args[1],formatDateIn.parse(args[3])));
                System.out.println(allPeople.size()-1);
                break;
            case "-u":
                id=Integer.parseInt(args[1]);
                allPeople.get(id).setName(args[2]);
                if (args[3].equals("м")) allPeople.get(id).setSex(Sex.MALE);
                else allPeople.get(id).setSex(Sex.FEMALE);
                allPeople.get(id).setBirthDay(formatDateIn.parse(args[4]));
                break;
            case "-d":
                id=Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
                break;
            case "-i":
                id=Integer.parseInt(args[1]);
                String sex = (allPeople.get(id).getSex()==Sex.FEMALE) ? "ж" : "м";
                System.out.println(allPeople.get(id).getName()+" "+sex+" "+formatDateOut.format(allPeople.get(id).getBirthDay()));
                break;
        }
    }
}
