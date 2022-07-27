package com.javarush.task.task19.task1908;

import java.io.*;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()))){

            while (fileReader.ready()){
                String[] split = fileReader.readLine().split(" ");
                for (String word : split) {
                        try {
                            int num = Integer.parseInt(word);
                            fileWriter.write(word);
                            fileWriter.write(" ");
                        }
                        catch(NumberFormatException e){
                        }
                    }
                }

            }
        }
    }