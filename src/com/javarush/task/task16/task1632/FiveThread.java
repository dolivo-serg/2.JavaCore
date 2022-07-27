package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FiveThread extends Thread {
    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            while (true){
                String s = reader.readLine();
                if (s.equals("N")) {
                    System.out.println(sum);
                    break;
                }
                else
                    sum += Integer.parseInt(s);
            }
            reader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

