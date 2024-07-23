package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

public class oneteamproject2 {

    public static void main(String[] args) {
    	
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
    	
        // Setup ChromeDriver using WebDriverManager
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the automation practice form
            driver.get("https://demoqa.com/automation-practice-form");
            driver.manage().window().maximize();

            // Fill in the form details
            driver.findElement(By.id("firstName")).sendKeys("Siva");
            driver.findElement(By.id("lastName")).sendKeys("Prasad");
            driver.findElement(By.id("userEmail")).sendKeys("spvsivaprasad@gmail.com");
            driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
            driver.findElement(By.id("userNumber")).sendKeys("8921849146");

            // Set the date of birth
            driver.findElement(By.id("dateOfBirthInput")).click();
            driver.findElement(By.cssSelector(".react-datepicker__year-select")).sendKeys("1990");
            driver.findElement(By.cssSelector(".react-datepicker__month-select")).sendKeys("October");
            driver.findElement(By.cssSelector(".react-datepicker__day--008")).click();

            // Subjects
            WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
            subjectsInput.sendKeys("Maths");
            subjectsInput.sendKeys("\n");

            // Hobbies
            driver.findElement(By.xpath("//label[contains(text(),'Sports')]")).click();
            driver.findElement(By.xpath("//label[contains(text(),'Reading')]")).click();
            driver.findElement(By.xpath("//label[contains(text(),'Music')]")).click();

            // Address
            driver.findElement(By.id("currentAddress")).sendKeys("123 Main St, Anytown, USA");

            // State and City - using Select class
            WebElement stateDropdown = driver.findElement(By.id("state"));
            stateDropdown.click();
            driver.findElement(By.xpath("//div[contains(text(),'NCR')]")).click();

            WebElement cityDropdown = driver.findElement(By.id("city"));
            cityDropdown.click();
            driver.findElement(By.xpath("//div[contains(text(),'Delhi')]")).click();

            // Submit the form
            driver.findElement(By.id("submit")).click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            // driver.quit();
        }
    }
}
