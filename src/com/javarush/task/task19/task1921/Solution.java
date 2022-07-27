package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        if(args.length > 0){
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
                while (reader.ready()){
                    StringBuilder name = new StringBuilder();
                    StringBuilder birthday = new StringBuilder();
                    String[] data = reader.readLine().split(" ");
                    for (String it : data){
                        if(it.matches("\\D+")){
                            name.append(it).append(" ");
                        }
                        else if(it.matches("\\d+")){
                            birthday.append(it).append(" ");
                        }
                    }
                    String[] parsBirthday = birthday.toString().trim().split(" ");
                    GregorianCalendar calendarDate = new GregorianCalendar(
                            Integer.parseInt(parsBirthday[2].trim()),
                            (Integer.parseInt(parsBirthday[1].trim())-1),
                            Integer.parseInt(parsBirthday[0].trim()));
                    PEOPLE.add(new Person(name.toString().trim(), calendarDate.getTime()));
                }
            }
        }
    }
}
