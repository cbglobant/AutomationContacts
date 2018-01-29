package com.globant.test;

import com.globant.model.User;
import com.globant.screen.ios.ContactScreenIOS;
import com.globant.screen.ios.HomeScreenIOS;
import com.globant.screen.ios.NewContactScreenIOS;
import com.globant.util.EnumData;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.globant.util.MapperJSON.getObjects;

@ActiveProfiles("IOS")
public class AddContactsIOS extends BaseTests {

    @Autowired
    private HomeScreenIOS homeScreenIOS;
    private NewContactScreenIOS newContactScreenIOS;
    private ContactScreenIOS contactScreenIOS;
    private List<User> userList = getObjects(EnumData.USERS);

    @Test(enabled = true)
    public void testAddContacts() throws IOException {
        userList.forEach(user -> {
            newContactScreenIOS = homeScreenIOS.addContact("newContactScreenIOS");
            contactScreenIOS = newContactScreenIOS.addDataContact("contactScreenIOS", user);
            contactScreenIOS.clickContactButton("homeScreenIOS");
        });
        Assertions.assertThat(homeScreenIOS.isValidContacts(userList)).isTrue();
    }

    @Test(enabled = true)
    public void testDeleteContacts() {
        userList.forEach(user -> {
            contactScreenIOS = homeScreenIOS.findContact("contactScreenIOS", user);
            newContactScreenIOS = contactScreenIOS.clickEditButton("newContactScreenIOS");
            newContactScreenIOS.deleteContact("homeScreenIOS");
        });
    }
}
