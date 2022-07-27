package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String file = null;
            try {
                while (true){
                    file = reader.readLine();
                    try(FileInputStream fileInputStream = new FileInputStream(file)){

                    }
                }
            }
            catch (FileNotFoundException e){
                System.out.println(file);
            }
        }
    }
}
