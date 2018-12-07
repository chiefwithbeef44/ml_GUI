package com.csp.clusterer_classifier;

import weka.clusterers.SimpleKMeans;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class dataClusterer
{

    public BufferedReader readDataFile(String filename)
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

        kmeans.setSeed(10);

        //important parameter to set: preserver order, number of cluster.
        kmeans.setPreserveInstancesOrder(true);
        kmeans.setNumClusters(10);

        BufferedReader datafile = readDataFile(file.getAbsolutePath());
        Instances data = new Instances(datafile);

        kmeans.buildClusterer(data);

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