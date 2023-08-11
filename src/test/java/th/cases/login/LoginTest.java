package th.cases.login;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import th.BaseTest;
import th.pages.login.LoginPage;

public class LoginTest extends BaseTest {

    @AfterMethod
    @Override
    public void cleanUp() {
        //Do not close driver after test
    }

    @Test
    public void noUserTest() {
        LoginPage.init()
                .enterPassword("secret_sauce")
                .clickLoginButtonAndCheckErrorMessage("Epic sadface: Username is required");
    }

    @Test
    public void badUserTest() {
        LoginPage.init()
                .enterUsername("123")
                .enterPassword("secret_sauce")
                .clickLoginButtonAndCheckErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void badPasswordTest() {
        LoginPage.init()
                .enterUsername("standard_user")
                .enterPassword("123")
                .clickLoginButtonAndCheckErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void noPasswordTest() {
        LoginPage.init()
                .enterUsername("standard_user")
                .clickLoginButtonAndCheckErrorMessage("Epic sadface: Password is required");
    }
}
