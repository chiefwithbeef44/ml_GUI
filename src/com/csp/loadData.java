package com.csp;

import weka.core.FileHelper;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;

public class loadData
{
    //loader for data from Weka package
    ArffLoader loader = new ArffLoader();
    FileHelper helper = new FileHelper();

    File dataLoaded;

    public File helpTrain()
    {
        helper.setFilePath("C:\\\\Users\\\\RoboKnights\\\\Documents\\\\AP_Compsci_P\\\\Machine_Learning\\\\train.arff");
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
        helper.setFilePath("C:\\\\Users\\\\RoboKnights\\\\Documents\\\\AP_Compsci_P\\\\Machine_Learning\\\\train.arff");
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
