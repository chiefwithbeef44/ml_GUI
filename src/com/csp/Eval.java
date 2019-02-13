package com.csp;

/*
 * Copyright (C) 2015 Edward Raff
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.Clusterer;
import weka.core.Instances;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Edward Raff original code author, modified to show accuracy in percentage.
 * @author Samuel Blake edited the code lightly, added cluster evaluation method.
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
	public static HashMap<String, Double> evaluate(Classifier wekaModel, Instances train, Instances test) throws Exception
	{
			long start;
			long end;
			System.gc();
			start = System.currentTimeMillis();
			wekaModel.buildClassifier(train);
			end = System.currentTimeMillis();
			double trainTime = ((end - start) / 1000.0);
			System.out.println("\tTraining took: " + trainTime);

			System.gc();
			Evaluation eval = new Evaluation(train);
			start = System.currentTimeMillis();
			eval.evaluateModel(wekaModel, test);
			end = System.currentTimeMillis();
			double testTime = ((end - start) / 1000.0);
			System.out.println("\tEvaluation took " + testTime + " seconds with an accuracy of: " + (100-eval.errorRate()) + "%");
			System.gc();
			HashMap<String, Double> dataPoints = new HashMap<>();
			dataPoints.put("Error rate: ", (100-eval.errorRate()));
			dataPoints.put("Train time: ", trainTime);
			dataPoints.put("Test time: ", trainTime);
			return  dataPoints;
	}

	/**
	 * This method evaluates the clusterer for error and time.
	 * @param clusterer The clusterer var to be tested.
	 * @param train the training data to build the clusterer on
	 * @param test the testing data to test the clusterer with
	 * @throws Exception thrown by buildClusterer and evaluateClusterer
	 */
	public static void evalCluster(Clusterer clusterer, Instances train, Instances test) throws Exception
	{
		long start;
		long end;
		System.gc();
		start = System.currentTimeMillis();
		clusterer.buildClusterer(train);
		end = System.currentTimeMillis();
		System.out.println("Training took: " + (end-start) + " ms");

		long begin;
		long stop;
		System.gc();
		ClusterEvaluation evaluation = new ClusterEvaluation();
		evaluation.setClusterer(clusterer);
		begin = System.currentTimeMillis();
		evaluation.evaluateClusterer(test);
		stop = System.currentTimeMillis();
		int[] errors = evaluation.getClassesToClusters();
		System.out.println("Evaluation took " + (stop-begin) + " with errors of: " + Arrays.toString(errors));
	}
}
