package com.vwo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelpers {

    WebDriver driver;

    WebDriverWait wait;

    public WaitHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public void waitJVM(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    public WebElement waitUntilVisibilityOfElementUsingXpath(int seconds, String xpath){
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
    }

    public WebElement waitUntilVisibilityOfElementUsingId(int seconds, String id){
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(id))));
    }

    public WebElement waitUntilVisibilityOfElementByLocator(int seconds,By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public WebElement waitUntilElementIsClickable(int seconds , By locator){
        wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }






}
