package org.saucedemo.components.orderinformation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

public class Continue extends AbstractComponent {

    @FindBy(id = "continue")
    private WebElement continueBtn;

    public Continue(final WebDriver driver) {
        super(driver);
    }

    public void clickContinue() {
//        this.continueBtn.click();
        this.clickBtn(this.continueBtn);
    }

    @Override
    public boolean isDisplayed() {
        Actions actions = new Actions(driver);
        actions.moveToElement(this.continueBtn).perform();
        this.getWait().until(ExpectedConditions.visibilityOf(this.continueBtn));
        return this.continueBtn.isDisplayed();
    }
}
