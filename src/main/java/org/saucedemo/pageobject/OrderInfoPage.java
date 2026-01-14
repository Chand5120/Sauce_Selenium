package org.saucedemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.components.orderinformation.Continue;
import org.saucedemo.components.orderinformation.Firstname;
import org.saucedemo.components.orderinformation.Lastname;
import org.saucedemo.components.orderinformation.PostalCode;

public class OrderInfoPage {

    private final WebDriver driver;
    private final Continue continueBtn;
    private final Firstname firstname;
    private final Lastname lastname;
    private final PostalCode postalCode;

    public OrderInfoPage(final WebDriver driver) {
        this.driver = driver;
        this.continueBtn = PageFactory.initElements(driver, Continue.class);
        this.firstname = PageFactory.initElements(driver, Firstname.class);
        this.lastname = PageFactory.initElements(driver, Lastname.class);
        this.postalCode = PageFactory.initElements(driver, PostalCode.class);
    }

    public Continue getContinueBtn() {
        return continueBtn;
    }

    public Firstname getFirstname() {
        return firstname;
    }

    public Lastname getLastname() {
        return lastname;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }
}
