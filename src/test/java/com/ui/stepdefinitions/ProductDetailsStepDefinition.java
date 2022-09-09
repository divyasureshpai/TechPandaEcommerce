package com.ui.stepdefinitions;

import com.ui.context.ProductContext;
import com.ui.factory.PageObjectFactory;
import com.ui.pages.MobileDetailsPage;
import com.ui.pages.MobilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ProductDetailsStepDefinition {

    MobilePage mobilePage;
    MobileDetailsPage mobileDetailsPage;

    public ProductDetailsStepDefinition(MobileDetailsPage mobileDetailsPage,MobilePage mobilePage) {
        this.mobileDetailsPage=mobileDetailsPage;
        this.mobilePage=mobilePage;
    }

    @And("I click on {string} mobile")
    public void iClickOnSonyXperiaMobile(String productName) {

        mobilePage.clickOnProduct(productName);
    }

    @And("I verify the mobile details page title")
    public void iVerifyTheMobileDetailsPageTitle() {

       Assert.assertTrue("Product details page title mismatch",mobileDetailsPage.verifyProductDetailsPageTitle().equals("Sony Xperia - Mobile"));
    }


    @Then("the product cost in the products list page and product details page should match")
    public void theProductCostInTheProductsListPageAndProductDetailsPageShouldMatch() {

        Assert.assertTrue("Price not same",mobileDetailsPage.verifyProductPrice());
    }

    @And("I check the mobile list for {string} mobile")
    public void iCheckTheMobileListForSonyXperiaMobile( String prodName) {
        mobilePage.storeMobileProducts(prodName);
    }
}
