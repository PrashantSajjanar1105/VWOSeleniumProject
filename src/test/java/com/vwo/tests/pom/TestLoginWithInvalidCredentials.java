package com.vwo.tests.pom;

import com.vwo.pages.pageObjectModel.LoginPage;
import com.vwo.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestLoginWithInvalidCredentials {

    @Test
    @Description("Verify that Login Test with invalid credentials gives the errormessage")
    public void test_LoginwithInvalidCredentials()  {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);

        LoginPage loginPage= new LoginPage(driver);

        String errorMessage = loginPage.loginWithInvalidCredentials(PropertiesReader.readKey("invalidUsername"),PropertiesReader.readKey("invalidPassword"));

        assertThat(errorMessage).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(errorMessage,PropertiesReader.readKey("expectedErrorMessage"));


        driver.quit();

    }
}
