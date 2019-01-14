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
import java.util.Arrays;

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
                 svmModel.setPMMLVersion(doc);
                 svmModel.setNumDecimalPlaces(0);
                 svmModel.setBatchSize("10");
                 svmModel.setCreatorApplication(doc);

             } catch (Exception e)
             {
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
         svm.setTargetCategory("label");
         coefficients.setAbsoluteValue(2.0);
         coefficients.setNumberOfCoefficients(numAttributes);
         svm.setCoefficients(coefficients);

         while(i<=41999)
         {
             try
             {
                 svmModel.buildClassifier(instances);
                 double[] outputs = svmModel.distributionForInstance(instances.get(i));
                 System.out.println(Arrays.toString(outputs));
             } catch (Exception e)
             {
                 e.printStackTrace();
             }
             i++;
         }
     }
}
