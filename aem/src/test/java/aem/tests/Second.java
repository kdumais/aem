package aem.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import aem.utils.Utils;

public class Second extends BaseTest {
	public WebDriver driver;
	
	@Parameters ({"ffProfileName", "browser"})
	@BeforeMethod
	public void beforeMethod(String ffProfileName, String browser) {
		driver = getDriver(ffProfileName, browser);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		driver.quit();
	}
	
	@Test(enabled=true)
	public void firsta() {
		System.out.println("firsta");
		Utils ut = new Utils(driver);
		driver.get("https://cnn.com");
		ut.assertPageTitle("CNN - Breaking News, Latest News and Videos");
		ut.sleep(2000);
		ut.takeScreenShot(prop, "firsta.png");
		driver.quit();
	}
	
	@Test(enabled=true)
	public void seconda() {
		System.out.println("seconda");
		Utils ut = new Utils(driver);
        driver.get("https://www.washingtonpost.com/");
		ut.assertPageTitle("Washington Post: Breaking News, World, US, DC News & Analysis - The Washington Post");
		ut.sleep(2000);
		ut.takeScreenShot(prop, "seconda.png");
		driver.quit();
	}

}
