package com.csp;

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
    public void trainData(File data) throws IOException {
            loader.setFile(data);
    }
    public File helpTest()
    {
        helper.setFilePath(filePath_2);
        dataLoaded = helper.getFile();
        return dataLoaded;
    }
    public void testData(File data) throws IOException {
        loader.setFile(data);
    }
}
