package com.vwo.pages.pageObjectModel;

import com.vwo.driver.DriverManger;
import com.vwo.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {


    public By userNameInDashboard = By.xpath("//span[@data-qa=\"lufexuloga\"]");

    WebDriver driver ;
    WaitHelpers waitHelpers;
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        waitHelpers = new WaitHelpers(driver);
    }

    public String loggedInUsername() throws InterruptedException {
        return waitHelpers.waitUntilVisibilityOfElementByLocator(15,userNameInDashboard).getText();
    }
}
