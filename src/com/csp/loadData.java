package com.csp;

import weka.core.FileHelper;
import weka.core.converters.ArffLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class loadData
{
    //loader for data from Weka package
    ArffLoader loader = new ArffLoader();
    FileHelper helper = new FileHelper();
    File dataLoaded;

    public Path trainPath = Paths.get("train.arff");
    public Path testPath = Paths.get("test.arff");

    public static class cmd
    {
        public String find(Path path) throws Exception
        {
            ProcessBuilder builder = new ProcessBuilder
                    ("cmd.exe", "dir " + path.toString() + "/s");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while(p.isAlive()) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            return line;
        }
    }

    public File helpTrain()
    {
        dataLoaded = helper.getFile();
        return dataLoaded;
    }
    public void trainData(File data)
    {
        try
        {
            loader.setFile(data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public File helpTest()
    {
        dataLoaded = helper.getFile();
        return dataLoaded;
    }
    public void testData(File data)
    {
        try
        {
            loader.setFile(data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
