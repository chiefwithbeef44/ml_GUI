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
    private Instances train;
    private Instances test;
	private Normalize norm = new Normalize();
	private IBk knn = new IBk(4);
	public Classifier classifier = knn;

	public KNNModel(Instances train, Instances test) throws Exception
    {
        norm.setInputFormat(test);
        this.test = Normalize.useFilter(test,norm);
        norm.setInputFormat(train);
        this.train = Normalize.useFilter(train, norm);
        test.setClass(test.attribute(0));
        train.setClass(train.attribute(0));
        knn.setNumDecimalPlaces(0);
		Attribute attr = train.attribute("label");
		this.train.setClass(attr);
		this.train.setClassIndex(0);
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
            System.out.println(outputs[i]);
        }
        return outputs;
    }
}
