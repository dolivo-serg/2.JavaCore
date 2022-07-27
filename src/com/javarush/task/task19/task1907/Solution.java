package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int counter = 0;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(getFileName()))) {
            while (fileReader.ready()){
                String[] line = fileReader.readLine().split("\\W");
                for(String word : line){
                    if(word.equals("world")){
                        counter++;
                    }
                }
            }
        }
        System.out.println(counter);
    }

    private static String getFileName() throws IOException{
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            return reader.readLine();
        }
    }
}
