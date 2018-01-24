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

@Component
@Profile("ANDROID")
public class NewContactScreenAndroid extends BaseScreen {

    @Autowired
    private ScreenFactory screenFactory;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Nombre']")
    private AndroidElement textFieldName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Apellido']")
    private AndroidElement textFieldLastName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Teléfono']")
    private AndroidElement textFieldNumberPhone;

    @AndroidFindBy(id = "com.google.android.contacts:id/editor_menu_save_button")
    private AndroidElement saveButton;

    @Autowired
    public NewContactScreenAndroid(AppiumDriver<? extends MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public <T extends BaseScreen> T addContact(String nameBean, User user){
        type(textFieldName,user.getName());
        hideKeyboard();
        type(textFieldLastName, user.getLastName());
        hideKeyboard();
        type(textFieldNumberPhone, user.getCellNumber());
        click(saveButton);
        return screenFactory.getScreen(nameBean);
    }
}
