package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class oneteamflipkart {
    public static void main(String[] args) {
        // Set the path to the correct version of the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open Flipkart
        driver.get("https://www.flipkart.com");

        // Close the login popup if it appears
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement closeLoginPopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'✕')]")));
            closeLoginPopup.click();
        } catch (Exception e) {
            System.out.println("Login popup did not appear.");
        }

        // Search for "women watches"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("women watches");
        searchBox.submit();

        // Wait for search results to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._1YokD2._3Mn1Gg")));

        // Clear the search box and search for "men watches"
        searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("men watches");
        searchBox.submit();

        // Wait for search results to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._1YokD2._3Mn1Gg")));

        // Select the first item from the search results
        WebElement firstItem = driver.findElement(By.cssSelector("._1fQZEK"));
        firstItem.click();

        // Switch to the new tab opened for the selected item
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        // Wait for the add to cart button to be clickable
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._2KpZ6l._2U9uOA._3v1-ww")));
        addToCartButton.click();

        // Increase the quantity to 2
        WebElement quantityDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._3dsJAO._24d-qY.FhkMJZ")));
        quantityDropdown.click();
        WebElement selectQuantity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_3uDYxP']//select/option[@value='2']")));
        selectQuantity.click();

        // Optionally, wait a few seconds to observe the result before closing the browser
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
