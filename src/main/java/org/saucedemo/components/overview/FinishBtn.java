package org.saucedemo.components.overview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.saucedemo.components.AbstractComponent;

public class FinishBtn extends AbstractComponent {

    @FindBy(id = "finish")
    private WebElement finishBtn;

    public FinishBtn(WebDriver driver) {
        super(driver);
    }

    public void clickFinish() {
//        this.finishBtn.click();
        this.clickBtn(this.finishBtn);
    }

    @Override
    public boolean isDisplayed() {
        Actions actions = new Actions(driver);
        actions.moveToElement(finishBtn).perform();
        this.getWait().until(ExpectedConditions.visibilityOf(this.finishBtn));
        return this.finishBtn.isDisplayed();
    }
}
