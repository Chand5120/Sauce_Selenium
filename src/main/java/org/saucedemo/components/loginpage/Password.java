package org.saucedemo.components.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

public class Password extends AbstractComponent {

    @FindBy(id = "password")
    private WebElement password;

    public Password(final WebDriver driver) {
        super(driver);
    }

    public void setPassword(String password) {
//        this.password.clear();
//        this.password.sendKeys(password);
        this.enterText(this.password, password);
    }

    @Override
    public boolean isDisplayed() {
        this.getWait().until(ExpectedConditions.visibilityOf(this.password));

        return this.password.isDisplayed();
    }
}
