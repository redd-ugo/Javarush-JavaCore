package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        }
        catch (IOException e){e.printStackTrace();}

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface
    {
        private BufferedReader fileReaders;
        private String fileContent;
        private File file;
        StringBuffer stringBuffer = new StringBuffer();

        @Override
        public void setFileName(String fullFileName) {
            try {
                this.fileReaders = new BufferedReader(new FileReader(fullFileName)); //принимаем параметр пути файла. Организуем его чтение с помощью FileReader
            }
            catch (FileNotFoundException e) {e.printStackTrace();}
        }

        @Override
        public String getFileContent() {

            return this.stringBuffer.toString();    //возвращаем содержимое файла одной строкой через пробелы
        }

        @Override
        public void run() {
             //stringBuffer будет собирать строки из файла, чтобы получилась одна строка
            try{
                //BufferedReader fileReader = new BufferedReader(this.fileReaders);
                while (fileReaders.ready())      //организуем цикл чтения из файла, пока не кончатся строки в нем
                {
                    String line = fileReaders.readLine();    //считываем строку из файла
                    stringBuffer.append(line);
                    stringBuffer.append(" ");
                }
            }
            catch (IOException e){e.printStackTrace();}
            try {
                fileReaders.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
