package com.globant.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.net.MalformedURLException;
import java.net.URL;

import static com.globant.appium.MobileCapabilityTypeDecorator.*;

@Configuration
@PropertySource("classpath:appiumAndroid.properties")
@ComponentScan("com.globant.*")
@Profile(MobilePlatform.ANDROID)
public class ConfigApplicationAndroid {

    @Autowired
    private Environment environment;

    @Bean(destroyMethod = "quit")
    @Qualifier("driver")
    public AppiumDriver<? extends MobileElement> appiumDriver() throws MalformedURLException {
        return new AndroidDriver(url(), desiredCapabilities());
    }

    @Bean
    public URL url() throws MalformedURLException {
        return new URL(new StringBuilder()
                .append("http://")
                .append(environment.getProperty("appium.server.ip"))
                .append(":")
                .append(environment.getProperty("appium.server.port"))
                .append("/wd/hub")
                .toString());
    }

    @Bean
    public DesiredCapabilities desiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (environment.getProperty("run.enviroment").equals("true")) {
            capabilities.setCapability(AUTOMATION_NAME, environment.getProperty("automationName"));
            capabilities.setCapability(DEVICE_NAME, environment.getProperty("device.name"));
            capabilities.setCapability(UDID, environment.getProperty("device.udid"));
            capabilities.setCapability(NO_RESET, environment.getProperty("app.noReset"));
            capabilities.setCapability(FULL_RESET, environment.getProperty("app.fullReset"));
            capabilities.setCapability(NEW_COMMAND_TIMEOUT, environment.getProperty("appium.new.command.timeout"));
            capabilities.setCapability(APP, environment.getProperty("app"));
            capabilities.setCapability(PLATFORM_VERSION, environment.getProperty("platform.version"));
            capabilities.setCapability(PLATFORM_NAME, environment.getProperty("platform"));
            capabilities.setCapability(APP_PACKAGE, environment.getProperty("android.app.package"));
            capabilities.setCapability(APP_ACTIVITY, environment.getProperty("android.app.activity"));
        }
        return capabilities;
    }
}
