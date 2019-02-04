package com.csp.clusterer_classifier;

import weka.core.Instances;

/**
 * @author Samuel Blake
 * This class is the parent class of all classes in the clusterer_classifier package.
 * It forces a classifyInstances method.
 */
public abstract class AbstractClusterer
{
	/**
	 * @param instances the instances are the input to be classified.
	 * @return int[] var that
	 * @throws Exception due to the buildClassifier method necessary for classification.
	 */
	public abstract int[] classifyInstances(Instances instances) throws Exception;
}
