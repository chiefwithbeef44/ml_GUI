package com.csp.model;

import org.w3c.dom.Element;
import weka.classifiers.pmml.consumer.SupportVectorMachineModel;
import weka.core.Instances;
import weka.core.pmml.MiningSchema;


public class createModel
{
    SupportVectorMachineModel svm;
    Element element;
    MiningSchema schema;

    public void createModel(Instances instances)
    {
        try {
            schema = new MiningSchema(element, instances, schema.getTransformationDictionary());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            svm = new SupportVectorMachineModel(element, instances, schema);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
                svm.distributionForInstance(instances.get(10));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
