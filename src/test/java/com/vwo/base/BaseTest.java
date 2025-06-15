package com.vwo.base;

import com.vwo.driver.DriverManger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        DriverManger.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManger.down();
    }
}
