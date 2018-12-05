package com.csp;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class fileReader
{

    private BufferedReader reader;

    public void readFile(File file) throws IOException
    {
        ArffLoader.ArffReader arffReader;
        arffReader = new ArffLoader.ArffReader(reader);
        Instances data;
        data = arffReader.getData();
        System.out.println(arffReader.getStructure());
        System.out.println(data.toString());
    }
}