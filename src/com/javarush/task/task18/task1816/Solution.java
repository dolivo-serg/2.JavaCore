package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException { //65-90 и 97-122
        if (args.length > 0) {
            try (FileReader fileReader = new FileReader(args[0])) {
                long count = 0;
                while (fileReader.ready()) {
                    int l = fileReader.read();
                    if (l >= 65 && l <= 90 || l >= 97 && l <= 122) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }
}
