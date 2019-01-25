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
    //retruns the Instances from the .arff file
    public Instances readFile(File file) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArffLoader.ArffReader arff = new ArffLoader.ArffReader(reader);
        Instances data;
        data = arff.getData();
        data.setClassIndex(data.numAttributes() - 1);
        return data;
    }

    //checks if instances are null, returns the indices of nulls
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
        for(int i: nullInstances)
        {
        	if(i!=0){
        		System.out.println(i+" is null");
			}
		}
        return nullInstances;
    }
}