package com.csp;

import weka.core.FileHelper;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;

public class loadData
{
    ArffLoader loader = new ArffLoader();
    FileHelper helper = new FileHelper();

    File dataLoaded;
    public File help()
    {
        helper.setFilePath("C:\\\\Users\\\\RoboKnights\\\\Documents\\\\AP_Compsci_P\\\\Machine_Learning\\\\train.arff");
        dataLoaded = helper.getFile();
        return dataLoaded;
    }
    public void LoadData()
    {
        try {
            loader.setFile(dataLoaded);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
