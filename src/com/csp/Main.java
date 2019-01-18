package com.csp;

import com.csp.model.Model;
import com.csp.reader_loader.fileReader;
import com.csp.reader_loader.loadData;
import weka.core.Instances;

import java.io.File;
import java.util.Arrays;

/**
 * @author chiefwithbeef44
 */

public class Main
{
    private static fileReader reader = new fileReader();
    private static loadData dataLoader = new loadData();
    private static Model model;
    private static Instances trainData;
    private static Instances testData;
    private static double[] output = new double[42001];

    public static void main(String[] args) throws Exception
	{
        dataLoader.setTempPath();
        dataLoader.train = new File(dataLoader.trainPath);
        dataLoader.test = new File(dataLoader.testPath);
        System.out.println("train can be read: "+dataLoader.train.canRead());
        System.out.println("train file exists: " + dataLoader.train.exists());
        System.out.println("train file can be written to: " + dataLoader.train.canWrite());
        System.out.println("train file path: "+dataLoader.train.getAbsolutePath());
        //prints a separator
        System.out.println("-------------------------------------------------------------------------------------------");
        dataLoader.test = new File(dataLoader.testPath);
        System.out.println("test can be read: "+dataLoader.test.canRead());
        System.out.println("test file exists: " + dataLoader.test.exists());
        System.out.println("test file can be written to: "+ dataLoader.test.canWrite());
        System.out.println("test file path: "+dataLoader.test.getAbsolutePath());
        dataLoader.trainData(dataLoader.helpTrain());
        trainData = reader.readFile(dataLoader.train);
        testData = reader.readFile(dataLoader.test);
        model = new Model(trainData, testData);
        model.create();
		output = model.train();
		System.out.println(Arrays.toString(output));
    }
}
