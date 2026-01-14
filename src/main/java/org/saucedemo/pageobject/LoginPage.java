package org.saucedemo.pageobject;

import org.saucedemo.components.loginpage.LoginButton;
import org.saucedemo.components.loginpage.Password;
import org.saucedemo.components.loginpage.Username;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;
    private final Username username;
    private final Password password;
    private final LoginButton loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.username = PageFactory.initElements(driver, Username.class);
        this.password = PageFactory.initElements(driver, Password.class);
        this.loginButton = PageFactory.initElements(driver, LoginButton.class);
    }

    public void goTo() {
        this.driver.get("https://www.saucedemo.com/");
    }

    public LoginButton getLoginButton() {
        return loginButton;
    }

    public Password getPassword() {
        return password;
    }

    public Username getUsername() {
        return username;
    }
}
