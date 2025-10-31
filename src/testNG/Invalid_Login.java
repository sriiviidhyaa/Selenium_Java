package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Invalid_Login {
	WebDriver driver;
	
	@Test
	public void doLogin() {
		driver.findElement(By.id("user-name")).sendKeys("locked_out__user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        AssertJUnit.assertEquals("Login failed: URL mismatch", expectedUrl, driver.getCurrentUrl());
        System.out.println("Testcase completed successfully");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting the browser session");
		String browser = System.getProperty("browser", "chrome");
		if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Unsupported browser: " + browser);
            return;
        }
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Closing the browser session");
	  	driver.quit();
	}
}
