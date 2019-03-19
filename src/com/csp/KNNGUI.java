package com.csp;

import com.csp.model.KNNModel;
import weka.core.Instances;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.util.HashMap;

import com.csp.reader_loader.fileReader;

/**
 * @author Sam Blake
 * This class is the GUI for the KNNMain class.
 * It brings up a GUI which prompts a selection for a train file, and another prompt for a test file.
 * A full run of the program can take anywhere from ~50 mins to 3 hours.
 */
public class KNNGUI
{
	private static JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getParentDirectory(FileSystemView.getFileSystemView().getHomeDirectory()));
	private static FileNameExtensionFilter filter = new FileNameExtensionFilter("arff files", "arff");
	private static fileReader r = new fileReader();
	private static KNNModel model;

	/**
	 * This method is the main method for the GUI version of this project.
	 * It first sets the mode, then the filter to only .arff files (the only ones that can be read)
	 * Then, sets a dialog title.
	 * Then the chooser is displayed, and a series of tests run.
	 * This is repeated for the test file.
	 * Then, each file is read and converted from a File var to an Instances var.
	 * The model is then constructed and evaluated.
	 * @param args necessary for main method declaration
	 * @throws Exception thrown by KNNModel constructor
	 */
	public static void main(String[] args) throws Exception
	{
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setFileFilter(filter);
		fileChooser.setDialogTitle("Select your train file");

		fileChooser.showOpenDialog(null);
		File train = new File(fileChooser.getSelectedFile().getAbsolutePath());
		System.out.println("Train file exists: " + train.exists());
		System.out.println("Train file path: " + train.getAbsolutePath());
		System.out.println("Train can be read: " + train.canRead());

		fileChooser.setDialogTitle("Select your test file");
		fileChooser.showOpenDialog(null);
		File test = new File(fileChooser.getSelectedFile().getAbsolutePath());
		System.out.println("Test file exists: " + test.exists());
		System.out.println("Test file path: " + test.getAbsolutePath());
		System.out.println("Test can be read: " + test.canRead());

		Instances trainData = r.readFile(train);
		Instances testData = r.readFile(test);

		model = new KNNModel(trainData, testData, 0.0, 1500);
		GUIBuilder builder = new GUIBuilder(Eval.evaluate(model.classifier, trainData, testData),128, 128,new JFrame("Results!"));
		builder.createAndShowGUI();
	}
}
