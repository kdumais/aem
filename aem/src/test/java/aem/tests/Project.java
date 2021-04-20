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
import aem.pages.ProjectPage;
import aem.pages.UserPage;
import aem.pages.UserSettingsPage;
import aem.utils.Utils;

public class Project extends BaseTest {
	public WebDriver driver;
	public Utils ut;
	public static SoftAssert softAssert;
	Logger log = LogManager.getLogger(Project.class);
	LogInPage lp;
	AssetPage ap;
	UserPage up;
	UserSettingsPage us;
	ProjectPage pp;
		
	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		driver = getDriver();
		ut = new Utils(driver, prop);
		lp = new LogInPage(driver, prop);
		ap = new AssetPage(driver, prop);
		up = new UserPage(driver, prop);
		us = new UserSettingsPage(driver, prop);
		pp = new ProjectPage(driver, prop);
		
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
	public void projectCheck() {
		driver.get(authorbaseurl);
		lp.login("admin", "admin");
		pp.clickProjectIcon();
		pp.clickCreateButton();
		pp.clickProjectListItem();
		pp.selectProjectTemplate("Simple Project");
		pp.clickNextButton();
		pp.editTitle("Project Title");
		pp.editDescription("Description");
		pp.editStartDate("2021-04-19 13:00");
		pp.editDueDate("2021-12-19 13:00");
		pp.clickAdvancedTab();
		pp.editName("Name");
		pp.clickCreateButton();
		
		pp.assertSaveSuccessHeader("Success");
		pp.assertSaveSuccessContent("The project was created");
		pp.clickDoneButton();
		
		pp.selectProperties("Project Title");
		
		pp.assertTitle("Project Title");
		pp.assertDescription("Description");
		pp.assertStartDate("2021-04-19T13:00:00.000-04:00");
		pp.assertDueDate("2021-12-19T13:00:00.000-05:00");
		
		ut.sleep(15000);
	}
	
	
}
		
	
	
	
