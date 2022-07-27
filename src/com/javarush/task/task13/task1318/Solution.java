package com.javarush.task.task13.task1318;

import java.io.*;


/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String way = reader.readLine();
            InputStream inStream = new FileInputStream(way);
            int i;
            while ((i = inStream.read())!= -1){
                System.out.print((char)i);
            }
            inStream.close();
            reader.close();
        }
        catch (IOException e){
            System.out.println("Ошибка ввода");
        }

    }
}