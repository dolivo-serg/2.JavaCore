package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream inputStream = new FileInputStream(reader.readLine());
            FileOutputStream outputStream = new FileOutputStream(reader.readLine())){
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            for (int i = 1;i<=buffer.length; i++)
                outputStream.write(buffer[buffer.length-i]);
        }
    }
}
