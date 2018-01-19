package com.globant.screen.ios;

import com.globant.model.User;
import com.globant.pageobject.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewContactScreenIOS extends BaseScreen {

    @iOSXCUITFindBy(iOSNsPredicate = "name = 'Nombre' && type = 'XCUIElementTypeTextField'")
    private IOSElement textFieldName;

    @iOSXCUITFindBy(iOSNsPredicate = "name = 'Apellidos' && type = 'XCUIElementTypeTextField'")
    private IOSElement textFieldLastName;

    @iOSXCUITFindBy(iOSNsPredicate = "name = 'Insertar agregar teléfono' && type = 'XCUIElementTypeButton'")
    private IOSElement addPhoneButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name = 'casa' && type = 'XCUIElementTypeTextField'")
    private IOSElement textFieldNumberPhone;

    @iOSXCUITFindBy(iOSNsPredicate = "name = 'OK' && type = 'XCUIElementTypeButton'")
    private IOSElement okButton;

    @Autowired
    public NewContactScreenIOS(AppiumDriver<? extends MobileElement> appiumDriver) {
        super(appiumDriver);
    }


    public void addContact(User user) {
        typeIOSElement(textFieldName, user.getName());
        typeIOSElement(textFieldLastName, user.getLastName());
        click(addPhoneButton);
        typeIOSElement(textFieldNumberPhone, user.getCellNumber());
        click(okButton);
    }
}
