package com.javarush.task.task18.task1823;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String str;
            while (true){
                str = reader.readLine();
                if(str.equals("exit")){
                    break;
                }
                else {
                    ReadThread readThread = new ReadThread(str);
                    readThread.start();
                }
            }
        }
    }

    public static class ReadThread extends Thread {
        String file;
        int frequentByte;
        public ReadThread(String fileName) {
            this.file = fileName;
        }

        @Override
        public void run() {
            searchingFrequentByte();
            resultMap.put(file, frequentByte);
            interrupt();
        }

        void searchingFrequentByte(){
            try(FileInputStream inputStream = new FileInputStream(file)){
                byte[] aSCII = new byte[128];
                while (inputStream.available() > 0){
                    aSCII[inputStream.read()]++;
                }
                byte max = 0;
                for (int i = 0; i < 128; i++){
                    if(aSCII[i] > max){
                        max = aSCII[i];
                        frequentByte = i;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
