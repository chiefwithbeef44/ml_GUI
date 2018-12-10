package com.csp.model;

import org.w3c.dom.Element;
import weka.classifiers.pmml.consumer.SupportVectorMachineModel;
import weka.core.Instances;
import weka.core.pmml.MiningSchema;
import weka.core.pmml.jaxbbindings.SupportVectorMachine;
import weka.core.pmml.jaxbbindings.SupportVectors;

import java.math.BigInteger;

public class Model
{

    static SupportVectorMachine svm = new SupportVectorMachine();
    static SupportVectors supportVectors = new SupportVectors();
    static SupportVectorMachineModel svmModel;
    static MiningSchema schema;
    static Element element;
    public static class CreateModel
    {
        public static void create(Instances instances)
        {
            try {
                svmModel = new SupportVectorMachineModel(element, instances, schema);
                schema = new MiningSchema(element, instances, schema.getTransformationDictionary());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class trainModel
    {
        public static void train(Instances instances)
        {
            BigInteger numAttributes = BigInteger.valueOf(785);
            int i = 0;
            supportVectors.setNumberOfAttributes(numAttributes);
            supportVectors.setNumberOfSupportVectors(BigInteger.valueOf(10));
            svm.setSupportVectors(supportVectors);

            while(i<42000){
                try
                {
                    svmModel.distributionForInstance(instances.get(i));
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }
}
