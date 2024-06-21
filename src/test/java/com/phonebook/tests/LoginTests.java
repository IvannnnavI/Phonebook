package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends TestBase {

//    @BeforeClass
//    public void beforeClassPrecondition(){
//        System.out.println("Before class");
//    }
//    @BeforeTest
//    public void beforeTestPrecondition() {
//        System.out.println("Before TEst");
//    }
//
//    @AfterClass
//    public void afterClassPostCondition(){
//        System.out.println("After class");
//    }

    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }


    @Test(priority = 1)
    public void loginPositiveTest(){

        logger.info("Login with data-> " + UserData.EMAIL + " ***** " + UserData.PASSWORD);

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }
    @Test(priority = 2)
    public void loginNegativeWithoutEmailTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User()
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAlertPresent());

    }

}
