package org.saucedemo.components.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

public class Username extends AbstractComponent {

    @FindBy(id = "user-name")
    private WebElement username;


    public Username(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username) {
//        this.username.clear();
//        this.username.sendKeys(username);
        this.enterText(this.username, username);
    }

    @Override
    public boolean isDisplayed() {
        this.getWait().until(ExpectedConditions.visibilityOf(username));
        return this.username.isDisplayed();
    }
}
