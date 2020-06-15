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
	
	@Parameters ({"ffProfileName", "browser"})
	@BeforeMethod
	public void beforeMethod(String ffProfileName, String browser, ITestResult result) {
		driver = getDriver(ffProfileName, browser);
		result.setAttribute("driver", driver);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
		
	@Test(enabled=true)
	public void firstcf() {
		System.out.println("firstcf");
		Utils ut = new Utils(driver);
		driver.get("https://www.lucidperspectives.com");
        ut.assertPageTitle("Home - Lucid Perspectives");
		ut.sleep(2000);
		ut.takeScreenShot(prop, "firstcf.png");
		Assert.assertEquals(5, 7);
	}
		
	@Test(enabled=true)
	public void secondcf() {
		System.out.println("secondcf");
		Utils ut = new Utils(driver);
		driver.get("https://www.adobe.com");
        ut.assertPageTitle("Adobe: Creative, marketing and document management solutions");
		ut.sleep(2000);
		ut.takeScreenShot(prop, "secondcf.png");
	}
		
	@Test(enabled=true)
	public void thirdcf() {
		System.out.println("thirdcf");
		Utils ut = new Utils(driver);
		driver.get(prop.getProperty("appurl"));
		ut.assertPageTitle("Google");
		ut.sleep(2000);
		ut.takeScreenShot(prop, "thirdcf.png");
	}
	
	
}
