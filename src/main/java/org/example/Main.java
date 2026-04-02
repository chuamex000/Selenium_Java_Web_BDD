package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Start the browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // --- TC 1: Error Login ---
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("incorrectUser");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        // Wait a moment for the error message to appear
        Thread.sleep(1000);
        WebElement errorMsg = driver.findElement(By.id("error"));
        System.out.println("TC 1 (Error Login) Result: " + errorMsg.getText());

        // --- TC 2: Successful Login ---
        driver.navigate().refresh();
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        Thread.sleep(1000);
        if (driver.getCurrentUrl().contains("logged-in-successfully")) {
            System.out.println("TC 2 (Successful Login) Result: PASSED");
        }

        // --- TC 3: Successful Log Out ---
        driver.findElement(By.linkText("Log out")).click();

        Thread.sleep(1000);
        if (driver.getCurrentUrl().contains("practice-test-login")) {
            System.out.println("TC 3 (Successful Log Out) Result: PASSED");
        }

        // Close the browser session
        driver.quit();
    }
}