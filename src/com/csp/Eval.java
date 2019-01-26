package com.csp;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
/**
 * @author Edward Raff
 * @author chiefwithbeef44
 */
public class Eval
{
	public static void evaluate(Classifier wekaModel, Instances train, Instances test) throws Exception
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
			System.out.println("\tEvaluation took " + (end - start) / 1000.0 + " seconds with an error percentage of "
					+ eval.errorRate());
			System.gc();
	}
}
