package com.javarush.task.task20.task2012;

import java.io.*;

/* 
OutputToConsole
*/
public class Solution {
    public static String greeting = "Hello world";

    /**
     * OutputToConsole is the inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for the displaying [greeting] variable to the console.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int counter;

        /**
         * @param out A stream for an externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(this.counter);
        }

        /**
         * @param in A stream for a de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.counter = in.readInt();
        }

        /**
         * Class constructor specifying fake private field [i].
         */
        public OutputToConsole(int counter) {
            this.counter = counter;
        }

        /**
         * Prints greeting message to console counter times.
         */
        public  void printMessage() {
            for (int i = 0; i < counter; i++) {
                System.out.println(greeting);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

       /* OutputToConsole toConsole = new OutputToConsole(2);
        FileOutputStream file = new FileOutputStream("c:\\123\\save.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(file);


        toConsole.writeExternal(outputStream);

        outputStream.close();
        file.close();


        FileInputStream inputStream = new FileInputStream("c:\\123\\save.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Object object = objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();


        OutputToConsole newConsole = (OutputToConsole)object;
        //toConsole.printMessage();
        newConsole.printMessage();*/


    }
}
