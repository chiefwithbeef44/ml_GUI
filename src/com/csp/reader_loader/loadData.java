package com.csp.reader_loader;

import weka.core.FileHelper;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class loadData
{
    //loader for data from Weka package
    ArffLoader loader = new ArffLoader();
    FileHelper helper = new FileHelper();
    File dataLoaded;

    public String trainPath;
    public String testPath;
    public File train;
    public File test;
    
    public void inputPath()
    {

    Scanner reader = new Scanner(System.in);
    System.out.println("Enter the filepath of train.arff: ");
    trainPath = reader.nextLine();
    System.out.println("Enter the filepath of test.arff: ");
    testPath = reader.nextLine();
    reader.close();
    }
    public void setTempPath() {
        trainPath = "E:\\train.arff";
        testPath = "E:\\test.arff";
    }
    public File helpTrain()
    {
        helper.setFilePath(trainPath);
        dataLoaded = helper.getFile();
        return dataLoaded;
    }
    public void trainData(File data) throws IOException
    {
            loader.setFile(data);
    }
    public File helpTest()
    {
        helper.setFilePath(testPath);
        dataLoaded = helper.getFile();
        return dataLoaded;
    }
    public void testData(File data) throws IOException
    {
        loader.setFile(data);
    }
}
