package org.saucedemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.components.overview.FinishBtn;
import org.saucedemo.components.overview.Price;

public class OverviewPage {

    private final WebDriver driver;
    private final FinishBtn finishBtn;
    private final Price price;

    public OverviewPage(final WebDriver driver) {
        this.driver = driver;
        this.finishBtn = PageFactory.initElements(driver, FinishBtn.class);
        this.price = PageFactory.initElements(driver, Price.class);
    }

    public FinishBtn getFinishBtn() {
        return finishBtn;
    }

    public Price getPrice() {
        return price;
    }
}
