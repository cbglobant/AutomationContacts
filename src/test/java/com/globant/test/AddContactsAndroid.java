package com.globant.test;

import com.globant.model.User;
import com.globant.screen.android.ContactScreenAndroid;
import com.globant.screen.android.HomeScreenAndroid;
import com.globant.screen.android.NewContactScreenAndroid;
import com.globant.util.EnumData;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.globant.util.MapperJSON.getObjects;
import static com.globant.util.MapperJSON.getUser;

@ActiveProfiles("ANDROID")
public class AddContactsAndroid extends BaseTests {

    @Autowired
    private HomeScreenAndroid homeScreenAndroid;
    private NewContactScreenAndroid newContactScreenAndroid;
    private ContactScreenAndroid contactScreenAndroid;
    private List<User> userList = getObjects(EnumData.USERS);

    @Test(enabled = true)
    public void testAllowAccess(){
        homeScreenAndroid.allowAccess();
    }

    @Test(enabled = true)
    public void testAddContact() throws IOException {
        userList.forEach(user -> {
            newContactScreenAndroid = homeScreenAndroid.addContact();
            contactScreenAndroid = newContactScreenAndroid.addContact("contactScreenAndroid", user);
            Assertions.assertThat(contactScreenAndroid.isCreatedContact(user)).isTrue();
            contactScreenAndroid.tapOnBackButton();
        });
    }

    @Test(enabled = true)
    public void testDeleteAllContacts(){
        homeScreenAndroid.selectAllContacts();
        homeScreenAndroid.deleteContact();
        Assertions.assertThat(homeScreenAndroid.isContactListEmpty()).isTrue();
    }
}
