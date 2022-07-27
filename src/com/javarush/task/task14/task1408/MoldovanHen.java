package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 15;
    }
    String getDescription(){
        String text = super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу "
                + getCountOfEggsPerMonth() + " яиц в месяц.";
        return text;
    }
}
