package com.ui.stepdefinitions;

import com.ui.factory.PageObjectFactory;
import com.ui.pages.HomePage;
import com.ui.pages.MobilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSortStepDefinition {

    HomePage homePage;
    MobilePage mobilePage;

    public ProductSortStepDefinition(MobilePage mobilePage,HomePage homePage){

        this.mobilePage=mobilePage;
        this.homePage=homePage;
    }
    @Given("I am on the TechPanda page")
    public void iAmOnTheTechPandaPage() {

        Assert.assertTrue("The title is not as expected",homePage.verifyTechPandaHomePageTitle().equals("Home page"));
    }

    @When("I click on the MOBILE menu")
    public void iClickOnTheMOBILEMenu() {

        homePage.clickMobileOption();
    }

    @And("I verify the page title")
    public void iVerifyThePageTitle() {

        Assert.assertTrue("The mobile page title is not as expected",mobilePage.verifyMobilePageTitle().equals("Mobile"));
    }

    @And("I click on the sort by drop-down")
    public void iClickOnTheSortByDropDown() {

        mobilePage.clickSortBy();
    }

    @And("I choose the sort by name option")
    public void iChooseTheSortByNameOption() {

        mobilePage.selectSortByName();
    }

    @Then("the products should be listed in the sorted order by its name")
    public void theProductsShouldBeListedInTheSortedOrderByItsName() {

        Assert.assertTrue("Page is not sorted",mobilePage.verifyPageAfterSort());
    }


}
