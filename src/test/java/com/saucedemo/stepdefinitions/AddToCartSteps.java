package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.CartPage;
import com.saucedemo.utils.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddToCartSteps {

    private WebDriver driver;
    private CartPage cartPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        cartPage = new CartPage(driver);
    }

    @And("I add three items to the cart")
    public void add_three_items() {
        cartPage.addItemsToCart(3);
    }

    @And("I remove 1 item from the cart")
    public void remove_one_item() {
        cartPage.removeItemFromCart();
    }

    @And("I proceed to checkout")
    public void checkout() {
        cartPage.proceedToCheckout("Amandeep", "Kaur", "T6X0S3");
    }

    @Then("I should complete the purchase")
    public void complete_purchase() {
        cartPage.finishPurchase();
        Assert.assertTrue(cartPage.isPurchaseComplete());
    }
}

