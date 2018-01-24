package com.globant.screen.widget;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.Widget;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

@iOSXCUITFindBy(xpath = "type = 'XCUIElementTypeTable' && name = 'ContactsListView'")
public class ContactsWidget extends Widget {

    @iOSXCUITFindBy(iOSNsPredicate = "type = 'XCUIElementTypeCell'")
    private MobileElement contact;

    public ContactsWidget(WebElement element) {
        super(element);
    }

    public String getContact() {
        return contact.getTagName();
    }
}
