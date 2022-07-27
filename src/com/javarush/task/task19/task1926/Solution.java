package com.javarush.task.task19.task1926;

/*
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))){
            String line;
            while ((line = fileReader.readLine()) != null){
                StringBuilder lineBuilder = new StringBuilder(line);
                System.out.println(lineBuilder.reverse());
            }
        }
    }
}
