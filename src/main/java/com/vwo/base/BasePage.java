package com.vwo.base;

import com.vwo.driver.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    public void getUrl(String url){
        DriverManger.getDriver().get(url);
    }

    public void enterInput(By by, String input){
        DriverManger.getDriver().findElement(by).sendKeys(input);
    }

    public void enterInput(WebElement by, String input){
        by.sendKeys(input);
    }

    public void clickElement(By by){
        DriverManger.getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by){
        by.click();
    }

    public String getText(By by){
        return DriverManger.getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
        return by.getText();
    }




}
