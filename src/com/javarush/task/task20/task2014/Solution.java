package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
        File file = new File("c:\\123\\save.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Solution savedObject = new Solution(11);

        outputStream.writeObject(savedObject);
        outputStream.flush();
        outputStream.close();

        Solution anotherObject = new Solution(15);

        anotherObject = (Solution) inputStream.readObject();

        System.out.println(anotherObject);


    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
