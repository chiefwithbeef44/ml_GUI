package com.csp.model;

import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.core.Attribute;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.Normalize;

/**
 * @author Samuel Blake
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
	private IBk knn;
	public Classifier classifier = knn;

	/**
	 * This is the constructor for the KNNModel class. It is necessary for normalizing the data and  setting the classAttribute.
	 * For each data set, the input format is set and then the data normalized.
	 * Then, the label attribute is got from the data and set.
	 * Note: Using the MNIST data set, and this constructor, training takes ~0.05s
	 * @param train The instances of the training data.
	 * @param test the instances of the testing data
	 * @param index the index of the attribute to be set
	 * @param k the k value for the constructor of IBk
	 * @throws Exception thrown by normalization methods setInputFormat and useFilter
	 */
	public KNNModel(Instances train, Instances test, double index, int k) throws Exception
    {
    	System.out.println("K value: " + k);
    	knn = new IBk(k);
    	classifier = knn;
    	//Normalizes test data
		Normalize norm = new Normalize();
		norm.setInputFormat(test);
        this.test = Normalize.useFilter(test, norm);
        //normalizes train data
        norm.setInputFormat(train);
        this.train = Normalize.useFilter(train, norm);
        //sets the class to the "label" tag
        test.setClass(test.attribute((int)index));
        train.setClass(train.attribute((int)index));
		Attribute trainAttr = train.attribute((int)index);
		this.train.setClass(trainAttr);
		Attribute testAttr = test.attribute((int)index);
		this.test.setClass(testAttr);
    }

	/**
	 * The same as the other constructor but can select the attribute and it does not normalize the data.
	 * It is vital that the class is constructed either with this or the other constructor when put into use.
	 * Note: Using the MNIST data set, accuracy is around 94.8% (for k=1 , default value) and training is ~0.5s
	 * @param train is the training data that is to be manipulated 
	 * @param test is the testing data that is to be manipulated
	 * @param index is the index of the attribute to be selected.
	 */
	public KNNModel(Instances train, Instances test, int index)
	{
		knn = new IBk();
		classifier = knn;
		this.test = test;
		this.train = train;
		//sets the class to the "label" tag
		test.setClass(test.attribute(index));
		train.setClass(train.attribute(index));
		Attribute trainAttr = train.attribute(index);
		this.train.setClass(trainAttr);
		Attribute testAttr = test.attribute(index);
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
	 * @return double the predictions of the classifier
	 * @throws Exception due to the exception throwm by the classifyInstance method.
	 */
	@Deprecated
    public double[] test() throws Exception
    {
    	//Number of outputs, creates an array
        double[] outputs = new double[this.train.numInstances()+1];
        //iterates through the instances classifying them
        for(int index = 0; index<=this.train.numInstances()-1; index++)
        {
        	System.out.println("classifying instance " + index);
            outputs[index] = classifier.classifyInstance(this.train.get(index));
            System.out.println(outputs[index]);
        }
        return outputs;
    }
}
