package com.csp.model;


import org.w3c.dom.Element;
import weka.classifiers.pmml.consumer.SupportVectorMachineModel;
import weka.classifiers.pmml.producer.LogisticProducerHelper;
import weka.core.Instances;
import weka.core.pmml.MiningSchema;
import weka.core.pmml.jaxbbindings.PMML;
import weka.core.pmml.jaxbbindings.SupportVectorMachine;
import weka.core.pmml.jaxbbindings.SupportVectors;

import java.math.BigInteger;

public class Model
{
     private SupportVectorMachine svm = new SupportVectorMachine();
     private SupportVectors supportVectors = new SupportVectors();
     private SupportVectorMachineModel svmModel;
     private MiningSchema schema;
     public Element element;
     private PMML pmml = new PMML();
     double[][] par = new double[10][10];

        public  void create(Instances instances)
        {
            par[0][0] = instances.kthSmallestValue(1, 1);
            LogisticProducerHelper.toPMML(instances,instances,par,1);
            pmml = LogisticProducerHelper.initPMML();
            element = (Element);
            System.out.println(element);
            try {
                schema = new MiningSchema(element, instances, schema.getTransformationDictionary());
                svmModel = new SupportVectorMachineModel(element, instances, schema);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        public  void train(Instances instances)
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
