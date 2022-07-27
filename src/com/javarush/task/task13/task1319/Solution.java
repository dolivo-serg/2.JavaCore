package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String address = reader.readLine();
        BufferedWriter bufWriter = new BufferedWriter (new FileWriter(address, true));
        while (true) {
            String line = reader.readLine();
            bufWriter.write(line + "\n");
            if (line.equals("exit")) break;
        }
        bufWriter.close();
        reader.close();
    }
}
