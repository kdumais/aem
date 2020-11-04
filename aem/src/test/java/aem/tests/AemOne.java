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
		driver.get("http://ec2-3-87-65-195.compute-1.amazonaws.com:6502");
        ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		lp.login("admin", "admin");
		driver.get("http://ec2-3-87-65-195.compute-1.amazonaws.com:6502/assets.html/content/dam/today");
			
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
	
	@Test(enabled=true)
	public void sevencf() {
		LogInPage lp = new LogInPage(driver, prop);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://ec2-18-212-17-242.compute-1.amazonaws.com:6502");
        lp.login("admin", "admin");
		driver.get("http://ec2-18-212-17-242.compute-1.amazonaws.com:6502/assets.html/content/dam/today");
		
		//ut.sleep(3000);
		ap.propertiesCard("485A7214.JPG");
		//ut.sleep(3000);
		ap.setTitle("My New Title");
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		
		ap.propertiesCard("485A7215.JPG");
		ap.setTitle("My New Title");
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		
		
		
		
		ut.sleep(10000);
	}
}
