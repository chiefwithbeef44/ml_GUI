package com.csp.model;

import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.core.Attribute;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.Normalize;

/**
 * @author chiefwithbeef44
 */

public class KNNModel extends AbstractModel
{
	//data vars used in constructor
    public Instances train;
    public Instances test;
    //Normalizes the data
	private Normalize norm = new Normalize();
	//KNN model
	private IBk knn = new IBk(4);
	public Classifier classifier = knn;

	public KNNModel(Instances train, Instances test) throws Exception
    {
    	//Normalizes test data
        norm.setInputFormat(test);
        this.test = Normalize.useFilter(test,norm);
        //normalizes train data
        norm.setInputFormat(train);
        this.train = Normalize.useFilter(train, norm);
        //sets the class to the "label" tag
        test.setClass(test.attribute(0));
        train.setClass(train.attribute(0));
		Attribute attr = train.attribute("label");
		this.train.setClass(attr);
    }

    public void create() throws Exception
	{
		System.out.println("Creating model");
		//trains the model and builds the classifier
    	classifier.buildClassifier(train);
    	System.out.println("Model created!");
	}

    public double[] train() throws Exception
    {
    	//Number of outputs, creates an array
        double[] outputs = new double[this.train.numInstances()+1];
        //iterates through the instances classifying them
        for(int i = 0; i<=this.train.numInstances()-1; i++)
        {
        	System.out.println("classifying instance " + i);
            outputs[i] = classifier.classifyInstance(this.train.get(i));
            System.out.println(outputs[i]);
        }
        return outputs;
    }
}
