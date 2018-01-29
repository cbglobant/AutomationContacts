package com.globant.screen.widget;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

@AndroidFindBy(xpath = "//android.widget.ListView/android.view.ViewGroup")
public class ContactsWidgetAndroid extends Widget {

    protected ContactsWidgetAndroid(WebElement element) {
        super(element);
    }
}
