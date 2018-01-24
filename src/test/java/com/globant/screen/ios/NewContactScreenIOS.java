package com.globant.screen.ios;

import com.globant.model.User;
import com.globant.pageobject.BaseScreen;
import com.globant.util.ScreenFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("newContactScreenIOS")
@Profile("IOS")
public class NewContactScreenIOS extends BaseScreen {

    public static final String COUNTRY_CODE = "+569";

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
        typeIOSElement(textFieldNumberPhone, COUNTRY_CODE + user.getCellNumber());
        click(okButton);
        return screenFactory.getScreen(nameBean);
    }
}
