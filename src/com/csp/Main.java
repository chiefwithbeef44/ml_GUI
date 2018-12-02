package com.csp;

import java.io.File;

public class Main
{
    static fileReader reader = new fileReader();
    static loadData dataLoader = new loadData();
    public static File trainFile;

    public static void main(String[] args)
    {
        dataLoader.trainData(dataLoader.helpTrain());
        //put train split here
        trainFile = dataLoader.loader.retrieveFile();
        reader.readFile(trainFile);
        dataLoader.testData(dataLoader.helpTest());
    }
}
