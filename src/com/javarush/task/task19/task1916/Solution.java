package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine(), file2 = reader.readLine();
        reader.close();

        FileReader fileReader1 = new FileReader(file1);
        FileReader fileReader2 = new FileReader(file2);

        BufferedReader bufferedReader = new BufferedReader(fileReader1);
        BufferedReader aBufferedReader = new BufferedReader(fileReader2);

        List<String> proto = new ArrayList<>();
        List<String> modo = new ArrayList<>();

        while (bufferedReader.ready())
        {
            String line = bufferedReader.readLine();
            proto.add(line);
        }
        fileReader1.close();

        while (aBufferedReader.ready())
        {
            String line = aBufferedReader.readLine();
            modo.add(line);
        }
        fileReader2.close();

        //boolean flag = true;
        int j = 0;
        boolean modoIsEmpty = false;


        for (int i = 0; i < proto.size(); i++ )
        {
            modoIsEmpty = (j>=modo.size());
            if (proto.get(i).equals(modo.get(j)))
            {
                lines.add(new LineItem(Type.SAME, proto.get(i)));
                j++;
          //      flag = true;
            }
            else if (proto.get(i+1).equals(modo.get(j)))
            {
                lines.add(new LineItem(Type.REMOVED, proto.get(i)));
                i++;
                lines.add(new LineItem(Type.SAME, proto.get(i)));
                j++;
            }
            else if (!modoIsEmpty && proto.get(i).equals(modo.get(j+1)))
            {
                lines.add(new LineItem(Type.ADDED, modo.get(j)));
                j++;
                lines.add(new LineItem(Type.SAME, proto.get(i)));
                j++;
            }
            else if (modoIsEmpty) lines.add(new LineItem(Type.REMOVED, proto.get(i)));
        }
        if (!modoIsEmpty) lines.add(new LineItem(Type.ADDED, modo.get(j)));

        /*for (LineItem item:lines)
        {
            System.out.println(item.type.toString()+": "+item.line);
        }*/


    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
