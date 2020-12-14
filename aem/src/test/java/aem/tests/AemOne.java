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
		driver.get("http://ec2-54-234-44-75.compute-1.amazonaws.com:6502");
        ut.assertPageTitle("AEM Sign In");
        lp.assertWelcomeMessage("Welcome to Adobe Experience Manager");
		lp.login("admin", "admin");
		driver.get("ec2-54-234-44-75.compute-1.amazonaws.com:6502/assets.html/content/dam/todaya");
		
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
		
		
		ap.upload("485A7401.JPG");
		ap.upload("485A7402.JPG");
		ap.upload("485A7403.JPG");
		ap.upload("485A7404.JPG");
		ap.upload("485A7405.JPG");
		ap.upload("485A7406.JPG");
		ap.upload("485A7407.JPG");
		ap.upload("485A7408.JPG");
		ap.upload("485A7409.JPG");
		ap.upload("485A7410.JPG");
		ap.upload("485A7411.JPG");
		ap.upload("485A7412.JPG");
		ap.upload("485A7413.JPG");
		ap.upload("485A7414.JPG");
		ap.upload("485A7415.JPG");
		ap.upload("485A7416.JPG");
		ap.upload("485A7417.JPG");
		ap.upload("485A7418.JPG");
		ap.upload("485A7419.JPG");
		ap.upload("485A7420.JPG");
		ap.upload("485A7421.JPG");
		ap.upload("485A7422.JPG");
		ap.upload("485A7423.JPG");
		ap.upload("485A7424.JPG");
		ap.upload("485A7425.JPG");
		ap.upload("485A7426.JPG");
		ap.upload("485A7427.JPG");
		ap.upload("485A7428.JPG");
		ap.upload("485A7429.JPG");
		ap.upload("485A7430.JPG");
		ap.upload("485A7431.JPG");
		ap.upload("485A7432.JPG");
		ap.upload("485A7433.JPG");
		ap.upload("485A7434.JPG");
		ap.upload("485A7435.JPG");
		ap.upload("485A7436.JPG");
		ap.upload("485A7437.JPG");
		ap.upload("485A7438.JPG");
		ap.upload("485A7439.JPG");
		ap.upload("485A7440.JPG");
		ap.upload("485A7441.JPG");
		ap.upload("485A7442.JPG");
		ap.upload("485A7443.JPG");
		ap.upload("485A7444.JPG");
		ap.upload("485A7445.JPG");
		ap.upload("485A7446.JPG");
		ap.upload("485A7447.JPG");
		ap.upload("485A7448.JPG");
		ap.upload("485A7449.JPG");
		ap.upload("485A7450.JPG");
		ap.upload("485A7451.JPG");
		ap.upload("485A7452.JPG");
		ap.upload("485A7453.JPG");
		ap.upload("485A7454.JPG");
		ap.upload("485A7455.JPG");
		ap.upload("485A7456.JPG");
		ap.upload("485A7457.JPG");
		ap.upload("485A7458.JPG");
		ap.upload("485A7459.JPG");
		ap.upload("485A7460.JPG");
		ap.upload("485A7461.JPG");
		ap.upload("485A7462.JPG");
		ap.upload("485A7463.JPG");
		ap.upload("485A7464.JPG");
		ap.upload("485A7465.JPG");
		ap.upload("485A7466.JPG");
		ap.upload("485A7467.JPG");
		ap.upload("485A7468.JPG");
		ap.upload("485A7469.JPG");
		ap.upload("485A7470.JPG");
		ap.upload("485A7471.JPG");
		ap.upload("485A7472.JPG");
		ap.upload("485A7473.JPG");	
		ap.upload("485A7474.JPG");
		ap.upload("485A7475.JPG");
		ap.upload("485A7476.JPG");
		ap.upload("485A7477.JPG");
		ap.upload("485A7478.JPG");
		ap.upload("485A7479.JPG");	
		ap.upload("485A7480.JPG");
		ap.upload("485A7481.JPG");
		ap.upload("485A7482.JPG");
		ap.upload("485A7483.JPG");
		ap.upload("485A7484.JPG");
		ap.upload("485A7485.JPG");	
		ap.upload("485A7486.JPG");
		ap.upload("485A7487.JPG");
		ap.upload("485A7488.JPG");
		ap.upload("485A7489.JPG");
		ap.upload("485A7490.JPG");
				
		
		
		ut.sleep(10000);
	}
	
	@Test(enabled=false)
	public void sevencf() {
		//really good at editing any metadata for long pages of assest
		LogInPage lp = new LogInPage(driver, prop);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://ec2-3-89-250-136.compute-1.amazonaws.com:6502");
        lp.login("admin", "admin");
		driver.get("http://ec2-3-89-250-136.compute-1.amazonaws.com:6502/assets.html/content/dam/today");
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
		
		String title = "My New Title46";
		
		ap.loadAssetPage();
		
		ap.propertiesCard("485A7490.JPG");
		ap.setTitle(title);
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
						
		ap.propertiesCard("485A7214.JPG");
		ap.setTitle(title);
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		
		ap.propertiesCard("485A7248b.JPG");
		ap.setTitle(title);
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		
		ap.propertiesCard("485A7215.JPG");
		ap.setTitle(title);
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		
		ap.propertiesCard("485A7247b.JPG");
		ap.setTitle(title);
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
				
		ap.propertiesCard("485A7237a.JPG");
		ap.setTitle(title);
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
				
		ap.propertiesCard("485A7216.JPG");
		ap.setTitle(title);
		ap.setDescription("My New Description");
		ap.clickSaveAndClose();
		
		ut.sleep(10000);
	}


	@Test(enabled=true)
	public void eightcf() {
		//practice setting tag values
		LogInPage lp = new LogInPage(driver, prop);
		AssetPage ap = new AssetPage(driver, prop);
		driver.get("http://ec2-3-89-250-103.compute-1.amazonaws.com:6502");
		lp.login("admin", "admin");
		driver.get("http://ec2-3-89-250-103.compute-1.amazonaws.com:6502/assets.html/content/dam/todaya");
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7214.JPG");
		ap.setTitle("Dog One");
		ap.setTag("kd-test:dog");
		ap.setTag("kd-test:indoor");
		ap.setTag("kd-test:too-dark");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7247.JPG");
		ap.setTitle("Dog Two");
		ap.setTag("kd-test:dog");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:my-favorite");
		ap.setTag("kd-test:grass");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7240.JPG");
		ap.setTitle("Dog Three");
		ap.setTag("kd-test:dog");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:my-favorite");
		ap.setTag("kd-test:zoomed-in");
		ap.clickSaveAndClose();
							
		ap.loadAssetPage();
		ap.propertiesCard("485A7404.JPG");
		ap.setTitle("Scenery One");
		ap.setTag("kd-test:scenery");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:zoomed-in");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7410.JPG");
		ap.setTitle("Scenery Two");
		ap.setTag("kd-test:stone");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:zoomed-in");
		ap.setTag("kd-test:scenery");
		ap.setTag("kd-test:my-favorite");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7420.JPG");
		ap.setTitle("Scenery Three");
		ap.setTag("kd-test:stone");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:zoomed-in");
		ap.setTag("kd-test:scenery");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7416.JPG");
		ap.setTitle("Scenery Four");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:zoomed-in");
		ap.setTag("kd-test:scenery");
		ap.setTag("kd-test:my-favorite");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7431.JPG");
		ap.setTitle("Scenery Five");
		ap.setTag("kd-test:wind-mill");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:scenery");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7471.JPG");
		ap.setTitle("Scenery Six");
		ap.setTag("kd-test:water");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:scenery");
		ap.setTag("kd-test:my-favorite");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7478.JPG");
		ap.setTitle("Scenery Seven");
		ap.setTag("kd-test:water");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:scenery");
		ap.clickSaveAndClose();
		
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7490.JPG");
		ap.setTitle("Scenery Eight");
		ap.setTag("kd-test:water");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:scenery");
		ap.setTag("kd-test:zoomed-in");
		ap.setTag("kd-test:my-favorite");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7406.JPG");
		ap.setTitle("Scenery Nine");
		ap.setTag("kd-test:grass");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:scenery");
		ap.setTag("kd-test:zoomed-in");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7408.JPG");
		ap.setTitle("Scenery Ten");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:scenery");
		ap.setTag("kd-test:zoomed-in");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7401.JPG");
		ap.setTitle("Scenery Eleven");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:scenery");
		ap.setTag("kd-test:zoomed-in");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7421.JPG");
		ap.setTitle("Scenery Twelve");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:scenery");
		ap.setTag("kd-test:grass");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7440.JPG");
		ap.setTitle("Scenery Thirteen");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:scenery");
		ap.setTag("kd-test:wind-mill");
		ap.setTag("kd-test:zoomed-in");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7437.JPG");
		ap.setTitle("Scenery Fourteen");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:scenery");
		ap.setTag("kd-test:wind-mill");
		ap.setTag("kd-test:zoomed-in");
		ap.setTag("kd-test:too-dark");
		ap.clickSaveAndClose();
		
		ap.loadAssetPage();
		ap.propertiesCard("485A7452.JPG");
		ap.setTitle("Scenery Fifteen");
		ap.setTag("kd-test:outdoor");
		ap.setTag("kd-test:scenery");
		ap.setTag("kd-test:water");
		ap.clickSaveAndClose();
		
		ut.sleep(5000);
	}
}
		
	
	
	
