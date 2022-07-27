package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(console);

        List<String> arrayList = Arrays.asList(byteArrayOutputStream.toString().split("\n"));
        byteArrayOutputStream.close();

        boolean flag = false;
        for (String line : arrayList){
            System.out.println(line);
            if(flag){
                System.out.println("JavaRush - курсы Java онлайн");
            }
            flag = !flag;
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
