package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.*;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    private static SimpleDateFormat inPutDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static SimpleDateFormat outPutDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) {
        try {
            switch (args[0]) {
                //случай с (-с) - добавляет всех людей с заданными параметрами в конец allPeople,
                // выводит id (index) на экран в соответствующем порядке
                case "-c":
                    synchronized (allPeople) {
                        //локальные промежуточные переменные для заполнения новых Person
                        String[] newPerson = new String[3];
                        int count = 0;
                        for (String parameter : args) {
                            if (!parameter.equals(args[0])) {
                                //идет заполнение масива данными name1 sex1 bd1
                                newPerson[count] = parameter;
                                //проверка, достаточно ли данных для выполнения
                                // алгоритма(заполнение нового элемента в allPeople)
                                if (count == 2) {
                                    //масив newPerson[] полон, приступаем к созданию нового Person
                                    Person person;
                                    Date date = inPutDateFormat.parse(newPerson[2]);
                                    if (newPerson[1].equals("м"))
                                        person = Person.createMale(newPerson[0], date);
                                    else
                                        person = Person.createFemale(newPerson[0], date);
                                    // добавляем в конец allPeople нового Person
                                    allPeople.add(person);
                                    System.out.println(allPeople.indexOf(person));

                                    //сброс счетчика для набора данных для нового элемента в allPeople
                                    count -= 3;
                                }
                                count++;
                            }
                        }
                    }
                    break;

                //случай с (-u) обновляет соответствующие данные людей с заданными id
                case "-u":
                    synchronized (allPeople) {
                        //локальные промежуточные переменные для заполнения новых Person
                        String[] newPerson = new String[4];
                        int count = 0;
                        for (String parameter : args) {
                            //всегда исключаем 0-й параметр (-u)
                            if (!parameter.equals(args[0])) {
                                //идет заполнение масива данными id1 name1 sex1 bd1
                                newPerson[count] = parameter;
                                //проверка, достаточно ли данных для выполнения
                                // алгоритма(замена на новый элемент в allPeople)
                                if (count == 3) {
                                    //масив newPerson[] полон, приступаем к созданию нового Person
                                    Person person;
                                    Date date = inPutDateFormat.parse(newPerson[3]);
                                    if (newPerson[2].equals("м"))
                                        person = Person.createMale(newPerson[1], date);
                                    else
                                        person = Person.createFemale(newPerson[1], date);
                                    // и заменяем на него указаный в id элемент из allPeople
                                    allPeople.set(Integer.parseInt(newPerson[0]), person);
                                    //сброс счетчика для набора данных для нового элемента в allPeople
                                    count -= 4;
                                }
                                count++;
                            }
                        }
                    }
                    break;

                //случай с (-d) производит логическое удаление человека с id, заменяет все его данные на null
                case "-d":
                    synchronized (allPeople) {
                        for (String parameter : args) {
                            if (!parameter.equals(args[0])) {
                                //создаем пустого нового Person
                                Person person = Person.createMale(null, null);
                                person.setSex(null);
                                // и заменяем на него указаный в id элемент из allPeople
                                allPeople.set(Integer.parseInt(parameter), person);
                            }
                        }
                    }
                    break;

                //случай с (-i) - выводит на экран информацию о всех людях с заданными id: name sex bd
                case "-i":
                    synchronized (allPeople) {
                        for (String parameter : args) {
                            if (!parameter.equals(args[0])) {
                                Person person = allPeople.get(Integer.parseInt(parameter));
                                if (person.getSex() == Sex.MALE)
                                    System.out.println(person.getName() +
                                            " м " + outPutDateFormat.format(person.getBirthDate()));
                                else
                                    System.out.println(person.getName() +
                                            " ж " + outPutDateFormat.format(person.getBirthDate()));
                            }
                        }
                    }
                    break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        //проверочка
//        synchronized (Solution.class) {
//            for (Person it : allPeople) {
//                System.out.println(it.getName() + " " +
//                        it.getSex() + " " + outPutDateFormat.format(it.getBirthDate()));
//            }
//        }
    }
}
