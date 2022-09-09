package com.ui.pages;

import com.google.common.collect.Ordering;
import com.ui.context.ProductContext;
import com.ui.factory.DriverFactory;
import com.ui.utils.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MobilePage {

    BaseActions baseActions;
    WebDriver driver;
    ProductContext productContext;
    By sortBy= By.xpath("//select[@title='Sort By']");
    By products=By.xpath("//li[@class='item last']");

    public MobilePage(ProductContext productContext,BaseActions baseActions) {
        this.baseActions=baseActions;
        driver= DriverFactory.getDriver();
        this.productContext=productContext;
    }
    public String verifyMobilePageTitle(){

        return baseActions.getTitle();
    }
    public void clickSortBy(){

        baseActions.elementClick(sortBy,0);
    }
    public void selectSortByName(){

        baseActions.selectByText(sortBy,"Name",0);

    }

    public boolean verifyPageAfterSort(){

        List<WebElement> list=baseActions.allElements(products);
        List<String > productList=new ArrayList();
        for (WebElement ele:list
             ) {
            productList.add(baseActions.getText(ele));
        }
        return Ordering.natural().isOrdered(productList);

    }
    public void clickOnProduct(String productName){

        baseActions.elementClick(products,productName);
    }

    public void storeMobileProducts(String prodName){

        List<WebElement> elementList=baseActions.allElements(products);

        for (WebElement ele: elementList
        ) {
            String name=baseActions.getText(ele).split("\\R")[0];
            String price=baseActions.getText(ele).split("\\R")[1];
            if(baseActions.getText(ele).split("\\R")[0].equals(prodName)){

                productContext.setProductContext(baseActions.getText(ele).split("\\R")[0],baseActions.getText(ele).split("\\R")[1]);
            }
        }
    }

}
