package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Solution s = new Solution();
        try {
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            FileReader readerFile1 = new FileReader(file1);
            reader = new BufferedReader(readerFile1);
            while (reader.ready())
                allLines.add(reader.readLine());

            FileReader readerFile2 = new FileReader(file2);
            reader = new BufferedReader(readerFile2);
            while (reader.ready())
                forRemoveLines.add(reader.readLine());

            s.joinData();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
