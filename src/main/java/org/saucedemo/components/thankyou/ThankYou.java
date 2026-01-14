package org.saucedemo.components.thankyou;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

public class ThankYou extends AbstractComponent {

    @FindBy(xpath = "//h2[normalize-space()='Thank you for your order!']")
    private WebElement thankYou;

    public ThankYou(WebDriver driver) {
        super(driver);
    }

    public String getThankYouText() {
        return this.thankYou.getText();
    }

    @Override
    public boolean isDisplayed() {
        this.getWait().until(ExpectedConditions.visibilityOf(this.thankYou));
        return this.thankYou.isDisplayed();
    }
}
