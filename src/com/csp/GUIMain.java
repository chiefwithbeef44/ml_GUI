package com.csp;

import com.csp.model.KNNModel;
import weka.core.Instances;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

import com.csp.reader_loader.fileReader;
public class GUIMain
{
	private static JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getParentDirectory(FileSystemView.getFileSystemView().getHomeDirectory()));
	private static FileNameExtensionFilter filter = new FileNameExtensionFilter("arff files", "arff");
	private static fileReader r = new fileReader();

	public static void main(String[] args) throws Exception {
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setFileFilter(filter);
		fileChooser.setDialogTitle("Select your train file");

		int returnVal = fileChooser.showOpenDialog(null);
		File train = new File(fileChooser.getSelectedFile().getAbsolutePath());
		System.out.println("Train file exists: " + train.exists());
		System.out.println("Train file path: " + train.getAbsolutePath());
		System.out.println("Train can be read: " + train.canRead());

		fileChooser.setDialogTitle("Select your test file");
		int value = fileChooser.showOpenDialog(null);
		File test = new File(fileChooser.getSelectedFile().getAbsolutePath());
		System.out.println("Train file exists: " + test.exists());
		System.out.println("Train file path: " + test.getAbsolutePath());
		System.out.println("Train can be read: " + test.canRead());

		Instances trainData = r.readFile(train);
		Instances testData = r.readFile(test);
		KNNModel m = new KNNModel(trainData, testData, 0);
		System.out.println(Eval.evaluate(m.classifier, trainData, testData));
	}
}
