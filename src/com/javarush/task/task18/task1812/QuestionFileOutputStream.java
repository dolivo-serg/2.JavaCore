package com.javarush.task.task18.task1812;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream element;

    public QuestionFileOutputStream(AmigoOutputStream element) {
        this.element = element;
    }


    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        if (userInput.equals("Д")) {
            element.close();
            reader.close();
        }
        if (!userInput.equals("Д"))
            reader.close();
    }

    @Override
    public void flush() throws IOException {
        element.flush();
    }

    @Override
    public void write(int b) throws IOException {
        element.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        element.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        element.write(b, off, len);
    }
}

