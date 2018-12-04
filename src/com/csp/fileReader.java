package com.csp;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.*;

public class fileReader
{
    private ArffLoader.ArffReader reader;
    loadData dataLoader;

    public void readFile(File file)
    {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(dataLoader.filePath_1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArffLoader.ArffReader arffReader = null;
        try {
            assert reader != null;
            arffReader = new ArffLoader.ArffReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert arffReader != null;
        Instances data = arffReader.getData();
        data.setClassIndex(data.numAttributes());
        System.out.println(data.toString());
    }
}