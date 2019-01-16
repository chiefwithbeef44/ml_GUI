package com.csp.model;

import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.RBFKernel;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.Normalize;

/**
 * @author chiefwithbeef44
 */
public class Model
{
    private SMO smo = new SMO();
    private Instances train;
    private Instances test;
    private Normalize norm = new Normalize();

    public Model(Instances train, Instances test) throws Exception
        {
        norm.setInputFormat(test);
        this.test = Normalize.useFilter(test,norm);
        norm.setInputFormat(train);
        this.train = Normalize.useFilter(train, norm);
        smo.setKernel(new RBFKernel(train, 1, 0.015625));
        smo.setC(8.0);

    }

    public  void create() throws Exception
    {
            train.setClassIndex(train.numAttributes()-1);
            System.out.println("Model has begun creation // Model: 23");
            smo.buildClassifier(train);
            System.out.println("Model created! // Model: 26");
    }
}
