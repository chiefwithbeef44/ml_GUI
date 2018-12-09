package com.csp.model;

import weka.classifiers.functions.SMOreg;
import weka.classifiers.functions.supportVector.RegOptimizer;
import weka.classifiers.functions.supportVector.RegSMOImproved;
import weka.core.Instances;

public class createModel
{
    SMOreg reg = new SMOreg();
    RegSMOImproved smoImproved = new RegSMOImproved();
    RegOptimizer optimizer = reg.getRegOptimizer();
    public void createModel(Instances instances)
    {
        optimizer.setSeed(10);
        optimizer.setSMOReg(reg);
        try {
            smoImproved.buildClassifier(instances);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
