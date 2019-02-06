package com.csp.clusterer_classifier;

import weka.clusterers.Clusterer;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;

/**
 * @author Samuel Blake
 * Class is a simple KMeans clusterer of the instances as a machine learning method.
 */

//Clusters the instances with k-means clustering

public class KMeansClusterer extends AbstractClusterer
{
    private SimpleKMeans kmeans = new SimpleKMeans();
    public Clusterer clusterer = kmeans;

    /**
     * This constructor sets all the options for the KMeans algorithm necessary to run.
     * @throws Exception due to the setNumClusters method
     */
    public KMeansClusterer(int numClusters) throws Exception
    {
        kmeans.setSeed(10);
        kmeans.setPreserveInstancesOrder(true);
        kmeans.setNumClusters(numClusters);
    }

    /**
     * This method classifies all instances in the input parameter and returns the cluster they belong to.
     * @param instances the instances are the input to be classified.
     * @return int[] of the classified instances and what cluster they belong to
     * @throws Exception thrown by buildClusterer and clusterInstance
     */
    public int[] classifyInstances(Instances instances) throws Exception
    {
        kmeans.buildClusterer(instances);
        int[] classified = new int[instances.numInstances()+1];
        for (int i = 0; i<instances.numInstances(); i++)
        {
                classified[i] = kmeans.clusterInstance(instances.get(i));
                System.out.println(classified[i]);
        }

        return classified;
    }
}