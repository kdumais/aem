package aem.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import aem.utils.Utils;

public class First extends BaseTest {
	public WebDriver driver;
	public Utils ut;
	
	@Parameters ({"ffProfileName", "browser"})
	@BeforeMethod(groups= {"Important"})
	public void beforeMethod(String ffProfileName, String browser, ITestResult result) {
		driver = getDriver(ffProfileName, browser);
		ut = new Utils(driver, prop);
		result.setAttribute("utils", ut);
	}
	
	@AfterMethod(groups= {"Important"})
	public void afterMethod() {
		driver.quit();
	}
		
	@Test(enabled=true, groups= {"Important"}, priority=1)
	public void lucid() {
		driver.get("https://www.lucidperspectives.com");
		ut.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Home - Lucid PerspectivesERROR");
		ut.sleep(2000);
		ut.takeScreenShot("lucid.png");
	}
		
	@Test(enabled=true, groups= {"Important"}, priority=1)
	public void adobe() {
		driver.get("https://www.adobe.com");
        Assert.assertEquals(driver.getTitle(), "Adobe: Creative, marketing and document management solutions");
		ut.sleep(2000);
		ut.takeScreenShot("adobe.png");
	}
		
	@Test(enabled=true, groups= {"Important"}, priority=1)
	public void google() {
		driver.get("https://google.com");
		Assert.assertEquals(driver.getTitle(), "Google");
		ut.sleep(2000);
		ut.takeScreenShot("google.png");
	}
	
	
}
