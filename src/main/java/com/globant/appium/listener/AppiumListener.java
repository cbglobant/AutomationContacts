package com.globant.appium.listener;

import io.appium.java_client.events.api.general.ElementEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

/**
 * Listener that allows us to organize the event logging
 */
@Component
public class AppiumListener implements ElementEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppiumListener.class);

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        String[] data = getElementData(element);
        LOGGER.info(format("Click on [%s | %s]", data[0], data[1]));
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver) {
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    }

    private String[] getElementData(WebElement element) {
        String[] data = new String[2];
        data[0] = element.getTagName();
        data[1] = element.getText();
        return data;
    }
}