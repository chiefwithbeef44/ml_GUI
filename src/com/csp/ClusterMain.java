package com.csp;


import com.csp.clusterer_classifier.FarthestFirstClusterer;
import com.csp.clusterer_classifier.KMeansClusterer;
import com.csp.reader_loader.fileReader;
import com.csp.reader_loader.loadData;
import weka.core.Instances;

/**
 * @author Sam Blake
 * This class is the same thing as the other main class, but it will run with both clustering algorithms instead of KNN.
 */
public class ClusterMain
{
	private static FarthestFirstClusterer FFCluster;
	private static KMeansClusterer KMCluster;
	private static fileReader reader = new fileReader();
	private static loadData data = new loadData();

	/**
	 * This is the main function, it runs everything for evaluation of clustering algorithms.
	 * This method evaluates the FarthestFirst and KMeans clusterers.
	 * @param args necessary for proper main method declaration
	 * @throws Exception thrown by the evalCluster method and the clusterer constructors
	 */
	public static void main(String[] args) throws Exception
	{
		data.inputPath();
		Instances test;
		Instances train;
		FFCluster = new FarthestFirstClusterer(10);
		KMCluster = new KMeansClusterer(10);
		data.inputPath();
		test = reader.readFile(data.test);
		train = reader.readFile(data.train);
		Eval.evalCluster(KMCluster.clusterer, train, test);
		Eval.evalCluster(FFCluster.clusterer, train, test);
	}
}
