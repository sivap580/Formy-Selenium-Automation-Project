package com.tests;


	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class OneTeamMiniProject16FLIPKART {

		public static void main(String[] args) throws InterruptedException, AWTException {
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.navigate().to("https://www.flipkart.com/");
			driver.manage().window().maximize();
			
			//Search watches for women
			WebElement search = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input"));
			search.sendKeys("Watches for Women");
			Thread.sleep(1000);
			search.sendKeys(Keys.ENTER);
			
		    //clear search bar
			WebElement search1 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input"));
			Actions ae = new Actions(driver);
			ae.click(search1);
			
			ae.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
			
			search1.sendKeys("Watches for men");
			Thread.sleep(1000);
			search1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			//WebElement select = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[3]/div/div/a[1]"));
			WebElement select = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/a/div[1]/div/div/div/img"));
			select.click();
			WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(5000));
			waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"productRating_LSTWATF3DEDG52JR2TCTR8UWD_WATF3DEDG52JR2TC_\"]/div")));
			
		   // driver.findElement(By.xpath("//*[text()='ADD TO CART']")).click();
		   
			

		}

	}