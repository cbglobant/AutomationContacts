package com.globant.pageobject;

import com.globant.appium.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import static io.appium.java_client.MobileBy.AndroidUIAutomator;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class BaseScreen {

    private final AppiumDriver<? extends MobileElement> appiumDriver;

    @Autowired
    private Environment environment;

    @Autowired
    public BaseScreen(AppiumDriver<? extends MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    protected AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

    public void dispose() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }

    protected <K> FluentWait<K> waitOn(K object, int timeOutSeconds) {
        return new FluentWait<>(object).ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class).withTimeout(timeOutSeconds, SECONDS)
                .pollingEvery(1, SECONDS);
    }

    protected FluentWait<AppiumDriver> getWait() {
        return waitOn(getAppiumDriver(), Integer.parseInt(environment.getProperty("appium.new.command.timeout")));
    }

    protected void click(MobileElement element) {
        getWait().until(elementToBeClickable(element)).click();
    }

    protected void click(String text) {
        By locator = AndroidUIAutomator("text(\"" + text + "\")");
        getWait().until(elementToBeClickable(locator)).click();
    }

    protected String getText(MobileElement element) {
        return getWait().until(visibilityOf(element)).getText();
    }

    protected void type(MobileElement element, String text) {
        getWait().until(elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    protected void hideKeyboard() {
        getAppiumDriver().hideKeyboard();
    }

    protected void waitForElementToBeClickable(MobileElement element) {
        waitOn(getAppiumDriver(), 5).until(elementToBeClickable(element));
    }

    /**
     * Use this method to simulate typing into an element, which may set its
     * value.
     *
     * @param element A <code>MobileElement</code> instance.
     * @param text    Character sequence to send to the element
     * @throws <code>TimeoutException</code> - If the timeout expires because the element is not visible
     *                                       or is disabled such that you cannot type on it.
     */
    protected void typeIOSElement(MobileElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}
