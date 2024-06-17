package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @Test
    public void loginPositiveTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("test@mailg.com")
                .setPassword("Password11#"));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }
    @Test
    public void loginNegativeWithoutEmailTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setPassword("Password11#"));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAlertPresent());

    }

}
