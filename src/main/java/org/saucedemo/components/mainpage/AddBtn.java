package org.saucedemo.components.mainpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

public class AddBtn extends AbstractComponent {

    @FindBy(id= "add-to-cart-sauce-labs-backpack")
    private WebElement addToCardBackpack;

    public AddBtn(WebDriver driver) {
        super(driver);
    }

    public void setAddToCardBackpack() {
//        this.addToCardBackpack.click();
        this.clickBtn(addToCardBackpack);
    }

    @Override
    public boolean isDisplayed() {
        this.getWait().until(ExpectedConditions.visibilityOf(addToCardBackpack));
        return this.addToCardBackpack.isDisplayed();
    }
}
