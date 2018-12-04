package com.csp;

import weka.core.FileHelper;
import weka.core.converters.ArffLoader;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class loadData
{
    //loader for data from Weka package
    ArffLoader loader = new ArffLoader();
    FileHelper helper = new FileHelper();
    File dataLoaded;

    public Path trainPath = Paths.get("train.arff");
    public Path testPath = Paths.get("test.arff");

    public String filePath_1;
    public String filePath_2;
    public void inputPath()
    {

    Scanner reader = new Scanner(System.in);
    System.out.println("Enter the filepath of train.arff: ");
    filePath_1 = reader.nextLine();
    System.out.println("Enter the filepath of test.arff: ");
    filePath_2 = reader.nextLine();
    reader.close();
    }
    public File helpTrain()
    {
        helper.setFilePath(filePath_1);
        dataLoaded = helper.getFile();
        return dataLoaded;
    }
    public void trainData(File data)
    {
        try
        {
            loader.setFile(data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public File helpTest()
    {
        helper.setFilePath(filePath_2);
        dataLoaded = helper.getFile();
        return dataLoaded;
    }
    public void testData(File data)
    {
        try
        {
            loader.setFile(data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
