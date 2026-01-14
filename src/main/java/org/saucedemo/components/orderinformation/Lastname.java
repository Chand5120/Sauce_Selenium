package org.saucedemo.components.orderinformation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

public class Lastname extends AbstractComponent {

    @FindBy(id = "last-name")
    private WebElement lastname;

    public Lastname(WebDriver driver) {
        super(driver);
    }

    public void setLastname(String lastname) {
//        this.lastname.sendKeys(lastname);
        this.enterText(this.lastname, lastname);
    }

    @Override
    public boolean isDisplayed() {
        this.getWait().until(ExpectedConditions.visibilityOf(this.lastname));

        return this.lastname.isDisplayed();
    }
}
