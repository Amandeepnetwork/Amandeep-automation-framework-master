package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.utils.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderWithValueSteps {
    private WebDriver driver;
    private InventoryPage inventoryPage;
    private CartPage cartPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }

    @And("I add items to get total between $30 and $60")
    public void add_items_for_total_range() {
        inventoryPage.addItemsUntilMinimum(30.0);
        inventoryPage.goToCart();
    }

    @Then("the total amount should be between $30 and $60")
    public void verify_total_amount() {
        double total = cartPage.getTotalAmount();
        Assert.assertTrue("Total was: $" + total, total >= 30 && total <= 60);
    }
}