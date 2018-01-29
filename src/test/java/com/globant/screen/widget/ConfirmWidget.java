package com.globant.screen.widget;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

@AndroidFindBy(id = "android:id/content")
public class ConfirmWidget extends Widget {

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private MobileElement buttonAccept;

    protected ConfirmWidget(WebElement element) {
        super(element);
    }

    public void clickButtonAccept() {
        buttonAccept.click();
    }
}
