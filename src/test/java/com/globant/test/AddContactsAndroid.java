package com.globant.test;

import com.globant.model.User;
import com.globant.screen.android.*;
import com.globant.util.EnumData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobilePlatform;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.globant.util.MapperJSON.getObjects;

@ActiveProfiles(MobilePlatform.ANDROID)
public class AddContactsAndroid extends BaseTests {

    @Autowired
    private HomeScreenAndroid homeScreenAndroid;
    @Autowired
    private LoginScreen loginScreen;
    private NewContactScreenAndroid newContactScreenAndroid;
    private ContactScreenAndroid contactScreenAndroid;
    private GoogleScreenAndroid googleScreenAndroid;
    private List<User> userList = getObjects(EnumData.USERS);

    @Test(priority = 0, enabled = false)
    public void switchApp() throws InterruptedException {

        System.out.println(((AndroidDriver<AndroidElement>) getAppiumDriver()).currentActivity());

        System.out.println(((AndroidDriver<AndroidElement>) getAppiumDriver()).getPageSource());

        ((AndroidDriver<AndroidElement>) getAppiumDriver()).startActivity("cl.bci.sismo.mach.dev","cl.bci.sismo.mach.machapp.splash.SplashScreenActivity");

        System.out.println(((AndroidDriver<AndroidElement>) getAppiumDriver()).getPageSource());

        loginScreen.tapOnDoYouAlreadyHaveAnAccount();
    }

    @Test(priority = 1, enabled = true)
    public void testAddContact() throws IOException {
        googleScreenAndroid = homeScreenAndroid.allowAccess();
        homeScreenAndroid = googleScreenAndroid.skip();
        userList.forEach(user -> {
            newContactScreenAndroid = homeScreenAndroid.addContact();
            contactScreenAndroid = newContactScreenAndroid.addContact("contactScreenAndroid", user);
            Assertions.assertThat(contactScreenAndroid.isCreatedContact(user)).isTrue();
            contactScreenAndroid.tapOnBackButton();
        });
    }

    @Test(priority = 2, enabled = true)
    public void testDeleteAllContacts() {
        homeScreenAndroid.selectAllContacts();
        homeScreenAndroid.deleteContact();
        Assertions.assertThat(homeScreenAndroid.isContactListEmpty()).isTrue();
    }
}
