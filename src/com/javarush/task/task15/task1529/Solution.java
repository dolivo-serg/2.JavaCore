package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static
    {
        try
        {
            reset();//add your code here - добавьте код тут
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static CanFly result;

    public static void reset() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String type = reader.readLine();
        if (type.equals("helicopter")) result = new Helicopter();
        else if (type.equals("plane")) {
            int passengers = Integer.parseInt(reader.readLine());
            result = new Plane(passengers);//add your code here - добавьте код тут
        }
        reader.close();
    }
}
