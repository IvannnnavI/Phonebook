package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContact extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("test@mailg.com")
                .setPassword("Password11#"));
        app.getUser().clickOnLoginButton();
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("James")
                .setLastName("Bond")
                .setPhone("1234567890")
                .setAddress("Berlin")
                .setDescription("Forward"));
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void deleteContactPositiveTest() {
        int sizeBefore = app.getContact().sizeOfContacts();

        app.getContact().removeContact();
        app.getContact().pause(500);

        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

}
