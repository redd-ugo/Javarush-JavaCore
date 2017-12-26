package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream wrapper;
    @Override
    public void flush() throws IOException {
        wrapper.flush();

    }

    @Override
    public void write(int b) throws IOException {
        this.wrapper.write(b);

    }

    @Override
    public void write(byte[] b) throws IOException {
        this.wrapper.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.wrapper.write(b,off,len);

    }

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) throws FileNotFoundException {
        this.wrapper = amigoOutputStream;
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н"); //sure question
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String confirmation = reader.readLine();
        if (confirmation.equals("Д")) wrapper.close();
        reader.close();

    }
}

