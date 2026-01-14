package org.saucedemo.loginpage;

import org.openqa.selenium.support.PageFactory;
import org.saucedemo.pageobject.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FullTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(FullTest.class);
    private LoginPage loginPage;
    private MainPage mainPage;
    private CheckoutPage checkoutPage;
    private OrderInfoPage orderInfoPage;
    private OverviewPage overviewPage;
    private ThankYouPage thankYouPage;

    @BeforeTest
    public void setupPage() {
        this.loginPage = PageFactory.initElements(driver, LoginPage.class);
        this.mainPage = PageFactory.initElements(driver, MainPage.class);
        this.checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        this.orderInfoPage = PageFactory.initElements(driver, OrderInfoPage.class);
        this.overviewPage = PageFactory.initElements(driver, OverviewPage.class);
        this.thankYouPage = PageFactory.initElements(driver, ThankYouPage.class);
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
    }

    @Test(dependsOnMethods = {"login"})
    public void add_to_cart() {
        Assert.assertTrue(this.mainPage.getAddBtn().isDisplayed());
        this.mainPage.getAddBtn().setAddToCardBackpack();

        Assert.assertTrue(this.mainPage.getCart().isDisplayed());
        this.mainPage.getCart().clickCart();
    }

    @Test(dependsOnMethods = {"add_to_cart", "login"})
    public void checkout() {
        Assert.assertTrue(this.checkoutPage.getCheckout().isDisplayed());
        this.checkoutPage.getCheckout().clickCheckout();
    }

    @Test(dependsOnMethods = {"checkout", "add_to_cart", "login"}, dataProvider = "order")
    public void orderInformation(String firstname, String lastname, String postalCode) {
        Assert.assertTrue(this.orderInfoPage.getFirstname().isDisplayed());
        this.orderInfoPage.getFirstname().setFirstname(firstname);
        Assert.assertTrue(this.orderInfoPage.getLastname().isDisplayed());
        this.orderInfoPage.getLastname().setLastname(lastname);
        Assert.assertTrue(this.orderInfoPage.getPostalCode().isDisplayed());
        this.orderInfoPage.getPostalCode().setPostalCode(postalCode);
        Assert.assertTrue(this.orderInfoPage.getContinueBtn().isDisplayed());
        this.orderInfoPage.getContinueBtn().clickContinue();
    }

    @Test(dependsOnMethods = {"orderInformation", "checkout", "add_to_cart", "login"})
    public void overview() {
        Assert.assertTrue(this.overviewPage.getPrice().isDisplayed());
        Reporter.log(this.overviewPage.getPrice().getItemPrice());
        Reporter.log(this.overviewPage.getPrice().getTax());
        Reporter.log(this.overviewPage.getPrice().getTotalPrice());
        Assert.assertTrue(this.overviewPage.getFinishBtn().isDisplayed());
        this.overviewPage.getFinishBtn().clickFinish();
    }

    @Test(dependsOnMethods = {"overview","orderInformation", "checkout", "add_to_cart", "login"})
    public void thankyou() {
        Assert.assertTrue(this.thankYouPage.getThankYou().isDisplayed());
        Reporter.log(this.thankYouPage.getThankYou().getThankYouText());
    }


    @DataProvider(name = "data")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "order")
    public Object[][] orderData() {
        return new Object[][] {
                {"Chandrasekar", "Kumaran", "123456789"}
        };
    }
}
