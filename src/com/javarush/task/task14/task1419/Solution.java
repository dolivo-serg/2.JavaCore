package com.javarush.task.task14.task1419;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception

        try {
            float i = 1 / 0;

        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        try {
            float[] i = new float[0];
            i [0] = 1;

        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            Object [] list = new String[1];
            list[0] = 12;

        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }

        try {
            Object c = new Character('%');
            System.out.println((Byte)c);

        } catch(ClassCastException e) {
            exceptions.add(e);
        }

        try {
            int [] x = new int [-2];

        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

        try {
            int [] x = null;
            System.out.println(x[0]);

        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {
            String x = "123";
            System.out.println(x.charAt(3));

        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            Stack<Integer> stack = new Stack<>();
            stack.pop();

        } catch (EmptyStackException e) {
            exceptions.add(e);
        }

        try {
            InputStreamReader reader = new InputStreamReader(System.in);
            reader.close();
            int c = reader.read();

        } catch (IOException e) {
            exceptions.add(e);
        }

        try {
            String num = "twenty";
            Integer x = Integer.parseInt(num);

        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
    }

}
