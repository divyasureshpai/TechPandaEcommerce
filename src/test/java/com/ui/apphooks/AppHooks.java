package com.ui.apphooks;

import com.ui.factory.DriverFactory;
import com.ui.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.Properties;

public class AppHooks {

    private ConfigReader configReader;
    private Properties properties;
    private DriverFactory driverFactory;


    @Before
    public void launchAUT(){
        properties=new Properties();
        configReader=new ConfigReader(properties);
        driverFactory=new DriverFactory(configReader.getProperties("browser"));
        if(DriverFactory.getDriver()==null){

        }
        DriverFactory.getDriver().get(configReader.getProperties("AUT"));
    }
    @After(value="@uitest")
    public void shutdown(){


        DriverFactory.getDriver().quit();
    }
}
