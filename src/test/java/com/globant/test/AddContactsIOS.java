package com.globant.test;

import com.globant.model.User;
import com.globant.screen.ios.ContactScreenIOS;
import com.globant.screen.ios.HomeScreenIOS;
import com.globant.screen.ios.NewContactScreenIOS;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globant.util.MapperJSON.getUser;

@ActiveProfiles("IOS")
public class AddContactsIOS extends BaseTests {

    @Autowired
    private HomeScreenIOS homeScreenIOS;
    private NewContactScreenIOS newContactScreenIOS;
    private ContactScreenIOS contactScreenIOS;

    @Test(enabled = true)
    public void testAddContact() throws IOException {
        User user = getUser("Diego");

        newContactScreenIOS = homeScreenIOS.addContact("newContactScreenIOS");
        contactScreenIOS = newContactScreenIOS.addDataContact("contactScreenIOS", user);

        Assertions.assertThat(contactScreenIOS.isCreatedContact(user)).isTrue();
    }
}
