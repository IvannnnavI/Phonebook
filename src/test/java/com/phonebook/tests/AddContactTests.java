package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("test@mailg.com")
                .setPassword("Password11#"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {

        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("James")
                .setLastName("Bond")
                .setPhone("1234567890")
                .setAddress("Berlin")
                .setDescription("Forward"));
        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isContactAdded("James"));
    }

    @AfterMethod
    public void postCondition() {

        app.getContact().removeContact();
        app.getContact().pause(1000);
    }

}
