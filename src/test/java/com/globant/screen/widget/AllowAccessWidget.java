package com.globant.screen.widget;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

@AndroidFindBy(id = "com.android.packageinstaller:id/dialog_container")
public class AllowAccessWidget extends Widget {

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement allowOption;

    protected AllowAccessWidget(WebElement element) {
        super(element);
    }

    public AllowAccessWidget allowAcces() {
        allowOption.click();
        return this;
    }
}
