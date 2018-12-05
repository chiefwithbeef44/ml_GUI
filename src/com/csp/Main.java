package com.csp;

import java.io.File;
import java.io.IOException;

public class Main
{
    static fileReader reader = new fileReader();
    static loadData dataLoader = new loadData();
    public static File trainFile;

    public static void main(String[] args)
    {
        dataLoader.inputPath();
        try
        {
            dataLoader.trainData(dataLoader.helpTrain());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        //put train split here
        trainFile = dataLoader.loader.retrieveFile();
        try
        {
            reader.readFile(trainFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try
        {
            dataLoader.testData(dataLoader.helpTest());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
