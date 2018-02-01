package com.globant.config;

import com.globant.appium.listener.AppiumListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.ios.IOSDriver;
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
@PropertySource("classpath:appiumIOS.properties")
@ComponentScan("com.globant.*")
@Profile(MobilePlatform.IOS)
public class ConfigApplicationIOS {

    @Autowired
    private Environment environment;

    @Autowired
    private AppiumListener appiumListener;

    @Bean(destroyMethod = "quit")
    @Qualifier("driver")
    public AppiumDriver<? extends MobileElement> appiumDriver() throws MalformedURLException {
        return EventFiringWebDriverFactory.getEventFiringWebDriver(new IOSDriver(url(), desiredCapabilities()), appiumListener);
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
            capabilities.setCapability(PLATFORM, "mac");
            capabilities.setCapability(BUNDLE_ID, environment.getProperty("ios.app.bundleid"));
            capabilities.setCapability(XCODE_ORG_ID, environment.getProperty("ios.app.xcodeOrgId"));
            capabilities.setCapability(CLEAR_SYSTEM_FILES, environment.getProperty("clearSystemFiles"));
        }
        return capabilities;
    }
}
