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
import aem.pages.UserPage;
import aem.utils.Utils;

public class User extends BaseTest {
	public WebDriver driver;
	public Utils ut;
	public static SoftAssert softAssert;
	Logger log = LogManager.getLogger(User.class);
	LogInPage lp;
	AssetPage ap;
	UserPage up;
		
	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		driver = getDriver();
		ut = new Utils(driver, prop);
		lp = new LogInPage(driver, prop);
		ap = new AssetPage(driver, prop);
		up = new UserPage(driver, prop);
		
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
	

	@Test(enabled=false)
	public void userViewCheck() {
		driver.get(authorbaseurl);
		lp.login("admin", "admin");
		up.clickUserIcon();
		up.assertUserName("Administrator");
		up.assertUserHeading("admin");
		up.assertDisplayedMyPreferencesButton();
		up.assertDisplayedProfileButton();
		up.assertDisplayedSignOutButton();
		ut.sleep(5000);
	}
	
	@Test(enabled=true)
	public void userMyPreferencesCheck() {
		driver.get(authorbaseurl);
		lp.login("admin", "admin");
		up.clickUserIcon();
		up.clickMyPreferencesButton();
		up.selectLanguage("English");
		up.assertLanguageValue("English");
		up.selectWindowManagement("Multiple Windows (Default)");
		up.assertWindowManagementValue("Multiple Windows (Default)");
		up.assertShowHelpOverlayIsSelected(false);
		up.selectShowHelpOverlay();
		up.assertShowHelpOverlayIsSelected(true);
		up.assertShowDesktopActionsIsSelected(false);
		up.selectShowDesktopActions();
		up.assertShowDesktopActionsIsSelected(true);
		up.selectRelativeDate("7 Days (default)");
		up.assertRelativeDateValue("7 Days (default)");
		up.assertEnableShortcutsIsSelected(true);
		up.selectEnableShortcuts();
		up.assertEnableShortcutsIsSelected(false);
		up.assertUseClassicAuthoringIsSelected(false);
		up.selectUseClassicAuthoring();
		up.assertUseClassicAuthoringIsSelected(true);
		up.assertEnableAssetHomePageIsSelected(true);
		up.selectEnableAssetHomePage();
		up.assertEnableAssetHomePageIsSelected(false);
		up.clickCancelButton();
		
		ut.sleep(5000);
	}
	
	@Test(enabled=false)
	public void userProfileCheck() {
		driver.get(authorbaseurl);
		lp.login("admin", "admin");
		up.clickUserIcon();
		up.clickProfileButton();
		ut.sleep(5000);
	}
}
		
	
	
	
