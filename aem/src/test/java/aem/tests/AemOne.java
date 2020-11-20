package aem.tests;

import org.apache.log4j.Logger;
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

public class AemOne extends BaseTest {
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
	
	@Test(enabled=false)
	public void firstcf() {
		LogInPage lp = new LogInPage(driver, prop);
		driver.get("http://localhost:6502");
		
		System.out.println("********************************************************");
		System.out.println(ut.getNumberOfElementsOnPage());
						
        ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		ut.takeScreenShot("login.png");
		lp.login("admin", "admin");
		ut.takeScreenShot("login2.png");
	}
	
	@Test(enabled=false)
	public void secondcf() {
		LogInPage lp = new LogInPage(driver, prop);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://localhost:6502");
        ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		ut.takeScreenShot("secondlogina.png");
		lp.login("admin", "admin");
		ut.takeScreenShot("secondloginb.png");
		
		driver.get("http://localhost:6502/assets.html/content/dam/mysite");
		ap.waitForPageToLoad();
		ap.upload("485A7246.jpg");
		ut.sleep(5000);
	}
	
	@Test(enabled=false)
	public void thirdcf() {
		LogInPage lp = new LogInPage(driver, prop);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://localhost:6502");
        ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		ut.takeScreenShot("thirdlogina.png");
		lp.login("admin", "admin");
		ut.takeScreenShot("thirdloginb.png");
		driver.get("http://localhost:6502/assets.html/content/dam/mysite");
				
		ap.upload("485A7230.jpg");
		ut.sleep(5000);
	}
	
	@Test(enabled=false)
	public void fourthcf() {
		LogInPage lp = new LogInPage(driver, prop);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://localhost:6502");
        ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		//ut.takeScreenShot(prop, "fourthlogina.png");
		lp.login("admin", "admin");
		//ut.takeScreenShot(prop, "fourthloginb.png");
		driver.get("http://localhost:6502/assets.html/content/dam/mysite");
			
		ap.upload("485A7214.jpg");
		ap.upload("485A7215.jpg");
		ap.upload("485A7216.jpg");
		ap.upload("485A7220.jpg");
		ap.upload("485A7221.jpg");
		ap.upload("485A7222.jpg");
		ap.upload("485A7223.jpg");
		ap.upload("485A7224.jpg");
		ap.upload("485A7225.jpg");
		ap.upload("485A7226.jpg");
		ap.upload("485A7227.jpg");
		ap.upload("485A7228.jpg");
		ap.upload("485A7229.jpg");
		ap.upload("485A7230.jpg");
		ap.upload("485A7231.jpg");
		ap.upload("485A7232.jpg");
		ap.upload("485A7233.jpg");
		ap.upload("485A7234.jpg");
		ap.upload("485A7235.jpg");
		ap.upload("485A7236.jpg");
		ap.upload("485A7237.jpg");
		ap.upload("485A7238.jpg");
		ap.upload("485A7239.jpg");
		ap.upload("485A7240.jpg");
		ap.upload("485A7241.jpg");
		ap.upload("485A7242.jpg");
		ap.upload("485A7243.jpg");
		ap.upload("485A7244.jpg");
		ap.upload("485A7245.jpg");
		ap.upload("485A7246.jpg");
		ap.upload("485A7247.jpg");
		ap.upload("485A7248.jpg");
		ap.upload("485A7249.jpg");
				
		ut.sleep(10000);
	}
	
	@Test(enabled=false)
	public void fifthcf() {
		LogInPage lp = new LogInPage(driver, prop);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://localhost:6502");
        ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		lp.login("admin", "admin");
		driver.get("http://localhost:6502/assets.html/content/dam/mysite");
		
		ap.clickContentOnlyButton();		
		ap.clickListFilter();
		//ap.clickAccordion("File Type");
		ap.clickAccordion("File Size");
		//ap.clickAccordion("Last Modified");
		//ap.clickAccordion("Status");
		//ap.clickAccordion("Orientation");
		//ap.clickAccordion("Style");
		//ap.clickAccordion("Insights");
		//ap.clickAccordion("Adobe Stock");
		//ap.clickAccordion("UGC");
		ut.sleep(60000);
		ap.enterMinMaxFileSize("1", "2");
		
		
		
		
		ut.sleep(5000);
	}
	
