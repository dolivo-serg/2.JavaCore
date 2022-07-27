package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String link = reader.readLine();
        String query = new URL(link).getQuery();
        reader.close();

        boolean flag = false;
        String value = null;

        String[] parameters = query.split("&");
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].contains("obj")) {
                flag = true;
                String [] pare = parameters[i].split("=");
                value = pare [1];
            }
            parameters[i] = parameters[i].split("=")[0];
            System.out.print(parameters[i] + " ");
        }
        if (flag) {
            try {
                System.out.print("\n");
                alert(Double.parseDouble(value));
            } catch (Exception e) {
                alert(value);
            }
        }
    }

    public static void alert ( double value){
        System.out.println("double: " + value);
    }

    public static void alert (String value){
        System.out.println("String: " + value);
    }
}
