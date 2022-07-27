package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }


    private static Word findWord(int [][] crossword, char[]spitWord, int startX, int startY, int x, int y) {
        int endX = startX;
        int endY = startY;
        try {
            for (int i = 0; i < spitWord.length; i++)
                if ((int) spitWord[i] != crossword[endX = startX + (i * x)][endY = startY + (i * y)])
                    return null;
        }catch (IndexOutOfBoundsException e){
            return null;
        }
        Word word = new Word(new String(spitWord));
        word.setStartPoint(startY, startX);
        word.setEndPoint(endY, endX);
        return word;
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        if (words.length > 0) {
            for (String word : words) {
                char[] splitWord = word.toCharArray();

                for (int line = 0; line < crossword.length; line++) {
                    for (int letter = 0; letter < crossword[line].length; letter++) {
                        if(crossword[line][letter]==splitWord[0]){
                            list.add(findWord(crossword, splitWord, line, letter, 1, -1));
                            if(splitWord.length == 1) continue;
                            list.add(findWord(crossword, splitWord, line, letter, 1, 0));
                            list.add(findWord(crossword, splitWord, line, letter, 1, 1));
                            list.add(findWord(crossword, splitWord, line, letter, -1, -1));
                            list.add(findWord(crossword, splitWord, line, letter, -1, 0));
                            list.add(findWord(crossword, splitWord, line, letter, -1, 1));
                            list.add(findWord(crossword, splitWord, line, letter, 0, -1));
                            list.add(findWord(crossword, splitWord, line, letter, 0, 1));
                            list.removeIf(Objects::isNull);
                        }
                    }
                }
            }
        }
        //проверочка
        for (Word word : list) {
            System.out.println(word);
        }
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
