package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream wrapper;


    public AmigoOutputStream(FileOutputStream outputStream) throws FileNotFoundException {
        super(fileName);
        wrapper = outputStream;

    }

    @Override
    public void write(int b) throws IOException {
        wrapper.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        wrapper.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        wrapper.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        wrapper.flush();
        wrapper.write("JavaRush © All rights reserved.".getBytes());
        wrapper.close();
    }

    @Override
    public void flush() throws IOException {
        wrapper.flush();
    }

    @Override
    protected void finalize() throws IOException {
        super.finalize();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
}
