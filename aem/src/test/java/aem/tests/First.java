package aem.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import aem.utils.Utils;

public class First extends BaseTest {
	
	@Parameters ({"ffProfileName", "browser"})
	@Test(enabled=true)
	public void firstcf(String ffProfileName, String browser) {
		WebDriver driver = getDriver(ffProfileName, browser);
		Utils ut = new Utils(driver);
		driver.get("https://www.lucidperspectives.com");
        ut.assertPageTitle("Home - Lucid Perspectives");
		ut.sleep(2000);
		ut.takeScreenShot(prop, "firstcf.png");
		
		driver.quit();

	}
	
	@Parameters ({"ffProfileName", "browser"})
	@Test(enabled=true)
	public void secondcf(String ffProfileName, String browser) {
		WebDriver driver = getDriver(ffProfileName, browser);
		Utils ut = new Utils(driver);
		driver.get("https://www.adobe.com");
        ut.assertPageTitle("Adobe: Creative, marketing and document management solutions");
		ut.sleep(2000);
		ut.takeScreenShot(prop, "secondcf.png");
		driver.quit();
	}
	
	@Parameters ({"ffProfileName", "browser"})
	@Test(enabled=true)
	public void thirdcf(String ffProfileName, String browser) {
		WebDriver driver = getDriver(ffProfileName, browser);
		Utils ut = new Utils(driver);
		driver.get(prop.getProperty("appurl"));
		ut.assertPageTitle("Google");
		ut.sleep(2000);
		ut.takeScreenShot(prop, "thirdcf.png");
		driver.quit();

	}
	
	
}
