package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> array = new ArrayList<>();

        String file = reader.readLine();
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String line;
        while((line = reader.readLine()) != null ){
            int value = Integer.parseInt(line);
            if (line.equals("")) continue;
            if (value%2==0) array.add(value);
        }
        Collections.sort(array);
        for (Integer it:array) {
            System.out.println(it);
        }

        reader.close();
    }
}
