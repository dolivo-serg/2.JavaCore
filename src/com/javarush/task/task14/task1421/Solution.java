package com.javarush.task.task14.task1421;

/* 
Singleton
*/

public class Solution {
    public static void main(String[] args) {
        Object one = Singleton.getInstance();
        Object two = Singleton.getInstance();
        System.out.println(one + "\n" + two);
    }
}
