package com.phonebook.tests;

import com.phonebook.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTest(Method method,Object[]par) {
        logger.info("Start test!" + method.getName() +"with data: " + Arrays.asList(par));
    }

    @BeforeSuite
    public void setUp() {
        app.init();

    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result){
        if (result.isSuccess()){
            logger.info("PASSED: " + result.getMethod().getMethodName());
        }else {
            logger.error("FALLED" + result.getMethod().getMethodName() + "Screenshot: " + app.getUser().takeScreenshot());
        }
        logger.info("Stop Test!");
        logger.info("================================================================================================");
    }
    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
