package com.globant.test;

import com.globant.screen.android.HomeScreenAndroid;
import com.globant.screen.android.NewContactScreenAndroid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globant.util.MapperJSON.getUser;

@ActiveProfiles("ANDROID")
public class AddContactsAndroid extends BaseTests {

    @Autowired(required = true)
    @Qualifier("homeScreenAndroid")
    private HomeScreenAndroid homeScreenAndroid;
    private NewContactScreenAndroid newContactScreenAndroid;

    @Test(enabled = true)
    public void testAddContact() throws IOException {
        newContactScreenAndroid = homeScreenAndroid.addContact();
        newContactScreenAndroid.addContact(getUser("Diego"));
    }
}
