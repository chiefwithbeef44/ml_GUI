package com.csp.model;


import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultDocument;
import org.w3c.dom.Document;
import weka.classifiers.pmml.consumer.SupportVectorMachineModel;
import weka.core.Instances;
import weka.core.pmml.MiningSchema;
import weka.core.pmml.jaxbbindings.Coefficients;
import weka.core.pmml.jaxbbindings.SupportVectorMachine;
import weka.core.pmml.jaxbbindings.SupportVectors;

import java.math.BigInteger;

public class Model
{
     private SupportVectorMachine svm = new SupportVectorMachine();
     private SupportVectors supportVectors = new SupportVectors();
     private SupportVectorMachineModel svmModel;
     private MiningSchema schema;
     private Coefficients coefficients = new Coefficients();

    public  void create(Instances instances)
    {
         assert instances != null;
         Document doc = new DefaultDocument();
             try
             {
                 schema = new MiningSchema(doc.createElement("label"), instances, schema.getTransformationDictionary());
                 svmModel = new SupportVectorMachineModel(doc.createElement("label"), instances, schema);

             } catch (Exception e)
             {
                 e.printStackTrace();
             }
         }

     public  void train(Instances instances)
     {
         BigInteger numAttributes = BigInteger.valueOf(785);
         supportVectors.setNumberOfAttributes(numAttributes);
         supportVectors.setNumberOfSupportVectors(BigInteger.valueOf(10));
         svm.setSupportVectors(supportVectors);
         svm.setTargetCategory("label");
         coefficients.setAbsoluteValue(2.0);
         coefficients.setNumberOfCoefficients(numAttributes);
         svm.setCoefficients(coefficients);
         try
         {
             svmModel.buildClassifier(instances);
             System.out.println("classifier built");
         } catch (Exception e)
         {
             e.printStackTrace();
         }
     }
}
