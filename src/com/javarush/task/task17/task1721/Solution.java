package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] file = new String[2];

            file[0] = reader.readLine();
            file[1] = reader.readLine();
            reader.close();

        for (int i = 0; i < file.length; i++) {

                BufferedReader fileReader = new BufferedReader(new FileReader(file[i]));
                while (fileReader.ready()) {
                    if (i == 0) allLines.add(fileReader.readLine());
                    else forRemoveLines.add(fileReader.readLine());
                }
                fileReader.close();

        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }


    }


    public void joinData () throws CorruptedDataException {
       /* boolean containsAnyLine = false;
        for (String element:forRemoveLines)
        {
            containsAnyLine = containsAnyLine || allLines.contains(element);
        }

        if (!containsAnyLine) {
            allLines.clear();
            throw new CorruptedDataException();
        }

        for (String element:forRemoveLines)
        {
            if (allLines.contains(element)) allLines.remove(element);
        }*/

        if (!allLines.containsAll(forRemoveLines)) {allLines.clear(); throw new CorruptedDataException();}
        else allLines.removeAll(forRemoveLines);

    }
}

