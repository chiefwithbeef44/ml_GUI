package com.csp.model;

/**
 * @author Samuel Blake
 * AbstactModel is the parent class for all of the model classes in the model package.
 * Every class should have a create method that uses the buildClassifier method in the classifier.
 * Every model should have a traim method that returns an array of predictions.
 */
public abstract class AbstractModel
{
	public abstract double[] test() throws Exception;
	public abstract void create() throws Exception;
}
