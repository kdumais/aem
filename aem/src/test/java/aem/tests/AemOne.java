package aem.tests;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import aem.pages.AssetPage;
import aem.pages.LogInPage;
import aem.utils.Utils;

public class AemOne extends BaseTest {
	
	@Parameters ({"ffProfileName", "browser"})
	@Test(enabled=false)
	public void firstcf(String ffProfileName, String browser) {
		WebDriver driver = getDriver(ffProfileName, browser);
		Utils ut = new Utils(driver);
		LogInPage lp = new LogInPage(driver);
		driver.get("http://localhost:6502");
		
		System.out.println("********************************************************");
		System.out.println(ut.getNumberOfElementsOnPage());
						
        ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		ut.takeScreenShot(prop, "login.png");
		lp.login("admin", "admin");
		ut.takeScreenShot(prop, "login2.png");
		driver.quit();

	}
	
	@Parameters ({"ffProfileName", "browser"})
	@Test(enabled=true)
	public void secondcf(String ffProfileName, String browser) {
		WebDriver driver = getDriver(ffProfileName, browser);
		Utils ut = new Utils(driver);
		LogInPage lp = new LogInPage(driver);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://localhost:6502");
        ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		ut.takeScreenShot(prop, "secondlogina.png");
		lp.login("admin", "admin");
		ut.takeScreenShot(prop, "secondloginb.png");
		
		driver.get("http://localhost:6502/assets.html/content/dam/mysite");
		ap.waitForPageToLoad();
		ap.upload("485A7246.jpg");
		ut.sleep(5000);
		
		driver.quit();

	}
	
	@Parameters ({"ffProfileName", "browser"})
	@Test(enabled=false)
	public void thirdcf(String ffProfileName, String browser) {
		WebDriver driver = getDriver(ffProfileName, browser);
		Utils ut = new Utils(driver);
		LogInPage lp = new LogInPage(driver);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://localhost:6502");
        ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		ut.takeScreenShot(prop, "thirdlogina.png");
		lp.login("admin", "admin");
		ut.takeScreenShot(prop, "thirdloginb.png");
		driver.get("http://localhost:6502/assets.html/content/dam/mysite");
				
		ap.upload("485A7230.jpg");
		ut.sleep(5000);
		
		driver.quit();

	}
	
	@Parameters ({"ffProfileName", "browser"})
	@Test(enabled=false)
	public void fourthcf(String ffProfileName, String browser) {
		WebDriver driver = getDriver(ffProfileName, browser);
		Utils ut = new Utils(driver);
		LogInPage lp = new LogInPage(driver);
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
		
		driver.quit();

	}
}
