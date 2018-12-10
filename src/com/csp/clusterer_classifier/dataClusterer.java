package com.csp.clusterer_classifier;

import weka.clusterers.SimpleKMeans;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class dataClusterer
{
    private int seed = 10;
    private boolean preserveOrder = true;
    private BufferedReader readDataFile(String filename)
    {
        BufferedReader inputReader = null;

        try
        {
            inputReader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + filename);
        }

        return inputReader;
    }

    public Instances clusterFile(File file) throws Exception
    {
        SimpleKMeans kmeans = new SimpleKMeans();
        System.out.println("instantiated simpleKMeans clusterer // dataClusterer:31");

        kmeans.setSeed(seed);
        System.out.println("set KMeans seed to"+seed+"dataClusterer:34");

        //important parameter to set: preserver order, number of cluster.
        kmeans.setPreserveInstancesOrder(preserveOrder);
        System.out.println("KMeans set to preserve order? " + preserveOrder );
        kmeans.setNumClusters(10);
        System.out.println("set num of clusters to 10 // dataClusterer:40");

        BufferedReader datafile = readDataFile(file.getAbsolutePath());
        System.out.println("bufferedreader is reading file // dataClusterer: 43");
        Instances data = new Instances(datafile);
        System.out.println("instantiates data // dataClusterer:45");
        kmeans.buildClusterer(data);
        System.out.println("built cluster // dataClusterer:47");
        // This array returns the cluster number (starting with 0) for each instance
        // The array has as many elements as the number of instances
        int[] assignments = kmeans.getAssignments();

        int i=0;
        for(int clusterNum : assignments)
        {
            //System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
            i++;
        }
        return data;
    }
    public Instances clusterInstances(Instances instances) throws Exception
    {
        SimpleKMeans kmeans = new SimpleKMeans();

        kmeans.setSeed(10);

        //important parameter to set: preserver order, number of cluster.
        kmeans.setPreserveInstancesOrder(true);
        kmeans.setNumClusters(10);

        Instances data = new Instances(instances);

        kmeans.buildClusterer(data);

        // This array returns the cluster number (starting with 0) for each instance
        // The array has as many elements as the number of instances
        int[] assignments = kmeans.getAssignments();

        int i = 0;
        for (int clusterNum : assignments)
        {
            //System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
            i++;
        }
        return data;
    }
}