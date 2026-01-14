package org.saucedemo.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown() {
        if (this.driver != null) {
            driver.quit();
        }
    }
}