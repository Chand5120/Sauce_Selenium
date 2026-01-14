package org.saucedemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.components.mainpage.AddBtn;
import org.saucedemo.components.mainpage.Cart;

public class MainPage {
    private final WebDriver driver;
    private final AddBtn addBtn;
    private final Cart cart;

    public MainPage(final WebDriver driver) {
        this.driver = driver;
        this.addBtn = PageFactory.initElements(driver, AddBtn.class);
        this.cart = PageFactory.initElements(driver, Cart.class);
    }

    public AddBtn getAddBtn() {
        return addBtn;
    }

    public Cart getCart() {
        return cart;
    }
}
