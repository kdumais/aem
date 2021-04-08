package aem.tests;

import static org.testng.Assert.assertTrue;

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

public class LogIn extends BaseTest {
	public WebDriver driver;
	public Utils ut;
	public static SoftAssert softAssert;
	Logger log = LogManager.getLogger(LogIn.class);
	LogInPage lp;
	AssetPage ap;
		
	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		driver = getDriver();
		ut = new Utils(driver, prop);
		lp = new LogInPage(driver, prop);
		ap = new AssetPage(driver, prop);
		
		
		Logger log = Logger.getLogger("Log");
		result.setAttribute("utils", ut);
		result.setAttribute("browser", prop.getProperty("browser"));
		result.setAttribute("logger", log);
		softAssert = new SoftAssert();
		
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		driver.quit();
	}
	

	@Test(enabled=true)
	public void loginScreenView() {
				
		driver.get(authorbaseurl);
		ut.assertPageTitle("AEM Sign In");
		lp.assertWelomeHeadingExists();
		lp.assertWelcomeMessageExists();
		lp.assertUserNameInputExists();
		lp.assertPasswordInputExists();
		lp.assertSubmitButtonExists();
		
		lp.assertWelcomeHeading("Welcome to Adobe Experience Manager");
		lp.assertWelcomeMessageContains("An Adobe Experience Cloud solution: All the tools you need to solve these complex digital business challenges.");
		
		
		
		
	}
}
		
	
	
	
