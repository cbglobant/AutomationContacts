package com.globant.pageobject;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import static io.appium.java_client.MobileBy.AndroidUIAutomator;
import static java.lang.String.format;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class BaseScreen {

    private final AppiumDriver<? extends MobileElement> appiumDriver;
    public static final String ID = "cl.bci.sismo.mach.dev:id/";

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

    /**
     * Tap on the back button.
     */
    public void tapOnBackButton() {
        ((PressesKeyCode) appiumDriver).pressKeyCode(AndroidKeyCode.BACK);
    }

    /**
     * Checking that an element, known to be present on the screen, is visible.
     *
     * @param locator The element locator.
     * @param timeout
     * @return True if the element is visible otherwise return false.
     * @throws <code>TimeoutException</code> - If the timeout expires because the element is not visible.
     */
    protected boolean elementExists(By locator, int timeout) {
        try {
            waitOn(getAppiumDriver(), timeout).until(visibilityOfElementLocated(locator));
        } catch (Exception toe) {
            return false;
        }
        return true;
    }

    public void scrollToElement(String object, WebElement element) {
        By elementBy = MobileBy.iOSNsPredicateString(format("type = 'XCUIElementTypeStaticText' && name == '%s'", object));
        if (elementExists(elementBy, 2)) {
            getAppiumDriver().findElement(elementBy).click();
        } else {
            /*new TouchAction(getAppiumDriver())
                    .press(element.getLocation().x, (int) (element.getSize().height * 0.90))
                    .moveTo(0, (int) (element.getSize().height * 0.10) - (int) (element.getSize().height * 0.90))
                    .release()
                    .perform();
            scrollToElement(object, element);*/
        }
    }

    /**
     * @param seconds time waiting
     */
    public void waiting(int seconds) {
        try {
            synchronized (appiumDriver) {
                appiumDriver.wait(seconds * 1000);
            }
        } catch (Exception e) {
        }
    }
}
