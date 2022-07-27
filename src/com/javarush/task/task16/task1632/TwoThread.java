package com.javarush.task.task16.task1632;

public class TwoThread extends Thread {
        @Override
        public void run() {
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("InterruptedException");
                    break;
                }
            }
        }
}

