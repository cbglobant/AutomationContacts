package com.globant.screen.widget;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

import java.util.List;

@AndroidFindBy(xpath = "//android.widget.ListView")
public class MoreOptionsWidget extends Widget {

    @AndroidFindBy(id = "com.google.android.contacts:id/title")
    private List<AndroidElement> option;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")
    private AndroidElement selectAllOption;

    protected MoreOptionsWidget(WebElement element) {
        super(element);
    }

    public MobileElement getSelectAllOption() {
        return selectAllOption;
    }
}
