package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            file1 = reader.readLine();
            file2 = reader.readLine();
        }
        List<String> File1Lines = readFileLines(file1);
        List<String> File2Lines = readFileLines(file2);
        int counterLineFile1 = 0;
        int counterLineFile2 = 0;

        while ((counterLineFile1 < File1Lines.size()) && (counterLineFile2 < File2Lines.size())) {
            if (File1Lines.get(counterLineFile1).equals(File2Lines.get(counterLineFile2))) {
                lines.add(new LineItem(Type.SAME, File1Lines.get(counterLineFile1)));
                counterLineFile1++;
                counterLineFile2++;
            } else if ((counterLineFile2 + 1 < File2Lines.size()) && File1Lines.get(counterLineFile1).equals(File2Lines.get(counterLineFile2 + 1))) {
                lines.add(new LineItem(Type.ADDED, File2Lines.get(counterLineFile2)));
                counterLineFile2++;
            } else if ((counterLineFile1 + 1 < File1Lines.size()) && File1Lines.get(counterLineFile1 + 1).equals(File2Lines.get(counterLineFile2))) {
                lines.add(new LineItem(Type.REMOVED, File1Lines.get(counterLineFile1)));
                counterLineFile1++;
            }
        }
        while (counterLineFile1 < (File1Lines.size())) {
            lines.add(new LineItem(Type.REMOVED, File1Lines.get(counterLineFile1)));
            counterLineFile1++;
        }
        while (counterLineFile2 < (File2Lines.size())) {
            lines.add(new LineItem(Type.ADDED, File2Lines.get(counterLineFile2)));
            counterLineFile2++;
        }
    }

    static List<String> readFileLines(String file) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> fileLines = new ArrayList<String>();
            String line;
            while ((line = reader.readLine()) != null) {
                fileLines.add(line);
            }
            return fileLines;
        }
    }

    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
