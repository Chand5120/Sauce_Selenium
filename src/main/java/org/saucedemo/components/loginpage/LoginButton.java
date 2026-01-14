package org.saucedemo.components.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

public class LoginButton extends AbstractComponent {

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public LoginButton(final WebDriver driver) {
        super(driver);
    }

    public void clickLoginBtn() {
//        this.loginBtn.click();
        this.clickBtn(loginBtn);
    }

    @Override
    public boolean isDisplayed() {
        this.getWait().until(ExpectedConditions.visibilityOf(loginBtn));
        return this.loginBtn.isDisplayed();
    }
}
