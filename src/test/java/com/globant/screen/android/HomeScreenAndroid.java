package com.globant.screen.android;

import com.globant.pageobject.BaseScreen;
import com.globant.screen.widget.AllowAccessWidget;
import com.globant.screen.widget.ConfirmWidget;
import com.globant.screen.widget.MoreOptionsWidget;
import com.globant.screen.widget.SelectedWidget;
import com.globant.util.ScreenFactory;
import com.globant.util.annottation.ScreenAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.beans.factory.annotation.Autowired;

@ScreenAndroid
public class HomeScreenAndroid extends BaseScreen {

    @Autowired
    private ScreenFactory screenFactory;

    @AndroidFindBy(id = "com.google.android.contacts:id/floating_action_button")
    private AndroidElement addContact;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Más opciones']")
    private AndroidElement moreOptions;

    @AndroidFindBy(id = "com.google.android.contacts:id/empty_account_view_text")
    private AndroidElement emptyContactList;

    private MoreOptionsWidget moreOptionsWidget;

    private SelectedWidget selectedWidget;

    private ConfirmWidget confirmWidget;

    private AllowAccessWidget accessWidget;


    @Autowired
    public HomeScreenAndroid(AppiumDriver<? extends MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public <T extends BaseScreen> T allowAccess(){
        accessWidget.allowAcces().allowAcces();
        return screenFactory.getScreen("homeScreenAndroid");
    }

    public <T extends BaseScreen> T addContact() {
        click(addContact);
        return screenFactory.getScreen("newContactScreenAndroid");
    }

    public <T extends BaseScreen> T selectAllContacts() {
        click(moreOptions);
        click(moreOptionsWidget.getSelectAllOption());
        return screenFactory.getScreen("homeScreenAndroid");
    }

    public <T extends BaseScreen> T deleteContact(){
        click(selectedWidget.getDeleteOption());
        confirmWidget.clickButtonAccept();
        return screenFactory.getScreen("homeScreenAndroid");
    }

    public Boolean isContactListEmpty(){
        return emptyContactList.isDisplayed();
    }
}
