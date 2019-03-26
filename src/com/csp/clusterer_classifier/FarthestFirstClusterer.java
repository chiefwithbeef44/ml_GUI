package com.csp.clusterer_classifier;

import weka.clusterers.Clusterer;
import weka.clusterers.FarthestFirst;
import weka.core.Instances;

/**
 * @author Samuel Blake
 * This class is a FarthestFirst clusterer.
 */
public class FarthestFirstClusterer extends AbstractClusterer
{
	private final FarthestFirst farthestFirst = new FarthestFirst();
	public final Clusterer clusterer = farthestFirst;

	/**
	 * The constructor for this class.
	 * It sets the number of clusters to
	 * @param numClusters the number of clusters to be created.
	 * @throws Exception thrown by the setNumClusters method.
	 */
	public FarthestFirstClusterer(int numClusters) throws Exception
	{
		farthestFirst.setNumClusters(numClusters);
		farthestFirst.setSeed(10);
	}

	/**
	 * This method classifies the instances input.
	 * @param instances the instances are the input to be classified.
	 * @return int[] the classifier outputs of the clusterer
	 * @throws Exception thrown by clusterInstance
	 */
	public int[] classifyInstances(Instances instances) throws Exception
	{
		farthestFirst.buildClusterer(instances);
		int[] classified = new int[instances.numInstances()+1];
		for (int i = 0; i<instances.numInstances(); i++)
		{
			classified[i] = farthestFirst.clusterInstance(instances.get(i));
		}
		return classified;
	}
}
