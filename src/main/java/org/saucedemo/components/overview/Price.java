package org.saucedemo.components.overview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

public class Price extends AbstractComponent {

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement itemPrice;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement tax;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement totalPrice;


    public Price(WebDriver driver) {
        super(driver);
    }

    public String getItemPrice() {
        return this.itemPrice.getText();
    }

    public String getTax() {
        return this.tax.getText();
    }

    public String getTotalPrice() {
        return this.totalPrice.getText();
    }

    @Override
    public boolean isDisplayed() {
        Actions actions = new Actions(driver);
        actions.moveToElement(this.itemPrice).perform();
        actions.moveToElement(this.tax).perform();
        actions.moveToElement(this.totalPrice).perform();
        this.getWait().until(ExpectedConditions.visibilityOf(this.itemPrice));
        this.getWait().until(ExpectedConditions.visibilityOf(this.tax));
        this.getWait().until(ExpectedConditions.visibilityOf(this.totalPrice));

        return this.itemPrice.isDisplayed() && this.tax.isDisplayed() && this.totalPrice.isDisplayed();
    }
}
