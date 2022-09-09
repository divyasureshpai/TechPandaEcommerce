package com.ui.utils;

import com.ui.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BaseActions {

    WebDriver driver;
    Select select;
    DriverFactory driverFactory;


    public BaseActions() {

        driver = DriverFactory.getDriver();
    }

//    public static synchronized BaseActions getBaseActions() {
//
//        return baseActions;
//    }

    public void elementClick(By locator) {

        try {
            driver.findElement(locator).click();
        } catch (Exception e) {
            System.err.println("Unbale to click" + e);
        }

    }

    public void elementClick(By locator, int position) {
        try {
            driver.findElements(locator).get(position).click();
        } catch (Exception e) {

            System.err.println("Cannot locate or click on the element" + e);
        }
    }

    public void elementClick(By locator, String value) {
        try {
            List<WebElement> list = new ArrayList();
            list = driver.findElements(locator);
            for (WebElement ele : list
            ) {
                if (ele.getText().contains(value)) {
                    ele.click();
                }
            }

        } catch (Exception e) {

            System.err.println("Cannot locate or click on the element" + e);
        }
    }

    public void enterText(By locator, String value) {

        try {
            driver.findElement(locator).sendKeys(value);
        } catch (Exception e) {
            System.err.println("Unable to enter text" + e);
        }
    }

    public void selectByText(By locator, String value) {

        select = new Select(driver.findElement(locator));
        select.selectByVisibleText(value);

    }

    public void selectByText(By locator, String value, int position) {

        select = new Select(driver.findElements(locator).get(position));
        select.selectByVisibleText(value);

    }

    public String getTitle() {

        return driver.getTitle();
    }

    public String getText(By locator) {

        return driver.findElement(locator).getText();
    }

    public String getText(WebElement element) {

        return element.getText();
    }
    public List<WebElement> allElements(By locator){

        return driver.findElements(locator);
    }
}
