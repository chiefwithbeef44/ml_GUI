package com.csp.model;

import weka.core.Instances;

public class trainModel extends createModel
{
    public void train(Instances instances)
    {
        int i = 0;
        while(i<=instances.numAttributes())
        {
            i++;
            try {
                System.out.println(optimizer.SVMOutput(instances.get(i)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
