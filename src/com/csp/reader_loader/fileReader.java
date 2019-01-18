package com.csp.reader_loader;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author chiefwithbeef44
 */

public class fileReader
{
    public Instances readFile(File file) throws IOException
    {
    	System.out.println("-------------------------------------------------------------------------------------------");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println("successfully instantiated BufferedReader // fileReader:19");
        ArffLoader.ArffReader arff = new ArffLoader.ArffReader(reader);
        System.out.println("successfully instantiated the ArffReader // fileReader:21");
        Instances data;
        System.out.println("successfully created Instances var // fileReader:23");
        data = arff.getData();
        System.out.println("successfully assigned data var to .getData() // fileReader:25");
        data.setClassIndex(data.numAttributes() - 1);
        System.out.print("successfully set classIndex // fileReader:27");
        return data;
    }

    public int[] checkIfNull(Instances instances)
    {
        assert instances != null;
        int[] nullInstances = new int[instances.numInstances()];
        for(int i = 0; i<instances.numAttributes(); i++ )
        {
            if(instances.get(i).toDoubleArray() == null)
            {
                nullInstances[i] = 1;
            }else {
                nullInstances[i] = 0;
            }
        }
        return nullInstances;
    }
}