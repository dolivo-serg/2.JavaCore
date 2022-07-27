package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {


    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> collection = new HashMap<>();
        Map<Integer, Integer> collectionCopy;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            collectionCopy = new HashMap<>();
            collectionCopy.put(0, 0); //костыль
            //заполняем колекцию(байт, счетчик)
            while (fileInputStream.available() > 0) {
                collection.putAll(collectionCopy);
                Integer input = fileInputStream.read();
                if (collection.containsKey(input)) {
                    for (HashMap.Entry<Integer, Integer> it : collection.entrySet()) {
                        if (input.equals(it.getKey()))
                            it.setValue(it.getValue() + 1);
                    }
                } else
                    collection.put(input, 1);
            }
            //подчистим костыль
            collectionCopy.clear();
            collection.remove(0);
        }
        //ищем самый редкий байт
        Integer countMin = 255;
        for (Map.Entry<Integer, Integer> it : collection.entrySet()) {
            if (it.getValue() < countMin) {
                countMin = it.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> it : collection.entrySet()) {
            if (it.getValue().equals(countMin))
                System.out.print(it.getKey() + " ");
        }
    }
}
