package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            file1 = reader.readLine();
            file2 = reader.readLine();
        }
        ByteArrayOutputStream filesData = new ByteArrayOutputStream();
        try(FileInputStream file1Input = new FileInputStream(file1);
            FileInputStream file2Input = new FileInputStream(file2)){
            while (file2Input.available() > 0){
                filesData.write(file2Input.read());
            }
            while (file1Input.available() > 0){
                filesData.write(file1Input.read());
            }
        }
        try(FileOutputStream file1Output = new FileOutputStream(file1)){
            filesData.writeTo(file1Output);
        }
    }
}
