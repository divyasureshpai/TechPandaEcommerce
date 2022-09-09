package com.ui.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader(Properties properties) {
        this.properties = properties;
        try{
            FileInputStream fileInputStream=new FileInputStream("src/test/resources/config/config.properties");
            this.properties.load(fileInputStream);
        }
       catch (Exception e){
            System.err.println("Exception occured while loading properties"+e);
       }
    }

    public String getProperties(String key) {
        return properties.getProperty(key);
    }
}
