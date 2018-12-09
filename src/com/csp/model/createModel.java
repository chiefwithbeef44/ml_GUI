package com.csp.model;

import org.w3c.dom.Element;
import weka.classifiers.pmml.consumer.SupportVectorMachineModel;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.pmml.MiningSchema;
import weka.core.pmml.jaxbbindings.TransformationDictionary;

public class createModel
{
    SupportVectorMachineModel svm;
    Instance data;
    MiningSchema schema;
    TransformationDictionary dictionary;
    Element element;
    public void createModel(Instances instances)

    {
        dictionary  = new TransformationDictionary();;
        try {
            schema = new MiningSchema(element, instances, dictionary);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assert schema != null;
            svm = new SupportVectorMachineModel(element, instances, schema);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
                svm.distributionForInstance(instances.get((int) Math.random()));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
