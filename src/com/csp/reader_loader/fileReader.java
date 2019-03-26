package com.csp.reader_loader;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Samuel Blake
 * This class is used to get the Instances from the .arff files that are loaded in loadData.
 * the readFile method is used to get the instances from the data.
 */

public class fileReader
{
    /**
     * Gets the data from the File in the arguments.
     * The FileReader is instantiated with the File specified in args.
     * The ArffReader is instantiated with the new BufferedReader.
     * The data is assigned to the Instances variable.
     * The classIndex of the data is set, then the data is returned.
     * @throws IOException from instantiation of the FileReader and the ArffReader
     * @return Instances -  the Instances from the .arff file
     */
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

    /**
     * Iterates through the instances to make sure that they are not null, then returns one to the list if the instance is null. Else is zero.
     * The second loop then iterates through the first loop and prints out the indices of the null instances.
     * note: does not remove the instances, just identifies them;
     * deprecated as it should not be used, it's pretty useless, working on a new method.
     * @param instances the instances to be checked are null.
     * @return nullInstances, the indices of the instances that are null
     */
    @Deprecated
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