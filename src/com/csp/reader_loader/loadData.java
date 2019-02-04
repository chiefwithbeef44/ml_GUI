package com.csp.reader_loader;

import weka.core.FileHelper;

import java.io.File;
import java.util.Scanner;

/**
 * @author Samuel Blake
 * This class contains the methods used to get the files used to make predictions and the model.
 * setTempPath is used for development purposes. For any use, it should not be accessed.
 * inputPath is used to input the paths of the data.
 *
 */

public class loadData
{
	//loader for data from Weka package
	private FileHelper helper = new FileHelper();

	public static String trainPath;
	public static String testPath;

	/**
	 * Scanner is instantiated for input.
	 * The reader then gets the filepath input by the user.
	 * That process is repeated for the next file, train and then test, respectively.
	 */
	public void inputPath()
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the filepath of train.arff: ");
		trainPath = reader.nextLine();
		System.out.println("Enter the filepath of test.arff: ");
		testPath = reader.nextLine();
		reader.close();
	}

	public static void setTempPath()
	{
		trainPath = "C:\\Users\\RoboKnights\\Documents\\AP_Compsci_P\\Machine_Learning\\train.arff";
		testPath = "C:\\Users\\RoboKnights\\Documents\\AP_Compsci_P\\Machine_Learning\\train.arff";
	}

	/**
	 * Gets the file specified by the filepath argument.
	 * @param filepath string parameter used by the FileHelper to get the file.
	 * @return the file that was specified by the path.
	 */
	public File getFile(String filepath)
	{
		helper.setFilePath(filepath);
		return helper.getFile();
	}

	public File train = getFile(trainPath);
	public File test = getFile(testPath);
}
