package com.csp.clusterer_classifier;

import weka.clusterers.FarthestFirst;
import weka.core.Instances;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Samuel Blake
 * This class is a FarthestFirst clusterer.
 * Deprecated as clusterers are not in use in the program.
 */
@Deprecated
public class FarthestFirstClusterer extends AbstractClusterer
{
	private FarthestFirst farthestFirst = new FarthestFirst();

	/**
	 * The constructor for this class.
	 * It sets the number of clusters to
	 * @param numClusters the number of clusters to be created.
	 * @throws Exception thrown by the setNumClusters method.
	 */
	public FarthestFirstClusterer(int numClusters) throws Exception
	{
		farthestFirst.setNumClusters(numClusters);
		farthestFirst.setSeed(ThreadLocalRandom.current().nextInt());
	}

	/**
	 * This method classifies the instances input
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
