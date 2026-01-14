package org.saucedemo.components.orderinformation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

public class Firstname extends AbstractComponent {

    @FindBy(id = "first-name")
    private WebElement firstname;

    public Firstname(WebDriver driver) {
        super(driver);
    }

    public void setFirstname(String firstname) {
//        this.firstname.sendKeys(firstname);
        enterText(this.firstname, firstname);
    }

    @Override
    public boolean isDisplayed() {
        this.getWait().until(ExpectedConditions.visibilityOf(this.firstname));
        return this.firstname.isDisplayed();
    }
}
