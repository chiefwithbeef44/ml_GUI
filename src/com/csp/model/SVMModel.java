package com.csp.model;

import weka.core.Instances;
import weka.filters.unsupervised.attribute.Normalize;

public class SVMModel extends AbstractModel
{
	private Normalize norm = new Normalize();
	private Instances train;
	private Instances test;

	public SVMModel(Instances train, Instances test) throws Exception
	{
		norm.setInputFormat(test);
		this.test = Normalize.useFilter(test,norm);
		norm.setInputFormat(train);
		this.train = Normalize.useFilter(train, norm);
		test.setClass(test.attribute(0));
		train.setClass(train.attribute(0));
	}
	public void create(){}

	@Override
	public double[] train()
	{
		double[] output = new double[train.numInstances()+1];
		for(int i = 0; i<=train.numInstances(); i++)
		{

		}
		return output;
	}
}
