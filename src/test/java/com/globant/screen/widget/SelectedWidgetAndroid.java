package com.globant.screen.widget;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

@AndroidFindBy(id = "com.google.android.contacts:id/root")
public class SelectedWidgetAndroid extends Widget {

    @AndroidFindBy(id = "com.google.android.contacts:id/menu_delete")
    private MobileElement deleteOption;

    protected SelectedWidgetAndroid(WebElement element) {
        super(element);
    }

    public MobileElement getDeleteOption() {
        return deleteOption;
    }
}
