package org.saucedemo.components.mainpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

public class Cart extends AbstractComponent {

    @FindBy(className = "shopping_cart_link")
    private WebElement cart;

    public Cart(WebDriver driver) {
        super(driver);
    }

    public void clickCart() {
//        this.cart.click();
        this.clickBtn(this.cart);
    }

    @Override
    public boolean isDisplayed() {
        this.getWait().until(ExpectedConditions.visibilityOf(this.cart));
        return this.cart.isDisplayed();
    }
}
