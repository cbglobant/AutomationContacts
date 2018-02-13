package com.globant.screen.ios;

import com.globant.model.User;
import com.globant.pageobject.BaseScreen;
import com.globant.screen.widget.DeleteWidget;
import com.globant.util.annottation.ScreenIOS;
import com.globant.util.ScreenFactory;
import com.globant.util.UtilFormat;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.springframework.beans.factory.annotation.Autowired;

@ScreenIOS
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

    @iOSXCUITFindBy(iOSNsPredicate = "type = 'XCUIElementTypeTable'")
    private IOSElement contactTable;

    private DeleteWidget deleteWidget;

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

    public <T extends BaseScreen> T deleteContact(String nameBean) {
        //scrollToElement("Eliminar contacto", contactTable);
        click(deleteWidget.getDeleteContactButton());
        return screenFactory.getScreen(nameBean);
    }
}
