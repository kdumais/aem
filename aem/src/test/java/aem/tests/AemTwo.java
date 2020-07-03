package aem.tests;

import java.awt.Desktop.Action;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import aem.pages.AssetPage;
import aem.pages.LogInPage;
import aem.utils.Utils;

public class AemTwo extends BaseTest {
	public WebDriver driver;
	public Utils ut;
	public static SoftAssert softAssert;
	
	@Parameters ({"ffProfileName", "browser"})
	@BeforeMethod
	public void beforeMethod(String ffProfileName, String browser, ITestResult result) {
		driver = getDriver(ffProfileName, browser);
		ut = new Utils(driver, prop);
		Logger log = Logger.getLogger("Log");
		result.setAttribute("utils", ut);
		result.setAttribute("browser", browser);
		result.setAttribute("logger", log);
		softAssert = new SoftAssert();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		driver.quit();
	}
	
	@Test(enabled=true)
	public void asset() {
		LogInPage lp = new LogInPage(driver, prop);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://localhost:4502/assets.html/content/dam");
		ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		lp.login("admin", "admin");
		ap.waitForPageToLoad();
		ap.clickAssetCard("WKND Site");
		ap.clickAssetCard("English");
		ap.clickAssetCard("Adventures");
		ap.clickAssetCard("Whistler Mountain Biking");
		ap.propertiesCard("Canadian Mountainscape in Summer at Garibaldi Provincial Park");
		
		ap.setTitle("My New Title");
		ap.setDescription("My New Description");
		ap.setOnTime("07-02-2020 11:33");
		ap.setOffTime("07-02-2020 11:33");
		ap.selectLanguage("English");
		System.out.println(ap.getNumberOfTags());
		
		
		
		
		
		ut.sleep(5000);
	}
		
}
