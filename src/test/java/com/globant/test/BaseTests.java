package com.globant.test;


import com.globant.config.ConfigApplication;
import com.globant.pageobject.BaseScreen;
import com.globant.screen.ios.HomeScreenIOS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@ContextConfiguration(classes = ConfigApplication.class, loader = AnnotationConfigContextLoader.class)
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
