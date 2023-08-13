package th.cases.login;

import io.qameta.allure.Epic;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import th.BaseTest;
import th.pages.login.LoginPage;

@Epic("Login")
public class LoginTest extends BaseTest {

    @AfterMethod
    @Override
    public synchronized void cleanUp() {
        //Do not close driver after test
    }

    @Test(testName = "Check Username is required message")
    public void noUserTest() {
        LoginPage.init()
                .enterPassword("secret_sauce")
                .clickLoginButtonAndCheckErrorMessage("Epic sadface: Username is required");
    }

    @Test(testName = "Check Username and password do not match any user in this service message")
    public void badUserTest() {
        LoginPage.init()
                .enterUsername("123")
                .enterPassword("secret_sauce")
                .clickLoginButtonAndCheckErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @Test(testName = "Check Password is required message")
    public void noPasswordTest() {
        LoginPage.init()
                .enterUsername("standard_user")
                .clickLoginButtonAndCheckErrorMessage("Epic sadface: Password is required");
    }
}
