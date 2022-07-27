package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream input = new FileInputStream(reader.readLine())){
            Set<Integer> output = new TreeSet<>();
            while (input.available() > 0)
                output.add(input.read());
            for(Integer it : output)
            System.out.print(it + " ");
        }
    }
}
