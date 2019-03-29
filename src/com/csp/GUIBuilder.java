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
	private static HashMap<String, Double> dataPoints;
	private static Dimension dimensions;
	private static String name;

	/**
	 * This constructor sets all the local variables
	 * @param data this should be the same HashMap returned by the evaluation method in the Eval class
	 * @param height height, in px
	 * @param width width in px
	 * @param name the name of JFrame to be used as the results
	 */
	GUIBuilder(HashMap<String, Double> data, int height, int width, String name)
	{
		super();
		dataPoints = data;
		dimensions = new Dimension(width, height);
		GUIBuilder.name =  name;
	}

	/**
	 * blank constructor for the showResultGUI() method
	 */
	private GUIBuilder() {}

	/**
	 * This method is the core of this class. It writes all of the text to the jFrame.
	 * @param graphics necessary to override the method in the superclass and draw correctly.
	 */
	@Override
	public void paint(Graphics graphics)
	{
		graphics.drawString("Training time: "+dataPoints.values().toArray()[1].toString(), 10, 10);
		graphics.drawString("Testing time: "+dataPoints.values().toArray()[2].toString(), 10, 30);
		graphics.drawString("Accuracy percentage: "+dataPoints.values().toArray()[0].toString(), 10, 50);
	}

	/**
	 * This method takes all of the data given in the instructor,
	 * and adds them to labels which are then added to the frame specified in the constructor.
	 */
	public static void main(String[] args)
	{
		JFrame dataFrame = new JFrame(name);
		dataFrame.getContentPane().add(new GUIBuilder());
		dataFrame.setSize(dimensions);
		dataFrame.setVisible(true);
		dataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dataFrame.setResizable(false);
	}
}
