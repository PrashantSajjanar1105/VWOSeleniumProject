package com.vwo.utils;

import com.vwo.driver.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

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
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilElementIsClickable(int seconds , By locator){
        wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement fluentWait(int totalWait, int pollingInterval, By locator){
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(totalWait))
                .pollingEvery(Duration.ofSeconds(pollingInterval))
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

}
