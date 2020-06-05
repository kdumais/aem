package aem.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import aem.utils.Utils;

public class Second extends BaseTest {
	
	@Parameters ({"ffProfileName", "browser"})
	@Test(enabled=true)
	public void firsta(String ffProfileName, String browser) {
		WebDriver driver = getDriver(ffProfileName, browser);
		Utils ut = new Utils(driver);
		driver.get("https://cnn.com");
		ut.assertPageTitle("CNN - Breaking News, Latest News and Videos");
		ut.sleep(2000);
		ut.takeScreenShot(prop, "firsta.png");
		driver.quit();
	}
	
	@Parameters ({"ffProfileName", "browser"})
	@Test(enabled=true)
	public void seconda(String ffProfileName, String browser) {
		WebDriver driver = getDriver(ffProfileName, browser);
		Utils ut = new Utils(driver);
        driver.get("https://www.washingtonpost.com/");
		ut.assertPageTitle("Washington Post: Breaking News, World, US, DC News & Analysis - The Washington Post");
		ut.sleep(2000);
		ut.takeScreenShot(prop, "seconda.png");
		driver.quit();
	}

}
