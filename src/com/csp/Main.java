package com.csp;

import com.csp.model.KNNModel;
import com.csp.reader_loader.fileReader;
import com.csp.reader_loader.loadData;
import weka.core.Instances;

import java.io.File;

/**
 * @author chiefwithbeef44
 */

public class Main
{
    private static fileReader reader = new fileReader();
    private static loadData dataLoader = new loadData();
    private static KNNModel model;
    private static Instances trainData;
    private static Instances testData;

    public static void main(String[] args) throws Exception
	{
        loadData.setTempPath();
        dataLoader.train = new File(loadData.trainPath);
        dataLoader.test = new File(loadData.testPath);
        System.out.println("train can be read: "+dataLoader.train.canRead());
        System.out.println("train file exists: " + dataLoader.train.exists());
        System.out.println("train file can be written to: " + dataLoader.train.canWrite());
        System.out.println("train file path: "+dataLoader.train.getAbsolutePath());
        System.out.println("-------------------------------------------------------------------------------------------");
        dataLoader.test = new File(loadData.testPath);
        System.out.println("test can be read: "+dataLoader.test.canRead());
        System.out.println("test file exists: " + dataLoader.test.exists());
        System.out.println("test file can be written to: "+ dataLoader.test.canWrite());
        System.out.println("test file path: "+dataLoader.test.getAbsolutePath());

        trainData = reader.readFile(dataLoader.train);
        testData = reader.readFile(dataLoader.test);
        model = new KNNModel(trainData, testData);
        Eval.evaluate(model.classifier, trainData, testData);
    }
}
