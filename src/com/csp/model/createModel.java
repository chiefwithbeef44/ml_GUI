package com.csp.model;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class createModel
{
    public NaiveBayes bayes = new NaiveBayes();
    public void createModel(Instances instances) {
        try
        {
            bayes.buildClassifier(instances);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
