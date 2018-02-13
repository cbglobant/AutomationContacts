package com.globant.screen.android;

import com.globant.pageobject.BaseScreen;
import com.globant.util.ScreenFactory;
import com.globant.util.annottation.ScreenAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.beans.factory.annotation.Autowired;

@ScreenAndroid
public class GoogleScreenAndroid extends BaseScreen {

    @Autowired
    private ScreenFactory screenFactory;

    @AndroidFindBy(id = "com.google.android.contacts:id/secondary_button")
    private AndroidElement skip;

    public GoogleScreenAndroid(AppiumDriver<? extends MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public <T extends BaseScreen> T skip(){
        click(skip);
        return screenFactory.getScreen("homeScreenAndroid");
    }
}
