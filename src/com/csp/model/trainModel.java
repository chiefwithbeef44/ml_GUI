package com.csp.model;

import weka.core.Instances;

import java.util.Random;

public class trainModel
{
    private createModel model = new createModel();
    private Random rand = new Random();
    private int i = 0;
    public double[] outputs = new double[42000];
    private double output = 0;
    public void train(Instances instances) throws Exception
    {
        instances = instances.resampleWithWeights(rand);

        while(i<instances.numAttributes())
        {
            output = model.smoImproved.SVMOutput(instances.get(i));
            outputs[i] = output;
            i++;
        }
    }
}
