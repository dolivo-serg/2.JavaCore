package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        String file3;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            file1 = reader.readLine();
            file2 = reader.readLine();
            file3 = reader.readLine();
        }
        try(FileReader file2Reader = new FileReader(file2);
            FileWriter file1Writer = new FileWriter(file1)){
            while (file2Reader.ready()){
                file1Writer.write(file2Reader.read());
            }
        }
        try(FileReader file3Reader = new FileReader(file3);
            FileWriter file1Writer = new FileWriter(file1, true)){
            while(file3Reader.ready()) {
            file1Writer.write(file3Reader.read());
            }
        }
    }
}
