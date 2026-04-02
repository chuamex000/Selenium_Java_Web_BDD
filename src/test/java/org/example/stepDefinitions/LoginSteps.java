package org.example.stepDefinitions;

import io.cucumber.java.en.*;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LoginSteps {
    WebDriver driver = new ChromeDriver();
    LoginPage login = new LoginPage(driver);

    @Given("I am on the login page")
    public void openBrowser() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("I enter username {string} and password {string}")
    public void enter_credentials(String user, String pass) {
        login.enterUsername(user);
        login.enterPassword(pass);
    }

    @And("I click the submit button")
    public void click_login() {
        login.clickSubmit();
    }

    @Then("I should see an error message {string}")
    public void verify_error(String expected) {
        Assert.assertEquals(expected, login.getError());
        driver.quit();
    }

    @Then("I should be redirected to the {string} page")
    public void verify_redirection(String pageName) {
        // Wait for the URL to change
        String currentUrl = driver.getCurrentUrl();

        // Check if the URL contains the expected text
        Assert.assertTrue("The URL does not contain " + pageName, currentUrl.contains(pageName));

        // Close the browser after success
        driver.quit();
    }
}