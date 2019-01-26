package com.csp.reader_loader;

import weka.core.FileHelper;

import java.io.File;
import java.util.Scanner;

/**
 * @author chiefwithbeef44
 */

public class loadData
{
	//loader for data from Weka package
	private FileHelper helper = new FileHelper();

	public static String trainPath;
	public static String testPath;

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

	public File getFile(String filepath)
	{
		helper.setFilePath(filepath);
		return helper.getFile();
	}

	public File train = getFile(trainPath);
	public File test = getFile(testPath);
}
