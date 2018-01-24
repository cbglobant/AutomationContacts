package com.globant.test;

import com.globant.config.ConfigApplicationAndroid;
import com.globant.config.ConfigApplicationIOS;
import com.globant.pageobject.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@ContextConfiguration(classes = {ConfigApplicationAndroid.class, ConfigApplicationIOS.class}, loader = AnnotationConfigContextLoader.class)
public class BaseTests<T extends BaseScreen> extends AbstractTestNGSpringContextTests {

    @Autowired
    private AppiumDriver<? extends MobileElement> appiumDriver;

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {

    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        this.appiumDriver.quit();
    }
}
