package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        while (true) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 FileInputStream inputStream = new FileInputStream(reader.readLine())) {
                boolean flag = false;
                if (inputStream.available() < 1000)
                    flag = true;
                    while (inputStream.available() > 0)
                        inputStream.read();
                    if (flag)
                    break;
            }
        }
        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
