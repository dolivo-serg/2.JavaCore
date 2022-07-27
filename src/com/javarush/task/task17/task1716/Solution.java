package com.javarush.task.task17.task1716;

/* 
Синхронизированные методы
*/
//    м1-м0-м3
public class Solution {
    private double param = Math.random();
    private StringBuilder sb = new StringBuilder();
//бесполезная локальная переменнная присваивает м3
    private void method0() {
        Double d = method3();
    }
//порождает и применяет м0
    protected void method1(String param1) {
        Solution solution = new Solution();
        solution.method0();
    }
//ни о чем
    public void method2(int param1) {
        param1++;
    }
//возвращает в м0 рандомный дабл с использованннием поле класса которое выполняет не атомарную операцию
    synchronized double method3() {
        double random = Math.random();
        param += 40.7;
        return random + param;
    }
// записывает в поле класса значение
    private synchronized void method4() {
        sb.append(1).append(1).append(1).append(1);
    }
//войд метот в котором пораждается новый обьект StringBuffer (ни о чем)
    protected void method5(String param2) {
        new StringBuffer().append(param2).append(param2).append(param2);
    }
//переписывает поле класса с использованием значения из м7
    public synchronized String method6(int param2) {
        System.out.println("Thinking....");
        method7(5e-2);
        sb = new StringBuilder("Got it!.");
        return sb.toString();
    }
// возвращает значение в м6
    String method7(double param2) {
        return "" + param2;
    }

    public static void main(String[] args) {

    }

}
