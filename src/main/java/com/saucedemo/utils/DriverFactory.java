package com.saucedemo.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverFactory {

    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            String driverPath = ConfigReader.getProperty("webdriver.gecko.driver");
            System.setProperty("webdriver.gecko.driver", driverPath.replace("\\", File.separator));
            driver = new FirefoxDriver();
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
