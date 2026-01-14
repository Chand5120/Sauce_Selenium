package org.saucedemo.components.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

import javax.swing.*;

public class Checkout extends AbstractComponent {

    @FindBy(id = "checkout")
    private WebElement checkout;

    public Checkout(WebDriver driver) {
        super(driver);
    }

    public void clickCheckout() {
        this.clickBtn(checkout);
    }

    @Override
    public boolean isDisplayed() {
        Actions actions = new Actions(driver);
        actions.moveToElement(this.checkout);
        this.getWait().until(ExpectedConditions.visibilityOf(this.checkout));
        return this.checkout.isDisplayed();
    }
}