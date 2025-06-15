package com.vwo.listeners;

import com.vwo.driver.DriverManger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();

        WebDriver driver = DriverManger.getDriver();

        if(driver!=null){

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                String screeshotPath = "failure_screenshots/"+ result.getName() + "_" +
                        new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(Calendar.getInstance().getTime()) + ".png";
                System.out.println(screeshotPath);
                FileUtils.copyFile(scrFile,new File(screeshotPath));

//                Add ScreenshotLink to TestNg Reports
                org.testng.Reporter.log("<a href'"+screeshotPath+"'>Screenshot</a>");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
