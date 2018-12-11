package com.csp.model;


import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import weka.classifiers.pmml.consumer.SupportVectorMachineModel;
import weka.core.Instances;
import weka.core.pmml.MiningSchema;
import weka.core.pmml.jaxbbindings.Coefficients;
import weka.core.pmml.jaxbbindings.SupportVectorMachine;
import weka.core.pmml.jaxbbindings.SupportVectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class Model
{
     private SupportVectorMachine svm = new SupportVectorMachine();
     private SupportVectors supportVectors = new SupportVectors();
     private SupportVectorMachineModel svmModel;
     private MiningSchema schema;
     private Document doc;
     private Coefficients coefficients = new Coefficients();

     public  void create(Instances instances) throws IOException, SAXException, ParserConfigurationException {
         assert instances!=null;
         DocumentBuilderFactory documentBuilderFactory = new DocumentBuilderFactoryImpl();
         DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
         assert builder != null;
         doc = builder.parse(instances.toString());
         Element element = (Element) doc;
             try
             {
                 schema = new MiningSchema(element, instances, schema.getTransformationDictionary());
                 svmModel = new SupportVectorMachineModel(element, instances, schema);
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
         while(i<=41999)
         {
             try
             {
                 svm.setSupportVectors(supportVectors);
                 svm.setTargetCategory("label");
                 svmModel.distributionForInstance(instances.get(i));
                 System.out.println(Arrays.toString(svmModel.distributionForInstance(instances.get(i))));
             } catch (Exception e)
             {
                 e.printStackTrace();
             }
             i++;
         }
     }
}
