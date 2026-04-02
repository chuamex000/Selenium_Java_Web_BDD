package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    // Locators - High level maintenance: Change these once, and all tests fix!
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By submitButton = By.id("submit");
    By errorMessage = By.id("error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String user) { driver.findElement(usernameField).sendKeys(user); }
    public void enterPassword(String pass) { driver.findElement(passwordField).sendKeys(pass); }
    public void clickSubmit() { driver.findElement(submitButton).click(); }
    public String getError() {
        // Wait up to 10 seconds for the error message to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));

        return driver.findElement(errorMessage).getText();
    }
}