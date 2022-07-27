package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    private static Map<Integer, Integer> collection = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> collectionCopy;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            collectionCopy = new HashMap<>();
            collectionCopy.put(0, 0); //костыль
            //заполняем колекцию(байт, счетчик)
            while (fileInputStream.available() > 0) {
                collection.putAll(collectionCopy);
                Integer maxByte = fileInputStream.read();
                if (collection.containsKey(maxByte)) {
                    for (HashMap.Entry<Integer, Integer> it : collection.entrySet()) {
                        if (maxByte.equals(it.getKey()))
                            it.setValue(it.getValue() + 1);
                    }
                } else
                    collection.put(maxByte, 1);
            }
            //подчистим костыль
            collectionCopy.clear();
            collection.remove(0);
        }
        //ищем самый частый байт
        Integer countMax = 0;
        Integer keyMax = 0;
        for (Map.Entry<Integer, Integer> it : collection.entrySet()) {
            if (it.getValue() > countMax) {
                countMax = it.getValue();
                keyMax = it.getKey();
            }
    }
        for (Map.Entry<Integer, Integer> it : collection.entrySet()) {
            if (it.getValue().equals(countMax))
                System.out.print(it.getKey() + " ");
        }
    }
}