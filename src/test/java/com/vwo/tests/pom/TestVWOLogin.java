package com.vwo.tests.pom;

import com.vwo.base.BaseTest;
import com.vwo.driver.DriverManger;
import com.vwo.pages.pageObjectModel.DashboardPage;
import com.vwo.pages.pageObjectModel.LoginPage;
import com.vwo.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin extends BaseTest {

    @Test
    @Description("TC# 1 : Verify that Login Test with invalid credentials gives the errormessage")
    public void test_LoginWithInvalidCredentials()  {

        LoginPage loginPage= new LoginPage(DriverManger.getDriver());
        String errorMessage = loginPage.loginWithInvalidCredentials(PropertiesReader.readKey("invalidUsername"),PropertiesReader.readKey("invalidPassword"));

        assertThat(errorMessage).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(errorMessage,PropertiesReader.readKey("expectedErrorMessage"));

    }

    @Test
    @Description("TC#2 : Verify that Login Test with valid credentials logs into dashboard page with expected username")
    public void test_LoginWithValidCredentials() throws InterruptedException {

        LoginPage loginPage= new LoginPage(DriverManger.getDriver());
        loginPage.loginWithValidCredentials(PropertiesReader.readKey("validUsername"),PropertiesReader.readKey("validPassword"));

        DashboardPage dashboardPage = new DashboardPage(DriverManger.getDriver());

        assertThat(dashboardPage.loggedInUsername()).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(dashboardPage.loggedInUsername(),PropertiesReader.readKey("expectedUsername"));

    }

}
