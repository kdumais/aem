package aem.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import aem.utils.Utils;

public class TempFirst extends BaseTest {
	public WebDriver driver;
	public Utils ut;
	public static SoftAssert softAssert;
	
	
	@Parameters ({"ffProfileName", "browser"})
	@BeforeMethod(groups= {"Important"})
	public void beforeMethod(String ffProfileName, String browser, ITestResult result) {
		driver = getDriver(ffProfileName, browser);
		ut = new Utils(driver, prop);
		Logger log = Logger.getLogger("Log");
		result.setAttribute("utils", ut);
		result.setAttribute("browser", browser);
		result.setAttribute("logger", log);
		softAssert = new SoftAssert();
	}
	
	@AfterMethod(groups= {"Important"})
	public void afterMethod() {
		driver.quit();
	}
		
	@Test(enabled=true, groups= {"Important"}, priority=1)
	public void lucid() {
		driver.get("https://www.lucidperspectives.com");
		ut.sleep(2000);
        softAssert.assertEquals(driver.getTitle(), "Home - Lucid PerspectivesERROR");
		ut.sleep(2000);
		ut.takeScreenShot("lucid.png");
		softAssert.assertAll();
	}
		
	@Test(enabled=true, groups= {"Important"}, priority=1)
	public void adobe() {
		driver.get("https://www.adobe.com");
        Assert.assertEquals(driver.getTitle(), "Adobe: Creative, marketing and document management solutions");
		ut.sleep(2000);
		ut.takeScreenShot("adobe.png");
	}
		
	@Test(enabled=true, groups= {"Not Important"}, priority=1)
	public void google() {
		driver.get("https://google.com");
		Assert.assertEquals(driver.getTitle(), "Google");
		ut.sleep(2000);
		ut.takeScreenShot("google.png");
		
		By boxBy = By.xpath("//input[@name='q']");
		WebElement element = driver.findElement(boxBy);
		ut.addBorder(element);
				
		ut.generateAlert("Please pay very close attendtion to the input box.");
		
		ut.sleep(5000);
		driver.switchTo().alert().accept();
		ut.sleep(2000);
		ut.refreshBrowserByJS();
		System.out.println("***************************");
		System.out.println(ut.getTitleByJS());
		ut.scrollPageDown();
		ut.sleep(5000);
		System.out.println(ut.getPageInnerText());
		
		By boxBy1 = By.xpath("//input[@name='q']");
		WebElement element1 = driver.findElement(boxBy1);
		ut.scrollIntoView(element1);
	}
	
	
}
