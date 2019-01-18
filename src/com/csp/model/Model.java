package com.csp.model;

import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;

import weka.filters.unsupervised.attribute.Normalize;

/**
 * @author chiefwithbeef44
 */

public class Model
{
    private Instances train;
    private Instances test;
	private Normalize norm = new Normalize();
	private IBk knn = new IBk();
	private Classifier classifier = knn;

    public Model(Instances train, Instances test) throws Exception
    {
        norm.setInputFormat(test);
        this.test = Normalize.useFilter(test,norm);
        norm.setInputFormat(train);
        this.train = Normalize.useFilter(train, norm);
    }

    public void create() throws Exception
	{
		System.out.println("Creating model // Model: 32");
    	classifier.buildClassifier(train);
    	System.out.println("Model created!");
	}

    public double[] train() throws Exception
    {
        double[] outputs = new double[this.train.numInstances()+1];
        for(int i = 0; i<=this.train.numInstances()-1; i++)
        {
        	System.out.println("classifying instance " + i);
            outputs[i] = classifier.classifyInstance(this.train.get(i));
        }
        return outputs;
    }
}
