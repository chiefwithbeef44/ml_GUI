package com.csp;

import java.io.File;

public class Main
{
    static fileReader reader = new fileReader();
    static loadData dataLoader = new loadData();
    public static File trainFile;

    public static void main(String[] args)
    {
        dataLoader.inputPath();
        dataLoader.trainData(dataLoader.helpTrain());
        //put train split here
        trainFile = dataLoader.loader.retrieveFile();
        try {
            reader.readFile(trainFile);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        dataLoader.testData(dataLoader.helpTest());
    }
}
