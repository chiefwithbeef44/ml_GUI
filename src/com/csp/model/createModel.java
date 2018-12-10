package com.csp.model;

import weka.classifiers.functions.SMOreg;
import weka.classifiers.functions.supportVector.RegOptimizer;
import weka.classifiers.functions.supportVector.RegSMOImproved;
import weka.core.Instances;

public class createModel
{
    SMOreg reg = new SMOreg();
    RegOptimizer optimizer = reg.getRegOptimizer();
    RegSMOImproved smoImproved = new RegSMOImproved();
    int seed = 10;
    public void modelMaker(Instances instances)
    {
        smoImproved.setSMOReg(reg);
        System.out.println("set SMOReg in the improved SMO alg // createModel: 16");
        optimizer.setSeed(seed);
        System.out.println("set the seed to "+seed+"// createModel: 18");
        reg.setRegOptimizer(optimizer);
        System.out.println("set the SMOreg to the optimizer // createModel: 20");
        optimizer.setSMOReg(reg);
        System.out.println("set SMOReg to the SMOReg // createModel: 22");
        try
        {
            System.out.println("building classifier // createModel: 27");
            smoImproved.buildClassifier(instances);
            System.out.println("built classifier // createModel: 27");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
