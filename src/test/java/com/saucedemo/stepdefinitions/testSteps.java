package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.CartPage;
import com.saucedemo.utils.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class testSteps {
    private WebDriver driver;
    private CartPage cartPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        cartPage = new CartPage(driver);
    }

    @Then("I should validate the count of products")
    public void count_of_products() {
        int expectedCount = 6; // Adjust this if necessary based on actual count
        int actualCount = cartPage.getCount();
        Assert.assertEquals(expectedCount, actualCount);
    }
}
