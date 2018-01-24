package com.globant.screen.ios;

import com.globant.model.User;
import com.globant.pageobject.BaseScreen;
import com.globant.util.ScreenFactory;
import com.globant.util.UtilFormat;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("IOS")
public class NewContactScreenIOS extends BaseScreen {

    @Autowired
    private ScreenFactory screenFactory;

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


    public <T extends BaseScreen> T addDataContact(String nameBean, User user) {
        typeIOSElement(textFieldName, user.getName());
        typeIOSElement(textFieldLastName, user.getLastName());
        click(addPhoneButton);
        typeIOSElement(textFieldNumberPhone, UtilFormat.formatPhoneNumber(user.getPhoneNumber()));
        click(okButton);
        return screenFactory.getScreen(nameBean);
    }
}
