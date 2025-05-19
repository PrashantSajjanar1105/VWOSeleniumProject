package com.vwo.pages.pageObjectModel;

import com.vwo.utils.PropertiesReader;
import com.vwo.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    WaitHelpers waitHelpers;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        waitHelpers = new WaitHelpers(driver);
    }

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signIn = By.id("js-login-btn");
    private By errorMessage = By.xpath("//div[@id=\"js-notification-box-msg\"]");
    private By forgotPassword = By.xpath("//button[@data-qa=\"juvuwepeyi\"]");


    public String loginWithInvalidCredentials(String user,String pwd) {
        driver.get(PropertiesReader.readKey("loginUrl"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signIn).click();
//        since waitHelpers will directly give the Webelement
        return waitHelpers.waitUntilVisibilityOfElementByLocator(5,errorMessage).getText();
    }

}
