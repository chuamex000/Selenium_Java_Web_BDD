package org.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources",        // Tells Cucumber where your .feature file is
        glue = "org.example.stepDefinitions",   // Tells Cucumber where your Java code is
        plugin = {"pretty", "html:target/cucumber-reports.html"} // Generates a nice test report
)
public class TestRunner {
}