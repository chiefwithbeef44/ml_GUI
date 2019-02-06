package com.csp;

import com.csp.clusterer_classifier.FarthestFirstClusterer;
import com.csp.clusterer_classifier.KMeansClusterer;
import com.csp.reader_loader.fileReader;
import com.csp.reader_loader.loadData;
import weka.core.Instances;

public class ClusterMain
{
	static FarthestFirstClusterer FFCluster;
	static KMeansClusterer KMCluster;
	static fileReader reader = new fileReader();
	static loadData data = new loadData();

	public static void main(String[] args) throws Exception
	{
		Instances test;
		Instances train;
		FFCluster = new FarthestFirstClusterer(10);
		KMCluster = new KMeansClusterer(10);
		loadData.setTempPath();
		test = reader.readFile(data.test);
		train = reader.readFile(data.train);
		Eval.evalCluster(KMCluster.clusterer, train, test);
		Eval.evalCluster(FFCluster.clusterer, train, test);
	}
}
