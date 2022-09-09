package com.ui.pages;

import com.ui.context.ProductContext;
import com.ui.factory.DriverFactory;
import com.ui.utils.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MobileDetailsPage {

    private BaseActions baseActions;
    private ProductContext productContext;
    private WebDriver driver;

    private By prodPrice=By.xpath("//span[@class='price']");
    private By prodName=By.xpath("//div[@class='product-name']//span");

    public MobileDetailsPage(ProductContext productContext, BaseActions baseActions) {

        this.baseActions=baseActions;
        driver= DriverFactory.getDriver();
        this.productContext=productContext;
    }


    public String verifyProductDetailsPageTitle(){

        return baseActions.getTitle();
    }

    public boolean verifyProductPrice(){

        return productContext.getProductContext(baseActions.getText(prodName)).equals(baseActions.getText(prodPrice));
    }

}
