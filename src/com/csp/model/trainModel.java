package com.csp.model;

import weka.core.Instances;

public class trainModel extends createModel
{
    private int i = 0;
    public double[] outputs = new double[42000];
    private double output = 0;
    public void train(Instances instances) throws Exception
    {
        while(i<instances.numAttributes())
        {
            output = optimizer.SVMOutput(instances.get(i));
            outputs[i] = output;
            i++;
        }
    }
}