	@Test(enabled=false)
	public void sixthcf() {
		LogInPage lp = new LogInPage(driver, prop);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://ec2-3-86-179-38.compute-1.amazonaws.com:6502");
        ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		lp.login("admin", "admin");
		driver.get("http://ec2-3-86-179-38.compute-1.amazonaws.com:6502/assets.html/content/dam/today");
		/*	
		ap.upload("485A7214.JPG");
		ap.upload("485A7215.JPG");
		ap.upload("485A7216.JPG");
		ap.upload("485A7220.JPG");
		ap.upload("485A7221.JPG");
		ap.upload("485A7222.JPG");
		ap.upload("485A7223.JPG");
		ap.upload("485A7224.JPG");
		ap.upload("485A7225.JPG");
		ap.upload("485A7226.JPG");
		ap.upload("485A7227.JPG");
		ap.upload("485A7228.JPG");
		ap.upload("485A7229.JPG");
		ap.upload("485A7230.JPG");
		ap.upload("485A7231.JPG");
		ap.upload("485A7232.JPG");
		ap.upload("485A7233.JPG");
		ap.upload("485A7234.JPG");
		ap.upload("485A7235.JPG");
		ap.upload("485A7236.JPG");
		ap.upload("485A7237.JPG");
		ap.upload("485A7238.JPG");
		ap.upload("485A7239.JPG");
		ap.upload("485A7240.JPG");
		ap.upload("485A7241.JPG");
		ap.upload("485A7242.JPG");
		ap.upload("485A7243.JPG");
		ap.upload("485A7244.JPG");
		ap.upload("485A7245.JPG");
		ap.upload("485A7246.JPG");
		ap.upload("485A7247.JPG");
		ap.upload("485A7248.JPG");
		ap.upload("485A7249.JPG");
		
		ap.upload("485A7214a.JPG");
		ap.upload("485A7215a.JPG");
		ap.upload("485A7216a.JPG");
		ap.upload("485A7220a.JPG");
		ap.upload("485A7221a.JPG");
		ap.upload("485A7222a.JPG");
		ap.upload("485A7223a.JPG");
		ap.upload("485A7224a.JPG");
		ap.upload("485A7225a.JPG");
		ap.upload("485A7226a.JPG");
		ap.upload("485A7227a.JPG");
		ap.upload("485A7228a.JPG");
		ap.upload("485A7229a.JPG");
		ap.upload("485A7230a.JPG");
		ap.upload("485A7231a.JPG");
		ap.upload("485A7232a.JPG");
		ap.upload("485A7233a.JPG");
		ap.upload("485A7234a.JPG");
		ap.upload("485A7235a.JPG");
		ap.upload("485A7236a.JPG");
		ap.upload("485A7237a.JPG");
		ap.upload("485A7238a.JPG");
		ap.upload("485A7239a.JPG");
		ap.upload("485A7240a.JPG");
		ap.upload("485A7241a.JPG");
		ap.upload("485A7242a.JPG");
		ap.upload("485A7243a.JPG");
		ap.upload("485A7244a.JPG");
		ap.upload("485A7245a.JPG");
		ap.upload("485A7246a.JPG");
		ap.upload("485A7247a.JPG");
		ap.upload("485A7248a.JPG");
		ap.upload("485A7249a.JPG");
		*/
		ap.upload("485A7214b.JPG");
		ap.upload("485A7215b.JPG");
		ap.upload("485A7216b.JPG");
		ap.upload("485A7220b.JPG");
		ap.upload("485A7221b.JPG");
		ap.upload("485A7222b.JPG");
		ap.upload("485A7223b.JPG");
		ap.upload("485A7224b.JPG");
		ap.upload("485A7225b.JPG");
		ap.upload("485A7226b.JPG");
		ap.upload("485A7227b.JPG");
		ap.upload("485A7228b.JPG");
		ap.upload("485A7229b.JPG");
		ap.upload("485A7230b.JPG");
		ap.upload("485A7231b.JPG");
		ap.upload("485A7232b.JPG");
		ap.upload("485A7233b.JPG");
		ap.upload("485A7234b.JPG");
		ap.upload("485A7235b.JPG");
		ap.upload("485A7236b.JPG");
		ap.upload("485A7237b.JPG");
		ap.upload("485A7238b.JPG");
		ap.upload("485A7239b.JPG");
		ap.upload("485A7240b.JPG");
		ap.upload("485A7241b.JPG");
		ap.upload("485A7242b.JPG");
		ap.upload("485A7243b.JPG");
		ap.upload("485A7244b.JPG");
		ap.upload("485A7245b.JPG");
		ap.upload("485A7246b.JPG");
		ap.upload("485A7247b.JPG");
		ap.upload("485A7248b.JPG");
		ap.upload("485A7249b.JPG");
		
		ut.sleep(10000);
	}
	
	@Test(enabled=true)
	public void sevencf() {
		LogInPage lp = new LogInPage(driver, prop);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://ec2-3-93-190-82.compute-1.amazonaws.com:6502");
        lp.login("admin", "admin");
		driver.get("http://ec2-3-93-190-82.compute-1.amazonaws.com:6502/assets.html/content/dam/today");
		/*
		ap.propertiesCard("485A7214.JPG");
		ap.setTitle("My New Title");
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		
		ap.propertiesCard("485A7215.JPG");
		ap.setTitle("My New Title");
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		
		ap.propertiesCard("485A7216.JPG");
		ap.setTitle("My New Title");
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		
		ap.propertiesCard("485A7220.JPG");
		ap.setTitle("My New Title");
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		*/				
		//ut.sleep(8000);
		
		ap.propertiesCard("485A7248b.JPG");
		ap.setTitle("My New Title");
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		
		//ut.sleep(5000);
		
		ap.propertiesCard("485A7214.JPG");
		ap.setTitle("My New Title");
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		
		ap.propertiesCard("485A7249b.JPG");
		ap.setTitle("My New Title");
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		
		ut.sleep(10000);
	}
}
