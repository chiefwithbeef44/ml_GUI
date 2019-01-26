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
	//turns files into Instances
	private static fileReader reader = new fileReader();
	//loads the files
	private static loadData dataLoader = new loadData();
	//is used for classification, normalizes data
	private static KNNModel model;
	//the data
	private static Instances trainData;
	private static Instances testData;

	public static void main(String[] args) throws Exception
	{
		//Takes file path from console
		dataLoader.inputPath();
		//instantiates files from inputted paths
		dataLoader.train = new File(loadData.trainPath);
		dataLoader.test = new File(loadData.testPath);
		//Runs tests
		System.out.println("train can be read: "+dataLoader.train.canRead());
		System.out.println("train file exists: " + dataLoader.train.exists());
		System.out.println("train file can be written to: " + dataLoader.train.canWrite());
		System.out.println("train file path: "+dataLoader.train.getAbsolutePath());
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("test can be read: "+dataLoader.test.canRead());
		System.out.println("test file exists: " + dataLoader.test.exists());
		System.out.println("test file can be written to: "+ dataLoader.test.canWrite());
		System.out.println("test file path: "+dataLoader.test.getAbsolutePath());

		//files are turned into instances
		trainData = reader.readFile(dataLoader.train);
		testData = reader.readFile(dataLoader.test);

		//model is instantiated, normalizing the data
		model = new KNNModel(trainData, testData);

		//Evaluates the model
		Eval.evaluate(model.classifier, model.train, model.test);
	}
}
