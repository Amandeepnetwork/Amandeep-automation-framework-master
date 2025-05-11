package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By inventoryItems = By.className("inventory_item");
    private By cartLink = By.className("shopping_cart_link");

    // Methods
    public double addItemsUntilMinimum(double minTotal) {
        double total = 0;
        List<WebElement> items = driver.findElements(inventoryItems);

        for (WebElement item : items) {
            if (total >= minTotal) break;
            String priceText = item.findElement(By.className("inventory_item_price")).getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            item.findElement(By.tagName("button")).click();
            total += price;
        }
        return total;
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }
}
