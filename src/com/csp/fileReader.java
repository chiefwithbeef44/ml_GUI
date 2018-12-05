package com.csp;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.*;

public class fileReader
{
    loadData loader;
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
    public void readTest()
    {
        BufferedReader reader =
                null;
        try {
            reader = new BufferedReader(new FileReader(loader.test));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArffLoader.ArffReader arff = null;
        try {
            assert reader != null;
            arff = new ArffLoader.ArffReader(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert arff != null;
        Instances data = arff.getData();
        data.setClassIndex(data.numAttributes() - 1);
    }
    public void readTrain()
    {
        BufferedReader reader =
                null;
        try {
            reader = new BufferedReader(new FileReader(loader.train));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArffLoader.ArffReader arff = null;
        try {
            assert reader != null;
            arff = new ArffLoader.ArffReader(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert arff != null;
        Instances data = arff.getData();
        data.setClassIndex(data.numAttributes() - 1);
    }
}