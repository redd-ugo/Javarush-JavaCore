package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        InputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        props.putAll(properties);
        props.store(outputStream, null);

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        //BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Properties myProperties = new Properties();
        myProperties.load(inputStream);
        properties.clear();
        for (Map.Entry e : myProperties.entrySet()){
            properties.put(e.getKey().toString(), e.getValue().toString());
        }
        inputStream.close();



    }

    public static void main(String[] args) {



    }
}
