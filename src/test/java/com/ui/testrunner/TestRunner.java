package com.ui.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/FeaturesUI" }, glue = {
        "com.ui.stepdefinitions","com.ui.apphooks" }, tags = "@uitest", plugin = { "pretty", "html:test-output/report.html" })
public class TestRunner {
}
