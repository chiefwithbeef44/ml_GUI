package com.csp;

import weka.core.converters.ArffLoader;

import java.io.File;

public class fileReader
{
    private ArffLoader.ArffReader reader;
    int fileString;

    public void readFile(File file)
    {
        try {
            fileString = reader.getLineNo();
        }catch (NullPointerException e){
            e.getCause();
            System.out.println(e);
        }
        System.out.println(fileString);
    }
}
