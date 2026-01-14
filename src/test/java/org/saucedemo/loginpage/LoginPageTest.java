package org.saucedemo.loginpage;

import org.openqa.selenium.support.PageFactory;
import org.saucedemo.pageobject.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);
    private LoginPage loginPage;

    @BeforeTest
    public void setupPage() {
        this.loginPage = PageFactory.initElements(driver, LoginPage.class);
    }


    @Test(dataProvider = "data")
    public void login(String username, String password) throws InterruptedException {
        this.loginPage.goTo();
        Assert.assertTrue(this.loginPage.getUsername().isDisplayed());
        this.loginPage.getUsername().setUsername(username);
        Reporter.log("Username field is visible");

        Assert.assertTrue(this.loginPage.getPassword().isDisplayed());
        this.loginPage.getPassword().setPassword(password);
        Reporter.log("Password field is visible");

        Assert.assertTrue(this.loginPage.getLoginButton().isDisplayed());
        this.loginPage.getLoginButton().clickLoginBtn();
        Reporter.log("Button clicked");

        Thread.sleep(5000);
    }


    @DataProvider(name = "data")
    public Object[][] getData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"}
        };
    }
}
