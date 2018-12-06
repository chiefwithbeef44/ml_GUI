package com.csp;

import weka.clusterers.SimpleKMeans;

import java.io.File;
public class dataClusterer
{
    fileReader reader;
    SimpleKMeans kMeans;
    public void clusterer(File file)
    {
        kMeans = new SimpleKMeans();
        reader = new fileReader();
        System.out.println("Successfully instantiated kMeans // dataClusterer.clusterer:12");
        kMeans.setSeed(10);
        System.out.println("Successfully set kMeans seed // dataClusterer.clusterer:14");
        kMeans.setPreserveInstancesOrder(true);
        System.out.println("Successfully set kMeans to preserve instance order // dataClusterer.clusterer:16");
        try {
            kMeans.setNumClusters(10);
            System.out.println("Successfully set # of clusters to 10");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            kMeans.buildClusterer(reader.readFile(file));
            System.out.println("successfully built clusterer");
        } catch (Exception e) {
            e.printStackTrace();
        }
        kMeans.getClusterCentroids();
        System.out.println("successfully got cluster centroids");
        int[] assignments = new int[0];

        try {
            assignments = kMeans.getAssignments();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i=0;
        for(int clusterNum : assignments) {
            System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
            i++;
        }
    }
}
