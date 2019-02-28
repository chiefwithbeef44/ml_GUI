package com.csp.mains;

import com.csp.Eval;
import com.csp.model.KNNModel;
import com.csp.reader_loader.fileReader;
import com.csp.reader_loader.loadData;
import weka.core.Instances;

/**
 * @author Samuel Blake
 * The main class of this program.
 */

class KNNMain
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

	/**
	 * This is the main method for the program. Everything contained in here is run, nothing more, nothing less.
	 * Input method is used to get the filepaths of the train and test files. Further documentation is in the loadData class.
	 * A series of tests are run on the files, making sure that they can be written to, read from, and that they actually exist.
	 * Then the path to each file is printed.
	 * After that, each file is read and the instances variable assigned values.
	 * The model is then instantiated using that data.
	 * The model is then evaluated.
	 * @param args necessary for proper main method declaration.
	 * @throws Exception thrown by readFile, KNNModel constructor, and evaluate.
	 */
	public static void main(String[] args) throws Exception
	{
		//Takes file path from console
		dataLoader.inputPath();

		//Runs tests
		System.out.println("train can be read: " + dataLoader.train.canRead());
		System.out.println("train file exists: " + dataLoader.train.exists());
		System.out.println("train file can be written to: " + dataLoader.train.canWrite());
		System.out.println("train file path: " + dataLoader.train.getAbsolutePath());
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("test can be read: " + dataLoader.test.canRead());
		System.out.println("test file exists: " + dataLoader.test.exists());
		System.out.println("test file can be written to: " + dataLoader.test.canWrite());
		System.out.println("test file path: " + dataLoader.test.getAbsolutePath());

		//files are turned into instances
		trainData = reader.readFile(dataLoader.getFile(loadData.trainPath));
		testData = reader.readFile(dataLoader.getFile(loadData.testPath));
		//model is instantiated, normalizing the data
		model = new KNNModel(trainData, testData, 0, 1500);
		//Evaluates the model
		Eval.evaluate(model.classifier, model.train, model.test);
	}
}
