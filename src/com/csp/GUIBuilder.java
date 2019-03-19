package com.csp;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

class GUIBuilder
{
	private HashMap<String, Double> dataPoints;
	private Dimension dimensions;
	private JFrame dataFrame;

	GUIBuilder(HashMap<String, Double> data, int height, int width, JFrame frame)
	{
		this.dataPoints = data;
		this.dimensions = new Dimension(width, height);
		this.dataFrame =  frame;
	}

	void createAndShowGUI()
	{
		JFrame data = new JFrame("Results!");
		JLabel accL = new JLabel("Accuracy Percentage: ");
		accL.setText(dataPoints.values().toArray()[0].toString());
		data.add(accL);
		JLabel trainL = new JLabel("Training time: ");
		trainL.setText(dataPoints.values().toArray()[1].toString());
		data.add(trainL);
		JLabel testL = new JLabel("Testing  time: ");
		testL.setText(dataPoints.values().toArray()[2].toString());
		data.add(testL);
		Dimension d = new Dimension();
		d.setSize(400, 400);
		data.setPreferredSize(d);
		data.setVisible(true);
	}
}
