package com.csp.clusterer_classifier;

import com.csp.reader_loader.fileReader;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;

public class dataClusterer
{
    fileReader reader;
    SimpleKMeans kMeans;
    public void clusterer(Instances file) throws Exception
    {
        kMeans = new SimpleKMeans();
        reader = new fileReader();
        System.out.println("Successfully instantiated kMeans // dataClusterer.clusterer:12");
        kMeans.setSeed(10);
        System.out.println("Successfully set kMeans seed // dataClusterer.clusterer:14");
        kMeans.setPreserveInstancesOrder(true);
        System.out.println("Successfully set kMeans to preserve instance order // dataClusterer.clusterer:16");
        kMeans.setNumClusters(10);
        System.out.println("Successfully set # of clusters to 10");
        kMeans.buildClusterer(file);
        System.out.println("successfully built clusterer");
        kMeans.getClusterCentroids();
        System.out.println("successfully got cluster centroids");
        int[] assignments = new int[0];

        assignments = kMeans.getAssignments();
        int i=0;
        for(int clusterNum : assignments) {
            System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
            i++;
        }
    }
}
