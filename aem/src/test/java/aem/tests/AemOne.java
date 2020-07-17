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
				
		ap.upload("485A7240.jpg");
		ut.sleep(5000);
	}
	
	@Test(enabled=true)
	public void fifthcf() {
		LogInPage lp = new LogInPage(driver, prop);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://localhost:6502");
        ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		lp.login("admin", "admin");
		driver.get("http://localhost:6502/assets.html/content/dam/mysite");
				
		
		ut.sleep(5000);
	}
}
