package com.ui.pages;

import com.ui.factory.DriverFactory;
import com.ui.utils.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private By mobileOption= By.xpath("//a[contains(text(),'Mobile')]");
    BaseActions baseActions;

    public HomePage(BaseActions baseActions) {

        this.baseActions=baseActions;
    }

    public String verifyTechPandaHomePageTitle(){
        return baseActions.getTitle();
    }

    public void clickMobileOption(){
        baseActions.elementClick(mobileOption);
    }
}
