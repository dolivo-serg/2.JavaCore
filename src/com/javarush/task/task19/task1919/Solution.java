package com.javarush.task.task19.task1919;

/*
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            Map<String, Double> map = new TreeMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
                while (reader.ready()) {
                    String[] line = reader.readLine().split(" ");
                    map.merge(line[0], Double.parseDouble(line[1]), Double::sum);
                }
            }
            for (Map.Entry<String, Double> it : map.entrySet()) {
                System.out.println(String.format("%s %s", it.getKey(), it.getValue()));
            }
        }
    }
}
