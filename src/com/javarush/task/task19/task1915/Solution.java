package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream original = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputStream);

        System.setOut(output);
        testString.printSomething();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine())){
            fileOutputStream.write(outputStream.toByteArray());
        }
        System.setOut(original);
        System.out.println(outputStream.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

