package com.globant.screen.widget;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.Widget;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

@iOSXCUITFindBy(iOSNsPredicate = "type = 'XCUIElementTypeSheet'")
public class DeleteWidget extends Widget {

    @iOSXCUITFindBy(iOSNsPredicate = "type = 'XCUIElementTypeButton' && name LIKE 'Eliminar contacto*'")
    private MobileElement deleteContactButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type = 'XCUIElementTypeButton' && name = 'Cancelar'")
    private MobileElement cancelButton;

    public DeleteWidget(WebElement element) {
        super(element);
    }

    public MobileElement getDeleteContactButton() {
        return deleteContactButton;
    }

    public MobileElement getCancelButton() {
        return cancelButton;
    }
}
