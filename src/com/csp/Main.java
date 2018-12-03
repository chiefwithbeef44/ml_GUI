package com.csp;

import java.io.File;

public class Main
{
    static fileReader reader = new fileReader();
    static loadData dataLoader = new loadData();
    public static File trainFile;
    public static loadData.cmd cmd = new loadData.cmd();

    public static void main(String[] args)
    {
//        dataLoader.trainData(dataLoader.helpTrain());
//        //put train split here
//        trainFile = dataLoader.loader.retrieveFile();
//        reader.readFile(trainFile);
//        dataLoader.testData(dataLoader.helpTest());
        try {
            System.out.println(cmd.find(dataLoader.testPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(cmd.find(dataLoader.trainPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
