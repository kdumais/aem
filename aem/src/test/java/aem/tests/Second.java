package aem.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import aem.utils.Utils;

public class Second extends BaseTest {
	public WebDriver driver;
	public Utils ut;
	
	@Parameters ({"ffProfileName", "browser"})
	@BeforeMethod
	public void beforeMethod(String ffProfileName, String browser, ITestResult result) {
		driver = getDriver(ffProfileName, browser);
		ut = new Utils(driver, prop);
		result.setAttribute("utils", ut);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		driver.quit();
	}
	
	@Test(enabled=true)
	public void firsta() {
		System.out.println("firsta");
		driver.get("https://cnn.com");
		Assert.assertEquals(driver.getTitle(), "CNN - Breaking News, Latest News and Videos");
		ut.sleep(2000);
		ut.takeScreenShot("firsta.png");
		driver.quit();
	}
	
	@Test(enabled=true)
	public void seconda() {
		System.out.println("seconda");
		driver.get("https://www.washingtonpost.com/");
		Assert.assertEquals(driver.getTitle(), "Washington Post: Breaking News, World, US, DC News & Analysis - The Washington Post");
		ut.sleep(2000);
		ut.takeScreenShot("seconda.png");
		driver.quit();
	}

}
