package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        if (args == null || args.length < 1)
            throw new RuntimeException();
        SimpleDateFormat inPutDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat outPutDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date date;
        switch (args[0]){
            case ("-c") :
                Person person;
                    date = inPutDateFormat.parse(args[3]);
                if (args[2].equals("ж")) {
                    person = Person.createFemale(args[1], date);
                }
                else {
                    person = Person.createMale(args[1], date);
                }
                allPeople.add(person);
                //Гадкий валидатор не принимает allPeople.size()-1
                for (int id = 0; id < allPeople.size(); id++){
                    if (allPeople.get(id).equals(person))
                        System.out.println(id);
                    }
                break;
            case ("-i") :
                date = allPeople.get(Integer.parseInt(args[1])).getBirthDate();
                String sex = (allPeople.get(Integer.parseInt(args[1])).getSex()==Sex.MALE)? " м ":" ж ";
                System.out.println(
                        allPeople.get(Integer.parseInt(args[1])).getName() +
                                sex + outPutDateFormat.format(date));
                break;
            case ("-u") :
                    date = inPutDateFormat.parse(args[4]);
                if (args[3].equals("ж"))
                    allPeople.set(Integer.parseInt(args[1]),
                            Person.createFemale(args[2], date));
                else
                    allPeople.set(Integer.parseInt(args[1]),
                            Person.createMale(args[2], date));
                break;
            case ("-d") :
                Person personNull = Person.createMale(null, null);
                personNull.setSex(null);
                allPeople.set(Integer.parseInt(args[1]), personNull);
                break;
        }
    }
}
