package com.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class MakeMyTripProject extends BaseTest{

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement modelCross= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-cy=\"closeModal\"]")));
        modelCross.click();

        WebElement fromCity = wait.until(ExpectedConditions.elementToBeClickable(By.id("fromCity")));
        fromCity.click();

        WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));

        Actions actions= new Actions(driver);
        actions.moveToElement(fromInput).sendKeys("BLR").build().perform();

        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

        Thread.sleep(5000);

        for (WebElement e : suggestions){

            System.out.println(e.getText());
            if(e.getText().contains("Bengaluru International Airport")){
                e.click();
            }

        }


    }
}
