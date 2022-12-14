package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        int max = 0;
        while (file.available()>0){
            int tmp = file.read();
            if(max < tmp) max = tmp;
        }
        reader.close();
        file.close();
        System.out.println(max);
    }
}
