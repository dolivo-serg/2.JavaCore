package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }
    //1
    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    //2
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    //3
    public static void printMatrix(){    }
    //4
    public static void printMatrix(int m){    }
    //5
    public static void printMatrix(int m, int n){    }
    //6
    public static void printMatrix(int m, String value){    }
    //7
    public static void printMatrix(int n, String value1, String value2){    }
    //8
    public static void printMatrix(boolean m, int n, String value){    }
    //9
    public static void printMatrix(short m, int n, String value){    }
    //10
    public static void printMatrix(byte m, int n, String value){    }
}
