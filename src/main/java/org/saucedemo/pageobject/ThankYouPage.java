package org.saucedemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.components.orderinformation.Continue;
import org.saucedemo.components.orderinformation.Firstname;
import org.saucedemo.components.orderinformation.Lastname;
import org.saucedemo.components.thankyou.ThankYou;

public class ThankYouPage {
    private final WebDriver driver;
    private final ThankYou thankYou;

    public ThankYouPage(final WebDriver driver) {
        this.driver = driver;
        this.thankYou = PageFactory.initElements(driver, ThankYou.class);
    }

    public ThankYou getThankYou() {
        return thankYou;
    }
}
