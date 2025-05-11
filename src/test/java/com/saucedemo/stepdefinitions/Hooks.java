package com.saucedemo.stepdefinitions;

import com.saucedemo.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    private static final String SCREENSHOT_DIR = "D:\\Selenium frameworks\\automation-framework\\target\\screenshots";

    @After
    public void takeScreenshotOnFailure(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            // Create the screenshot directory if it doesn't exist
            File screenshotDir = new File(SCREENSHOT_DIR);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs(); // Create the directory
            }

            // Capture the screenshot
            File screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            // Delete file if it exists
            Path destinationPath = Paths.get(SCREENSHOT_DIR, scenario.getName()  + "_" + timestamp + ".png");
            Files.deleteIfExists(destinationPath);
            try {
                // Copy the screenshot to the target location
                Files.copy(screenshot.toPath(), destinationPath);
                // Optionally attach the screenshot to the report
                scenario.attach(Files.readAllBytes(destinationPath), "image/png", scenario.getName() + ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

       //Quit driver after test completion
        DriverFactory.quitDriver();
    }
}