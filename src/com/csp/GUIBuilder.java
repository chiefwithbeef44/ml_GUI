package com.csp;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * @author Sam Blake
 * This class contrains all the GUI related parts of the project.
 * It contains a flexible constructor and one method to show the accuracy and other collected data.
 */
class GUIBuilder extends JPanel
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
		super();
		this.dataPoints = data;
		this.dimensions = new Dimension(width, height);
		this.dataFrame =  frame;
	}

	/**
	 * blank constructor for the showResultGUI() method
	 */
	private GUIBuilder(){}

	/**
	 * This method is the core of this class. It writes all of the text to the jFrame.
	 * @param graphics necessary to override the method in the superclass and draw correctly.
	 */
	@Override
	public void paintComponent(Graphics graphics)
	{
		graphics = super.getGraphics().create();
		super.paintComponents(graphics);
		graphics.drawString("Training time: "+dataPoints.values().toArray()[1].toString(), 10, 10);
		graphics.drawString("Testing time: "+dataPoints.values().toArray()[2].toString(), 10, 20);
		graphics.drawString("Accuracy percentage: "+dataPoints.values().toArray()[0].toString(), 10, 30);
	}

	/**
	 * This method takes all of the data given in the instructor,
	 * and adds them to labels which are then added to the frame specified in the constructor.
	 */
	void showResultGUI()
	{
		dataFrame.getContentPane().add(new GUIBuilder());
		dataFrame.setSize(dimensions);
		dataFrame.setVisible(true);
		dataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dataFrame.setResizable(false);
	}
}
