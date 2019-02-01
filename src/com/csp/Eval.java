package com.csp;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
/**
 * @author Edward Raff
 * @author chiefwithbeef44
 * This class contains the evaluation method.
 * It is used to evaluate the model given the data in the arguments.
 * evaluate will print the time took for training and the time took for evaluation, as well as accuracy (expressed in percentage).
 */
public class Eval
{
	/**
	 * This method evaluates the model specified in the parameter wekaModel. It evaluates for time and error.
	 * @param wekaModel the classifier to be evaluated by the method. In the current use case, it is KNN.
	 * @param train the training data to be used to build the model.
	 * @param test the test data used to test the model for accuracy and speed.
	 * @return double of the error in percent.
	 * @throws Exception thrown by buildClassifier, Evaluation instantiation, and evaluateModel.
	 */
	public static double evaluate(Classifier wekaModel, Instances train, Instances test) throws Exception
	{
			long start;
			long end;
			System.gc();
			start = System.currentTimeMillis();
			wekaModel.buildClassifier(train);
			end = System.currentTimeMillis();
			System.out.println("\tTraining took: " + (end - start) / 1000.0);

			System.gc();
			Evaluation eval = new Evaluation(train);
			start = System.currentTimeMillis();
			eval.evaluateModel(wekaModel, test);
			end = System.currentTimeMillis();
			System.out.println("\tEvaluation took " + (end - start) / 1000.0 + " seconds with an accuracy of: " + (100-eval.errorRate()) + "%");
			System.gc();
			return (100-eval.errorRate());
	}
}
