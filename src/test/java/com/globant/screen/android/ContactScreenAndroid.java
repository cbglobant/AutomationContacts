package com.globant.screen.android;

import com.globant.model.User;
import com.globant.pageobject.BaseScreen;
import com.globant.util.ScreenFactory;
import com.globant.util.UtilFormat;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.globant.util.UtilFormat.formatPhoneNumber;

@Component
@Profile("ANDROID")
public class ContactScreenAndroid extends BaseScreen {

    @Autowired
    private ScreenFactory screenFactory;

    @AndroidFindBy(id = "com.google.android.contacts:id/large_title")
    private AndroidElement textFieldName;

    @AndroidFindBy(id = "com.google.android.contacts:id/header")
    private AndroidElement textFieldNumberPhone;

    @Autowired
    public ContactScreenAndroid(AppiumDriver<? extends MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public Boolean isCreatedContact(User user){
        return textFieldName.getText().equals(user.getFullName())
                && formatPhoneNumber(textFieldNumberPhone.getText()).equals(formatPhoneNumber(user.getPhoneNumber()));
    }
}
