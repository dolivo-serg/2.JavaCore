package com.javarush.task.task15.task1525;



import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {

    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(Statics.FILE_NAME)));
            while (reader.ready())
            lines.add(reader.readLine());
            }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (String it : lines) {
            System.out.println(it);
        }

    }
}
