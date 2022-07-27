package com.javarush.task.task19.task1918;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileName()))){
            while (reader.ready()){
                text.append(reader.readLine());
            }
        }

        Document document = Jsoup.parse(text.toString(), "", Parser.xmlParser());

        Elements element = document.select(args[0]);

        for (Element elements : element) {
            System.out.println(elements);
        }
    }

    private static String getFileName() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            return reader.readLine();
        }
    }
}
