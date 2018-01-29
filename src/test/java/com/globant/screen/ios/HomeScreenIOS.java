package com.globant.screen.ios;

import com.globant.model.User;
import com.globant.pageobject.BaseScreen;
import com.globant.util.annottation.ScreenIOS;
import com.globant.util.ScreenFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@ScreenIOS
public class HomeScreenIOS extends BaseScreen {

    @Autowired
    private ScreenFactory screenFactory;

    @iOSXCUITFindBy(iOSNsPredicate = "name = 'Agregar' && type = 'XCUIElementTypeButton'")
    private IOSElement addButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    private List<IOSElement> contacts;

    @iOSXCUITFindBy(iOSNsPredicate = "type = 'XCUIElementTypeTable' && name = 'ContactsListView'")
    private IOSElement emptyTable;

    @iOSXCUITFindBy(iOSNsPredicate = "type = 'XCUIElementTypeSearchField' && name = 'Buscar'")
    private IOSElement searchField;

    @Autowired
    public HomeScreenIOS(AppiumDriver<? extends MobileElement> appiumDriver) {
        super(appiumDriver);
    }


    public <T extends BaseScreen> T addContact(String nameBean) {
        click(addButton);
        return screenFactory.getScreen(nameBean);
    }

    public Boolean isValidContacts(List<User> users) {
        return users.stream().map(user -> user.getFullName())
                .collect(Collectors.toList())
                .containsAll(contacts.stream()
                        .map(RemoteWebElement::getText)
                        .collect(Collectors.toList()));

    }

    public <T extends BaseScreen> T findContact(String nameBean, User user) {
        typeIOSElement(searchField, user.getFullName());
        contacts.stream().filter(
                element ->
                        element.getText().equals(user.getFullName()))
                .findFirst()
                .ifPresent(this::click);
        return screenFactory.getScreen(nameBean);
    }

    public Boolean isValidDeleteContacts() {
        System.out.println(emptyTable.getTagName());
        return emptyTable.getTagName().equals("Sin contactos");
    }
}
