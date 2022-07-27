package com.javarush.task.task18.task1826;

import java.io.*;


/* 
Шифровка
*/

public class Solution {
    private static final int ENCRYPTION_KEY = 4;

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            FileInputStream input = new FileInputStream(args[1]);
            FileEncryptionDecryption output = new FileEncryptionDecryption(new FileOutputStream(args[2]));
            switch (args[0]) {
                case "-e":
                    while (input.available() > 0) {
                        output.write(input.read(), false, ENCRYPTION_KEY);
                    }
                    break;

                case "-d":
                    while (input.available() > 0) {
                        output.write(input.read(), true, ENCRYPTION_KEY);
                    }
                    break;
            }
            input.close();
            output.close();
        }
    }
}

class FileEncryptionDecryption {

    private final FileOutputStream fileOutputStream;

    public FileEncryptionDecryption(FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
    }

    public void write(int b, boolean encrypted, int key) throws IOException {
        if (encrypted)
            fileOutputStream.write(b - key);
        else
            fileOutputStream.write(b + key);
    }

    public void close() throws IOException {
        fileOutputStream.close();
    }
}
