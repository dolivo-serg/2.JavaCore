package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputFile1 = new FileInputStream(reader.readLine());
             FileOutputStream outputFile2 = new FileOutputStream(reader.readLine());
             FileOutputStream outputFile3 = new FileOutputStream(reader.readLine())){
            if (inputFile1.available() > 0 && inputFile1.available()%2==0) {
                 byte[] buffer1 = new byte[inputFile1.available() / 2];
                 int count1 = inputFile1.read(buffer1);
                 outputFile2.write(buffer1, 0, count1);
                 byte[] buffer2 = new byte[inputFile1.available()];
                 int count2 = inputFile1.read(buffer2);
                 outputFile3.write(buffer2, 0, count2);
                }
            else if(inputFile1.available() > 0 && inputFile1.available()%2!=0) {
                byte[] buffer1 = new byte[(inputFile1.available() / 2) + 1];
                 int count1 = inputFile1.read(buffer1);
                 outputFile2.write(buffer1, 0, count1);
                 byte[] buffer2 = new byte[inputFile1.available()];
                 int count2 = inputFile1.read(buffer2);
                 outputFile3.write(buffer2, 0, count2);
            }
        }
    }
}
