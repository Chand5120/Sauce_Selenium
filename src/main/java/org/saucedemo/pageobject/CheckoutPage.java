package org.saucedemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.components.checkout.Checkout;

public class CheckoutPage {

    private final WebDriver driver;
    private final Checkout checkout;

    public CheckoutPage(final WebDriver driver) {
        this.driver = driver;
        this.checkout = PageFactory.initElements(driver, Checkout.class);
    }

    public Checkout getCheckout() {
        return checkout;
    }
}
