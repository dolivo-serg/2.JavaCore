package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
                while (fileReader.ready()) {
                    String line = fileReader.readLine();
                    if (line.startsWith(args[0] + " ")) {
                        System.out.println(line);
                    }
                }
            }
        }
    }
}
