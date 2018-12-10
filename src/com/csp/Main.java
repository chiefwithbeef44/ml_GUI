package com.csp;

import com.csp.clusterer_classifier.dataClusterer;
import com.csp.model.createModel;
import com.csp.model.trainModel;
import com.csp.reader_loader.fileReader;
import com.csp.reader_loader.loadData;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;

public class Main
{
    static dataClusterer clusterer = new dataClusterer();
    static fileReader reader = new fileReader();
    static loadData dataLoader = new loadData();
    static createModel model = new createModel();
    static trainModel trainer = new trainModel();

    private static File testFile = dataLoader.helpTest();
    private static File trainFile = dataLoader.helpTrain();

    private static Element element;
    public static void main(String[] args)
    {
        //sets temporary system-dependent path found in loadData
        dataLoader.setTempPath();

        //tries to create the file variable for the train file, and tests to see if it is there and can be read
        try
        {
            dataLoader.train = new File(dataLoader.trainPath);
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        System.out.println("train can be read: "+dataLoader.train.canRead());
        System.out.println("train file exists: " + dataLoader.train.exists());
        System.out.println("train file can be written to: " + dataLoader.train.canWrite());
        System.out.println("train file path: "+dataLoader.train.getAbsolutePath());
        //prints a separator
        System.out.println("-------------------------------------------------------------------------------------------");

        //tries to create the file variable for the test file, and tests to see if it is there and can be read
        try
        {
            dataLoader.test = new File(dataLoader.testPath);
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        System.out.println("test can be read: "+dataLoader.test.canRead());
        System.out.println("test file exists: " + dataLoader.test.exists());
        System.out.println("test file can be written to: "+ dataLoader.test.canWrite());
        System.out.println("test file path: "+dataLoader.test.getAbsolutePath());

        //sets files in loadData
        try {
            dataLoader.trainData(dataLoader.helpTrain());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //tests read of train file
        try {
            reader.readFile(dataLoader.train);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //tests read of test file
        try {
            reader.readFile(dataLoader.test);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //builds 10 clusters of data
        try {
            clusterer.clusterFile(dataLoader.train);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //builds a model of the clustered data
        try {
            model.modelMaker(reader.readFile(dataLoader.helpTrain()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            trainer.train(reader.readFile(dataLoader.helpTrain()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
