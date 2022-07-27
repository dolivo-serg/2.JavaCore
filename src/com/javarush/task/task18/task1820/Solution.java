package com.javarush.task.task18.task1820;


import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String file1;
        String file2;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            file1 = reader.readLine();
            file2 = reader.readLine();
        }
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             FileInputStream fileInputStream = new FileInputStream(file1);
             FileOutputStream fileOutputStream = new FileOutputStream(file2)){
            while(fileInputStream.available() > 0) {
                byteArrayOutputStream.write(fileInputStream.read());
            }
            String[] s = byteArrayOutputStream.toString().split(" ");
            for (int i = 0; i < s.length; i++){
                long num = Math.round(Double.parseDouble(s[i]));
                fileOutputStream.write(String.valueOf(num).getBytes());
                fileOutputStream.write(' ');
            }
        }
    }
}

