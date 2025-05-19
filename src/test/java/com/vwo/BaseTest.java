package com.vwo;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public EdgeDriver driver;

    @BeforeTest
    public void setup(){
      driver = new EdgeDriver();
      driver.manage().window().maximize();

    }

//    @AfterTest
//    public void close(){
//        driver.quit();
//    }
}
