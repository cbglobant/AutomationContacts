package com.globant.screen.ios;

import com.globant.model.User;
import com.globant.pageobject.BaseScreen;
import com.globant.screen.widget.ContactsWidget;
import com.globant.util.ScreenFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("homeScreenIOS")
@Profile("IOS")
public class HomeScreenIOS extends BaseScreen {

    @Autowired
    private ScreenFactory screenFactory;

    @iOSXCUITFindBy(iOSNsPredicate = "name = 'Agregar' && type = 'XCUIElementTypeButton'")
    private IOSElement addButton;

    private List<ContactsWidget> contactsWidgets;

    @Autowired
    public HomeScreenIOS(AppiumDriver<? extends MobileElement> appiumDriver) {
        super(appiumDriver);
    }


    public <T extends BaseScreen> T addContact(String nameBean) {
        click(addButton);
        return screenFactory.getScreen(nameBean);
    }

    public Boolean isCreatedContact(User user){
        return contactsWidgets.stream().findFirst().filter(contactsWidget -> contactsWidget.getContact().equals(user.getFullName())).isPresent();
    }

}
