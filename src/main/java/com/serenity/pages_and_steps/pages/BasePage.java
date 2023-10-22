package com.serenity.pages_and_steps.pages;

import lombok.Getter;
import lombok.Setter;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

public class BasePage extends PageObject {

    private String verifyXpath;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public String getVerifyXpath(){
        return this.verifyXpath;
    }
    public void setVerifyXpath(String verifyXpath){
        this.verifyXpath = verifyXpath;
    }
    public boolean verify(){
        return $(verifyXpath).isDisplayed();
    }

    public Optional<WebElement> getElement(String xpathLocator, long durationMiliSeconds){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(1));
        try{
            WebElement element = wait.pollingEvery(Duration.ofMillis(250))
                    .withTimeout(Duration.ofMillis(durationMiliSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)))
                    .findElement(By.xpath(xpathLocator));
            return Optional.ofNullable(element);
        } catch (TimeoutException e){
            return Optional.empty();
        }
    }
}
