package com.serenity.pages_and_steps.stepDefs;

import com.serenity.pages_and_steps.pages.BasePage;
import com.serenity.pages_and_steps.steps.BaseSteps;
import com.serenity.pages_and_steps.steps.ReflectionSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class StepDefinations {
    @Steps
    private BaseSteps baseSteps;
    @Steps
    private ReflectionSteps reflectionSteps;

    @Given("Launch application")
    public void launchApplication(){
        String link = "https://demo.opencart.com/admin";
        baseSteps.openLinkInBrowser(link);
    }

    @When("User type : {string} at {string} on page {string}")
    public void userTypeAtOnPage(String textData, String textboxLocator, String pageName) throws Exception {
        BasePage page = reflectionSteps.getPageByName(pageName);
        String locator = reflectionSteps.getXpathAnnotated(page,textboxLocator);
        baseSteps.typeTextIntoField(page,locator,textData);
    }

    @And("User click on button {string} on page {string}")
    public void userClickOnButtonOnPage(String buttonName, String pageName)throws Exception {
        BasePage page = reflectionSteps.getPageByName(pageName);
        String locator = reflectionSteps.getXpathAnnotated(page,buttonName);
        baseSteps.clickButton(page,locator);
    }

    @Then("Validate {string} page is displayed")
    public void validatePageIsDisplayed(String pageName)throws Exception {
        BasePage page = reflectionSteps.getPageByName(pageName);
        page.verify();
    }

    @And("Validate text {string} is displayed in {string} on page {string}")
    public void validateTextIsDisplayedInOnPage(String textData, String textLocator, String pageName)throws Exception {
        BasePage page = reflectionSteps.getPageByName(pageName);
        String locator = reflectionSteps.getXpathAnnotated(page,textLocator);
        Assert.assertEquals(baseSteps.getElementText(page,locator),textData);
    }
}
