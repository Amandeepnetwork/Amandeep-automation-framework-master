package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ConfigReader;
import com.saucedemo.utils.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_saucedemo_login_page() {
        driver.get(ConfigReader.getProperty("app.url"));
        driver.manage().window().maximize();
    }

    @When("I enter a valid username and password")
    public void i_enter_a_valid_username_and_password() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the Products page")
    public void i_should_be_redirected_to_the_products_page() {
        String expectedTitle = "Swag Labs"; // Adjust this if necessary based on actual title
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
