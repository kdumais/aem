package aem.tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import aem.pages.AssetPage;
import aem.pages.LogInPage;
import aem.utils.Utils;

public class AemOne2 extends BaseTest {
	public WebDriver driver;
	public Utils ut;
	public static SoftAssert softAssert;
	Logger log = LogManager.getLogger(AemOne2.class);
	LogInPage lp;
	AssetPage ap;
	
	@Parameters ({"ffProfileName", "browser"})
	@BeforeMethod
	public void beforeMethod(String ffProfileName, String browser, ITestResult result) {
		driver = getDriver(ffProfileName, browser);
		ut = new Utils(driver, prop);
		lp = new LogInPage(driver, prop);
		ap = new AssetPage(driver, prop);
		
		
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
	public void tencfa() {
		
		
		//Logger log = LogManager.getLogger("devLogger");
		log.error("My error message");
		driver.get(authorbaseurl+"/assets.html");
		lp.login("admin", "admin");
		ap.loadAssetPage();
		
		ap.createFolder("todayWed");
		ap.loadAssetPage();
		//ut.sleep(2000);
		
		driver.get(authorbaseurl+"/assets.html/content/dam/todaywed");
		System.out.println("one");
		
		ap.loadAssetPage();
						
		//ap.upload("HaloSC1.MP4");
		//ap.loadAssetPage();
								
		//ap.clickPropertiesIcon("HaloSC1.MP4");
		//ap.setTitle("first title");
		//ap.setDescription("first description");
		//ap.clickSaveAndClose();
		//ap.loadAssetPage();
		
		
		
		
		ut.sleep(5000);
	}
}
		
	
	
	
