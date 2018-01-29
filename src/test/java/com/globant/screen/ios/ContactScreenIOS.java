package com.globant.screen.ios;

import com.globant.model.User;
import com.globant.pageobject.BaseScreen;
import com.globant.util.annottation.ScreenIOS;
import com.globant.util.ScreenFactory;
import com.globant.util.UtilFormat;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.springframework.beans.factory.annotation.Autowired;

@ScreenIOS
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
        return textFieldName.getText().equals(user.getFullName())
                && UtilFormat.formatPhoneNumber(textFieldNumberPhone.getText()).equals(UtilFormat.formatPhoneNumber(user.getPhoneNumber()));
    }

    public <T extends BaseScreen> T clickContactButton(String nameBean){
        click(contactButton);
        return screenFactory.getScreen(nameBean);
    }

    public <T extends BaseScreen> T clickEditButton(String nameBean){
        click(editButton);
        return screenFactory.getScreen(nameBean);
    }

}
