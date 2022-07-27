package com.javarush.task.task19.task1920;

/*
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length > 0){
            Map<String, Double> map = new TreeMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
                while (reader.ready()){
                    String[] line = reader.readLine().split(" ");
                    map.merge(line[0], Double.parseDouble(line[1]), Double::sum);
                }
            }
            double max = 0;
            for (Map.Entry<String, Double> pare : map.entrySet()){
                if(pare.getValue()>max){
                    max = pare.getValue();
                }
            }
            Set<String> result = new TreeSet<>();
            for (Map.Entry<String, Double> pare : map.entrySet()){
                if (pare.getValue()==max){
                    result.add(pare.getKey());
                }
            }
            for (String name : result){
                System.out.println(name);
            }
        }
    }
}
