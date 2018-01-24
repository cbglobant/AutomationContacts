package com.globant.screen.android;

import com.globant.pageobject.BaseScreen;
import com.globant.util.ScreenFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("homeScreenAndroid")
@Profile("ANDROID")
public class HomeScreenAndroid extends BaseScreen {

    @Autowired
    private ScreenFactory screenFactory;

    @AndroidFindBy(id = "com.google.android.contacts:id/floating_action_button")
    private AndroidElement addContact;

    @Autowired
    public HomeScreenAndroid(AppiumDriver<? extends MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public <T extends BaseScreen> T addContact() {
        click(addContact);
        return screenFactory.getScreen("newContactScreenAndroid");
    }

}
