package com.csp.model;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import weka.classifiers.pmml.consumer.SupportVectorMachineModel;
import weka.core.Instances;
import weka.core.pmml.MiningSchema;
import weka.core.pmml.jaxbbindings.*;

import java.math.BigInteger;

public class Model
{
     public Node node;
     private SupportVectorMachine svm = new SupportVectorMachine();
     private SupportVectors supportVectors = new SupportVectors();
     private SupportVectorMachineModel svmModel;
     private MiningSchema schema;
     public Element element;
     public PMML pmml = new PMML();
        public  void create(Instances instances)
        {
            node = element;
            element = (Element) node;
//            try {
//                schema = new MiningSchema(element, instances, schema.getTransformationDictionary());
//                svmModel = new SupportVectorMachineModel(element, instances, schema);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
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
