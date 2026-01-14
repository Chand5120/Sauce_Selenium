package org.saucedemo.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractComponent {
    protected WebDriver driver;
    private WebDriverWait wait;

    public abstract boolean isDisplayed();

    public AbstractComponent(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void clickBtn(WebElement element) {
        element.click();
    }

    protected WebDriverWait getWait(){
        if (wait == null) {
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }
        return wait;
    }
}