package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        if(args.length > 0){
            int countSpace = 0;
            int countAll = 0;
            try(FileReader reader = new FileReader(args[0])){
                while (reader.ready()){
                    if(reader.read() == 32){
                        countSpace++;
                    }
                    countAll++;
                }
                double ratio = (((double)countSpace/(double)countAll)*100);
                System.out.printf("%.2f", ratio);
            }
        }
    }
}
