package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> addresses = new TreeSet<>();
        String fileName = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String consoleInput = reader.readLine();
                if (consoleInput.equals("end")) {
                    break;
                } else {
                    addresses.add(consoleInput);
                    if(fileName.equals("")){
                        fileName = consoleInput.substring(0, consoleInput.indexOf(".part"));
                    }
                }
            }
        }
        for (String address : addresses){
            try(BufferedReader fileReader = new BufferedReader(new FileReader(address));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true))) {
                while (fileReader.ready()){
                    fileWriter.write(fileReader.read());
                }
            }
        }
    }
}