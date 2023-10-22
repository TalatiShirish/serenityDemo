package com.serenity.pages_and_steps.steps;


import com.serenity.pages_and_steps.pages.BasePage;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseSteps {

    public void openLinkInBrowser(String link) {
        WebDriver driver = Serenity.getWebdriverManager().getWebdriver();
        driver.get(link);
    }

    public void typeTextIntoField(BasePage page, String locator, String text) {
        page.$(locator).type(text);
    }

    public void clickButton(BasePage page, String locator) {
        page.$(locator).click();
    }

    public String getElementText(BasePage page, String locator) {
        return page.$(locator).getText();
    }

    public WebElement getElement(BasePage basePage, String locator){
        return basePage.$(locator);
    }
    public void ScrollInToView(BasePage basePage, String locator){
        ((JavascriptExecutor)basePage.getDriver()).executeScript("arguments[0].scrollInToView();",getElement(basePage,locator));
    }
}
