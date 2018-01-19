package com.globant.config;

import com.globant.appium.AppiumConfig;
import com.globant.util.EnumPlataform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

import static com.globant.appium.MobileCapabilityTypeDecorator.*;

@Configuration
@ComponentScan("com.globant.*")
public class ConfigApplication {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public AppiumConfig appiumConfig() {
        return ConfigFactory.create(AppiumConfig.class);
    }

    @Bean(destroyMethod = "quit")
    @Qualifier("driver")
    public AppiumDriver<? extends MobileElement> appiumDriver() throws MalformedURLException {
        return this.appiumConfig().platform().equals(EnumPlataform.ANDROID)
                ? new AndroidDriver(url(), this.desiredCapabilities())
                : new IOSDriver(url(), this.desiredCapabilities());
    }

    @Bean
    public URL url() throws MalformedURLException {
        return new URL("http://0.0.0.0:" + appiumConfig().appiumServerPort() + "/wd/hub");
    }

    @Bean
    public DesiredCapabilities desiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (this.appiumConfig().isRunEnviroment()) {
            capabilities.setCapability(AUTOMATION_NAME, appiumConfig().automationName());
            capabilities.setCapability(DEVICE_NAME, appiumConfig().deviceName());
            capabilities.setCapability(UDID, appiumConfig().udid());
            capabilities.setCapability(NO_RESET, appiumConfig().isAppNoReset());
            capabilities.setCapability(FULL_RESET, appiumConfig().isAppFullReset());
            capabilities.setCapability(NEW_COMMAND_TIMEOUT, appiumConfig().newCommandTimeout());
            capabilities.setCapability(APP, appiumConfig().app());
            capabilities.setCapability(PLATFORM_VERSION, appiumConfig().platformVersion());
            capabilities.setCapability(PLATFORM_NAME, appiumConfig().platform().getOS().toString());

            if (EnumPlataform.ANDROID.equals(appiumConfig().platform())) {
                capabilities.setCapability(APP_PACKAGE, appiumConfig().appPackage());
                capabilities.setCapability(APP_ACTIVITY, appiumConfig().appActivity());
            } else {
                capabilities.setCapability(PLATFORM, "mac");
                capabilities.setCapability(BUNDLE_ID, appiumConfig().bundleid());
                capabilities.setCapability(XCODE_ORG_ID, appiumConfig().xcodeOrgId());
                capabilities.setCapability(CLEAR_SYSTEM_FILES, appiumConfig().clearSystemFiles());
            }
        }
        return capabilities;
    }
}
