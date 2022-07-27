package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        userResponse();
    }

    private static void userResponse() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String request = reader.readLine();
        if (!request.equals("exit")) {
            try{
                if (request.contains("."))
                    print(Double.parseDouble(request));
                else if (Integer.parseInt(request) > 0 && Integer.parseInt(request) < 128)
                    print(Short.parseShort(request));
                else
                    print(Integer.parseInt(request));
            }
            catch (Exception e) {
                print(request);
            }
            userResponse();
        }
        else
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
