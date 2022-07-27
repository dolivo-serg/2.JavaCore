package com.javarush.task.task19.task1904;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        PersonScanner ps = new PersonScannerAdapter(new Scanner(new FileInputStream("C:\\1.txt")));
        System.out.println(ps.read());

        ps.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public void close() {
            fileScanner.close();
        }
        @Override
        public Person read() {
            String [] data = fileScanner.nextLine().split(" ");
            Calendar calendar = new GregorianCalendar(
                    Integer.parseInt(data[5]),
                    Integer.parseInt(data[4])-1,
                    Integer.parseInt(data[3]));
            Date date = calendar.getTime();

            return new Person(data[1], data[2], data[0], date);
        }
    }
}
