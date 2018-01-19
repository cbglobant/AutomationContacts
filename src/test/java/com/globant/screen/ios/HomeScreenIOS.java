package com.globant.screen.ios;

import com.globant.pageobject.BaseScreen;
import com.globant.util.ScreenFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeScreenIOS extends BaseScreen {

    @Autowired
    private ScreenFactory screenFactory;

    @iOSXCUITFindBy(iOSNsPredicate = "name = 'Agregar' && type = 'XCUIElementTypeButton'")
    private IOSElement addButton;

    @Autowired
    public HomeScreenIOS(AppiumDriver<? extends MobileElement> appiumDriver) {
        super(appiumDriver);
    }


    public <T extends BaseScreen> T addContact() {
        click(addButton);
        return screenFactory.getScreen("newContactScreenIOS");
    }

}
