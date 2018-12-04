package com.csp;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.BufferedReader;
import java.io.File;

public class fileReader
{
    private BufferedReader reader;
    loadData dataLoader;

    public void readFile(File file) throws NullPointerException {
        ArffLoader.ArffReader arffReader = null;
        Instances data = null;
        data = arffReader.getData();
        System.out.println(arffReader.getStructure());
        System.out.println(data.toString());
    }
}