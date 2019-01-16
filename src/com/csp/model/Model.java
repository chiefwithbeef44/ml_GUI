package com.csp.model;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Instances;

public class Model
{
    private SMO smo = new SMO();
    private Evaluation eval;

    public  void create(Instances instances)
    {

    }

    public  void train(Instances instances) throws Exception
    {
        instances.setClassIndex(instances.numAttributes()-1);
        eval = new Evaluation(instances);
        smo.buildClassifier(instances);
     }
}
