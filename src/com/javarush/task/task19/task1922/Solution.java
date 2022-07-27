package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))){
            while (fileReader.ready()){
                String line = fileReader.readLine();
                String[] splitLine = line.split(" ");
                int count = 0;
                for (int i = 0; i < words.size(); i++){
                    for(String word : splitLine) {
                        if (words.get(i).equals(word.trim())) {
                            count++;
                        }
                    }
                }
                if(count == 2){
                    System.out.println(line);
                }
            }
        }
    }
}
