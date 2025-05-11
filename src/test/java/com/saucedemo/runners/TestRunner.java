package com.saucedemo.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/saucedemo/features",
        glue = "com.saucedemo.stepdefinitions",

        plugin = {
                "pretty",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", // Ensures results are generated in allure-results
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-reports/cucumber-reports.html"
        },
        monochrome = true
)
public class TestRunner {}
