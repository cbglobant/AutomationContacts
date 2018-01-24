package com.globant.screen.android;

import com.globant.model.User;
import com.globant.pageobject.BaseScreen;
import com.globant.util.ScreenFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("contactScreenAndroid")
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
        System.out.println("name field" + textFieldName.getText());
        System.out.println("name user" + user.getFullName());
        System.out.println("phone field" + textFieldNumberPhone.getText());
        System.out.println("phone user" + user.getCellNumber());
        System.out.println(textFieldName.getText().equals(user.getFullName()) && textFieldNumberPhone.getText().equals(user.getCellNumber()));
        return textFieldName.getText().equals(user.getFullName());
    }
}
