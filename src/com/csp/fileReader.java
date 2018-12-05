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
        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println("successfully instantiated BufferedReader // fileReader:15");
        ArffLoader.ArffReader arff;
        System.out.println("successfully created ArffReader var // fileReader:17");
        arff = new ArffLoader.ArffReader(reader);
        System.out.println("successfully instantiated the ArffReader // fileReader:19");
        Instances data;
        System.out.println("successfully created Instances var // fileReader:21");
        data = arff.getData();
        System.out.println("successfully assigned data var to .getData() // fileReader:23");
        data.setClassIndex(data.numAttributes() - 1);
        System.out.print("successfully set classIndex // fileReader:25");
    }
}