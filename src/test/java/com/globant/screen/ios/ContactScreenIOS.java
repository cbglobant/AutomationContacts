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

@Component("contactScreenIOS")
@Profile("IOS")
public class ContactScreenIOS extends BaseScreen {

    @Autowired
    private ScreenFactory screenFactory;

    @iOSXCUITFindBy(iOSNsPredicate = "name = 'Contactos' && type = 'XCUIElementTypeButton'")
    private IOSElement contactButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name = 'Editar' && type = 'XCUIElementTypeButton'")
    private IOSElement editButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    private IOSElement textFieldName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='casa']/XCUIElementTypeStaticText[2]")
    private IOSElement textFieldNumberPhone;

    @iOSXCUITFindBy(iOSNsPredicate = "name = 'OK' && type = 'XCUIElementTypeButton'")
    private IOSElement okButton;

    @Autowired
    public ContactScreenIOS(AppiumDriver<? extends MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public Boolean isCreatedContact(User user){
        System.out.println(textFieldName.getText().equals(user.getFullName()) && textFieldNumberPhone.getText().equals(user.getCellNumber()));
        return textFieldName.getText().equals(user.getFullName()) && textFieldNumberPhone.getText().equals(user.getCellNumber());
    }

}
