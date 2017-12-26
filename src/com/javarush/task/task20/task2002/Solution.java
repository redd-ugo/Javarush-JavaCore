package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = /*createTempFile*/new File("C:\\123\\save.txt");
            File second_file_name = /*createTempFile*/new File("C:\\123\\save_2.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            OutputStream outputStream2 = new FileOutputStream(second_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            //List<User> users = new ArrayList<>();
            User lamer = new User();
            User profi = new User();
            User blanco = new User();
            lamer.setBirthDate(new Date());
            lamer.setCountry(User.Country.UKRAINE);
            lamer.setFirstName("Labukh");
            lamer.setLastName("Pechko");
            lamer.setMale(true);

            profi.setFirstName("Vasya");
            profi.setCountry(User.Country.RUSSIA);

            blanco.setCountry(User.Country.OTHER);

            javaRush.users.add(lamer);
            javaRush.users.add(profi);
            javaRush.users.add(blanco);

            javaRush.save(outputStream);
            outputStream.flush();
            /*System.out.println("Continue? y/n");
            while (true)
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                if (reader.readLine().equalsIgnoreCase("y")) break;

            }*/

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println("Hashes: " + loadedObject.hashCode() + " "+javaRush.hashCode()+" " + (loadedObject.equals(javaRush)));

            loadedObject.save(outputStream2);
            outputStream2.flush();
            outputStream.close();
            outputStream2.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss:SS");
            printWriter.println("START_DATA");
            if (this.users.isEmpty()) printWriter.println("empty");
            else {
                printWriter.println("full");
                for (User user:this.users)
                {
                    printWriter.println("USER_DATA_START");
                    String bDay = (user.getBirthDate()==null) ? "no BD":"BD";
                    printWriter.println(bDay);
                    System.out.println(bDay);
                    if (bDay.equals("BD")) printWriter.println(sdf.format(user.getBirthDate()));

                    String fName = (user.getFirstName() == null) ? "no FN": "FN";
                    printWriter.println(fName);
                    if (fName.equals("FN")) printWriter.println(user.getFirstName());

                    String sName = (user.getLastName() == null) ? "no LN": "LN";
                    printWriter.println(sName);
                    if (sName.equals("LN")) printWriter.println(user.getLastName());

                    String country = (user.getCountry().getDisplayedName() == null) ? "no CN" : "CN";
                    printWriter.println(country);
                    if (country.equals("CN")) printWriter.println(user.getCountry().getDisplayedName());


                    printWriter.println("SEX");
                    printWriter.println(user.isMale());
                    printWriter.println("USER_DATA_END");
                    printWriter.flush();
                }
            }
            printWriter.println("END_DATA");
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss:SS");
            if (bufferedReader.ready() && bufferedReader.readLine().equals("START_DATA"))
            {
                //List <User> list = new ArrayList<>();

                while (bufferedReader.ready())
                {
                    String data_one = bufferedReader.readLine();
                    if (data_one.equals("END_DATA")) break;
                    if (data_one.equals("empty")) continue;
                    if (data_one.equals("USER_DATA_START"))
                    {
                        User user = new User();
                        boolean flag = true;
                        while (flag)
                        {
                            String data = bufferedReader.readLine();
                            switch (data) {
                                case "BD" :
                                {
                                    user.setBirthDate(sdf.parse(bufferedReader.readLine()));
                                    break;
                                }
                                case "FN" :
                                    {user.setFirstName(bufferedReader.readLine());break;}
                        case "LN" :
                            {user.setLastName(bufferedReader.readLine());break;}
                        case "CN" :
                            {
                            String cName = bufferedReader.readLine();
                            User.Country country;
                            switch (cName)
                                {
                                case "Russia": {country = User.Country.RUSSIA; break;}
                                case "Ukraine" : {country = User.Country.UKRAINE; break;}
                                default: {country = User.Country.OTHER; break;}
                                }
                            user.setCountry(country);break;
                            }
                        case "SEX" :
                            {
                                //System.out.print("User#"+count+" is set sex.");
                                String sSex = bufferedReader.readLine();
                                //System.out.println(" Is he male? "+ sSex);
                                boolean sex = sSex.equals("true");
                                if (sex) user.setMale(sex);
                                break;
                            }
                        case "USER_DATA_END" : {flag = false; break;}

                    }
                }
                this.users.add(user);
                    }
                }


            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
