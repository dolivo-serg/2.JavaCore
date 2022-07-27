package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {

            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
                while (reader.ready()) {
                    String[] line = reader.readLine().split(" ");
                    for (String word : line) {
                        if (word.matches(".*\\d.*")) {
                            writer.write(word);
                            writer.write(" ");
                        }
                    }
                }
            }

        }
    }
}
