package org.saucedemo.components.orderinformation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

public class PostalCode extends AbstractComponent {

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    public PostalCode(WebDriver driver) {
        super(driver);
    }

    public void setPostalCode(String postalCode) {
//        this.postalCode.sendKeys(postalCode);
        this.enterText(this.postalCode, postalCode);
    }

    @Override
    public boolean isDisplayed() {
        this.getWait().until(ExpectedConditions.visibilityOf(this.postalCode));
        return this.postalCode.isDisplayed();
    }
}
