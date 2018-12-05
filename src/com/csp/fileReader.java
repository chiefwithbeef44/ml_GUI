package com.csp;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.*;

public class fileReader
{
    BufferedReader reader;
    public void readFile(File file) throws IOException
    {
        ArffLoader.ArffReader arffReader;
        System.out.println("successfully made the reader variable");
        arffReader = new ArffLoader.ArffReader(reader);
        System.out.println("successfully instantiated the reader file");
        Instances data;
        System.out.println("successfully created the data variable");
        data = arffReader.getData();
        System.out.println("successfully assigned data variable to the reader's .getData() function");
        System.out.println(arffReader.getStructure());
        System.out.println(data.toString());
    }
}