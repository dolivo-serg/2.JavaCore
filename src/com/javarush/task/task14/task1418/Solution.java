package com.javarush.task.task14.task1418;

import java.util.LinkedList;
import java.util.List;

/* 
Исправь четыре ошибки
*/

public class Solution {
    public static void main(String[] args) {
        List<Number> list = new LinkedList<Number>();
        initList(list);
        printListValues(list);
        processCastedObjects(list);
    }

        private static void initList(List<Number> list){
            list.add(new Double(1000f));
            list.add(new Double("123e-445632"));
            list.add(new Float(-90 / -3));
            list.remove(new Double("123e-445632"));
        }

        private static void printListValues(List<Number> list){
            //Исправь 2 ошибки
            for (Number it : list) {
                System.out.println(it);
            }
        }

        private static void processCastedObjects(List<Number> list){
            for (Number object : list) {
                if (object instanceof Float) {
                    Float a = (Float) object;
                    System.out.println("Is float value defined? " + !(a.isNaN()));
                } else if (object instanceof Double) {
                    Double a = (Double) object;
                    System.out.println("Is double value infinite? " + a.isInfinite());
                }
            }
        }

}