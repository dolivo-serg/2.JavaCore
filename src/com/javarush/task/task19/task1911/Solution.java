package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String line = byteArrayOutputStream.toString().toUpperCase();

        System.out.println(line);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
