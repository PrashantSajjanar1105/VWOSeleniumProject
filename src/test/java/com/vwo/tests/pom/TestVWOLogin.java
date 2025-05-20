package com.vwo.tests.pom;

import com.vwo.driver.DriverManger;
import com.vwo.pages.pageObjectModel.DashboardPage;
import com.vwo.pages.pageObjectModel.LoginPage;
import com.vwo.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin {

    @Test
    @Description("TC# 1 : Verify that Login Test with invalid credentials gives the errormessage")
    public void test_LoginWithInvalidCredentials()  {

        DriverManger.init();
        WebDriver driver = DriverManger.getDriver();

        LoginPage loginPage= new LoginPage(driver);
        String errorMessage = loginPage.loginWithInvalidCredentials(PropertiesReader.readKey("invalidUsername"),PropertiesReader.readKey("invalidPassword"));

        assertThat(errorMessage).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(errorMessage,PropertiesReader.readKey("expectedErrorMessage"));

        driver.quit();

    }

    @Test
    @Description("TC#2 : Verify that Login Test with valid credentials logs into dashboard page with expected username")
    public void test_LoginWithValidCredentials() throws InterruptedException {

        DriverManger.init();
        WebDriver driver = DriverManger.getDriver();

        LoginPage loginPage= new LoginPage(driver);
        loginPage.loginWithValidCredentials(PropertiesReader.readKey("validUsername"),PropertiesReader.readKey("validPassword"));

        DashboardPage dashboardPage = new DashboardPage(driver);

        assertThat(dashboardPage.loggedInUsername()).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(dashboardPage.loggedInUsername(),PropertiesReader.readKey("expectedUsername"));

        driver.quit();

    }
}
