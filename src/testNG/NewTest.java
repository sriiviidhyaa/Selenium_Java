package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {
	WebDriver driver;
	
	@Test
	public void f() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
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
	  	String url = "https://www.google.com";
	  	driver.get(url);
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting the browser session");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Closing the browser session");
	  	driver.quit();
	}

}
