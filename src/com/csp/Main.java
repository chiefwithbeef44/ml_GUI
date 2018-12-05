package com.csp;

import java.io.File;

public class Main
{
    static fileReader reader = new fileReader();
    static loadData dataLoader = new loadData();
    public static File trainFile;

    public static void main(String[] args)
    {
        //sets temporary system-dependent path found in loadData
        dataLoader.setTempPath();

        //tries to create the file variable for the train file, and tests to see if it is there and can be read
        try
        {
            dataLoader.train = new File(dataLoader.trainPath);
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        System.out.println("train can be read: "+dataLoader.train.canRead());
        System.out.println("train file exists: " + dataLoader.train.exists());
        System.out.println("train file path: "+dataLoader.train.getAbsolutePath());
        //prints a separator
        System.out.println("-------------------------------------------------------------------------------------------");

        //tries to create the file variable for the test file, and tests to see if it is there and can be read
        try
        {
            dataLoader.test = new File(dataLoader.testPath);
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        System.out.println("test can be read: "+dataLoader.test.canRead());
        System.out.println("test file exists: " + dataLoader.test.exists());
        System.out.println("test file path: "+dataLoader.test.getAbsolutePath());

        reader.readTest();
        reader.readTrain();
    }
}
