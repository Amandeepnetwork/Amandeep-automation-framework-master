package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By addToCartButtons = By.cssSelector(".btn_inventory");
    private By cartIcon = By.className("shopping_cart_link");
    private By removeButton = By.cssSelector(".cart_button");
    private By checkoutButton = By.linkText("CHECKOUT");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.xpath("//input[@value='CONTINUE']");
    private By finishButton = By.linkText("FINISH");
    private By completeHeader = By.className("complete-header");
    private By totalLabel = By.className("summary_total_label");
    private By inventory_item = By.xpath("//div[@class='inventory_item']");

    // Methods
    public void addItemsToCart(int count) {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (int i = 0; i < count && i < buttons.size(); i++) {
            buttons.get(i).click();
        }
    }

    public void removeItemFromCart() {
        driver.findElement(cartIcon).click();
        driver.findElement(removeButton).click();
    }

    public void proceedToCheckout(String fname, String lname, String postal) {
        driver.findElement(checkoutButton).click();
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(postalCode).sendKeys(postal);
        driver.findElement(continueButton).click();
    }

    public void finishPurchase() {
        driver.findElement(finishButton).click();
    }

    public boolean isPurchaseComplete() {
        return driver.findElement(completeHeader).isDisplayed();
    }

    public double getTotalAmount() {
        String totalText = driver.findElement(totalLabel).getText().replace("Total: $", "");
        return Double.parseDouble(totalText);
    }
    public int getCount() {
        int totalCount = driver.findElements(inventory_item).size();
        return totalCount;
    }
}


