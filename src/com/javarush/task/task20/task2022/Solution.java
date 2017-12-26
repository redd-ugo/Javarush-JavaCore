package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(this.fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        //this.fileName = (String) in.readObject();
        this.stream = new FileOutputStream(this.fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("c:\\123\\1.txt");
        solution.writeObject("This is the first string");
        File saveFile = new File("c:\\123\\2.txt");
        FileInputStream fileInputStreamtput = new FileInputStream(saveFile);
        FileOutputStream outputStream = new FileOutputStream(saveFile);

        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(solution);
        outputStream.close();
        oos.close();
        solution.close();


        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStreamtput);


        Solution second = (Solution) objectInputStream.readObject();
        second.writeObject("Second String, hooray!");
        second.close();






    }
}
