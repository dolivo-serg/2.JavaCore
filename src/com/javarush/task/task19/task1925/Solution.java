package com.javarush.task.task19.task1925;

/*
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length > 0){
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))){
                String line;
                String output = "";
                while ((line = reader.readLine())!= null){
                    String[] lineSplit = line.split(" ");
                    for (String i : lineSplit){
                        if(i.length() > 6){
                            output = output + i + " ";
                        }
                    }
                }
                writer.write(output.trim().replaceAll(" ",","));
            }
        }
    }
}
