package com.csp.model;

import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.core.Attribute;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.Normalize;

/**
 * @author chiefwithbeef44
 * This file is the class containing the model used by the evaluation method found in Eval.
 * In the constructor the arguments are the Instances attained from the fileReader.readFile(File file) method.
 * There is then a normalization filter put on the data to make predictions and training more accurate.
 * Both the training and the test data sets are passed through the normalization filter, then the train and test data attributes are set.
 * They are set to the "label" tag, with the 0 index. The label tag is the digit that the data represents.
 * Both create and test methods are deprecated due to the use of the eval method found in the Eval class.
 * The IBk var knn contains the KNN classifier, with the K value set to four.
 * The Classifier var is set to knn, which is instantiated as the KNN.
 */
public class KNNModel extends AbstractModel
{
	//data vars used in constructor
    public Instances train;
    public Instances test;
	//KNN model
	private IBk knn = new IBk(4);
	public Classifier classifier = knn;

	public KNNModel(Instances train, Instances test) throws Exception
    {
    	//Normalizes test data
		Normalize norm = new Normalize();
		norm.setInputFormat(test);
        this.test = Normalize.useFilter(test, norm);
        //normalizes train data
        norm.setInputFormat(train);
        this.train = Normalize.useFilter(train, norm);
        //sets the class to the "label" tag
        test.setClass(test.attribute(0));
        train.setClass(train.attribute(0));
		Attribute trainAttr = train.attribute(0);
		this.train.setClass(trainAttr);
		Attribute testAttr = test.attribute(0);
		this.test.setClass(testAttr);
    }

	/**
	 * In create, the classification model is created.
	 * The method in the Classifier var is used.
	 * The time is measured in ms and is used to measure time to create the model.
	 * This method uses the data that is manipulated in the class constructor, and therefor it is vital that the class be instantiated.
	 * @throws Exception due to the exception thrown by the buildClassifier method.
	 */
	@Deprecated
    public void create() throws Exception
	{
		System.gc();
		System.out.println("Creating model");
		long start = System.currentTimeMillis();
		//trains the model and builds the classifier
    	classifier.buildClassifier(train);
		long end = System.currentTimeMillis();
		System.gc();
		System.out.println("Model created in " +(start-end) +" milliseconds");
	}

	/**
	 * The test method uses the data that is manipulated in the class constructor and it is therefor vital that this class be instantiated.
	 * The double variable outputs is set to a new double with the array length the same of the train instances+1 (to avoid an IndexOutOfBoundsException)
	 * The loop then iterates through each instance and classifies it, assigns is to the proper index, then prints the prediction.
	 * @return double
	 * @throws Exception due to the exception throwm by the classifyInstance method.
	 */
	@Deprecated
    public double[] test() throws Exception
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
