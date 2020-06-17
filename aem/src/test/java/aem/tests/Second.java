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
	@BeforeMethod(groups= {"Not Important"})
	public void beforeMethod(String ffProfileName, String browser, ITestResult result) {
		driver = getDriver(ffProfileName, browser);
		ut = new Utils(driver, prop);
		result.setAttribute("utils", ut);
	}
	
	@AfterMethod(groups= {"Not Important"})
	public void afterMethod(ITestResult result) {
		driver.quit();
	}
	
	@Test(enabled=true, groups= {"Not Important"}, priority=1)
	public void cnn() {
		driver.get("https://cnn.com");
		Assert.assertEquals(driver.getTitle(), "CNN - Breaking News, Latest News and Videos");
		ut.sleep(2000);
		ut.takeScreenShot("cnn.png"); 
	 }
	
	@Test(enabled=true, groups= {"Not Important"}, priority=1)
	public void washpost() {
		driver.get("https://www.washingtonpost.com/");
		Assert.assertEquals(driver.getTitle(), "Washington Post: Breaking News, World, US, DC News & Analysis - The Washington Post");
		ut.sleep(2000);
		ut.takeScreenShot("seconda.png");
	}

}
