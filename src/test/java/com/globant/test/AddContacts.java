package com.globant.test;

import com.globant.screen.ios.HomeScreenIOS;
import com.globant.screen.ios.NewContactScreenIOS;
import com.globant.util.ScreenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globant.util.MapperJSON.getUser;

public class AddContacts extends BaseTests {

    @Autowired
    private ScreenFactory screenFactory;

    @Test(enabled = true)
    public void testAddContact() throws IOException {
        HomeScreenIOS homeScreenIOS = screenFactory.getScreen("homeScreenIOS");

        NewContactScreenIOS newContactScreenIOS = homeScreenIOS.addContact();

        newContactScreenIOS.addContact(getUser("Diego"));
    }
}
