package com.csp;

public class Main {
    public static loadData dataLoader = new loadData();
    public static void main(String[] args)
    {
        dataLoader.trainData(dataLoader.helpTrain());
        dataLoader.testData(dataLoader.helpTest());
    }
}
