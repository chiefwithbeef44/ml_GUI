package com.csp;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * @author Sam Blake
 * This class contrains all the GUI related parts of the project.
 * It contains a flexible constructor and one method to show the accuracy and other collected data.
 */
class GUIBuilder
{
	private HashMap<String, Double> dataPoints;
	private Dimension dimensions;
	private JFrame dataFrame;

	/**
	 * This constructor sets all the local variables
	 * @param data this should be the same HashMap returned by the evaluation method in the Eval class
	 * @param height height, in px
	 * @param width width in px
	 * @param frame the JFrame to be used as the results
	 */
	GUIBuilder(HashMap<String, Double> data, int height, int width, JFrame frame)
	{
		this.dataPoints = data;
		this.dimensions = new Dimension(width, height);
		this.dataFrame =  frame;
	}

	/**
	 * This method takes all of the data given in the instructor,
	 * and adds them to labels which are then added to the frame specified in the constructor.
	 */
	void showResultGUI()
	{
		JLabel accL = new JLabel("Accuracy Percentage: ");
		accL.setText(dataPoints.values().toArray()[0].toString());
		dataFrame.add(accL);
		JLabel trainL = new JLabel("Training time: ");
		trainL.setText(dataPoints.values().toArray()[1].toString());
		dataFrame.add(trainL);
		JLabel testL = new JLabel("Testing  time: ");
		testL.setText(dataPoints.values().toArray()[2].toString());
		dataFrame.add(testL);
		dataFrame.add(trainL);
		dataFrame.add(accL);
		dataFrame.setPreferredSize(dimensions);
		dataFrame.setVisible(true);
	}
}
