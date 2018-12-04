package com.csp;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class fileReader
{
    private BufferedReader reader;
    loadData dataLoader;

    public void readFile(File file)
    {
        ArffLoader.ArffReader arffReader = null;
        try {
            arffReader = new ArffLoader.ArffReader(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Instances data = null;
        data = arffReader.getData();
        System.out.println(arffReader.getStructure());
        System.out.println(data.toString());
    }
}