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
import aem.pages.InboxPage;
import aem.pages.LogInPage;
import aem.pages.ProjectPage;
import aem.pages.UserPage;
import aem.pages.UserSettingsPage;
import aem.utils.Utils;

public class Inbox extends BaseTest {
	public WebDriver driver;
	public Utils ut;
	public static SoftAssert softAssert;
	Logger log = LogManager.getLogger(Inbox.class);
	LogInPage lp;
	AssetPage ap;
	UserPage up;
	UserSettingsPage us;
	ProjectPage pp;
	InboxPage ip;
		
	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		driver = getDriver();
		ut = new Utils(driver, prop);
		lp = new LogInPage(driver, prop);
		ap = new AssetPage(driver, prop);
		up = new UserPage(driver, prop);
		us = new UserSettingsPage(driver, prop);
		pp = new ProjectPage(driver, prop);
		ip = new InboxPage(driver, prop);
		
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
		ip.clickInboxIcon();
		ip.clickViewAll();
		ip.assertHowManyRows(4);
		ip.assertTitle(1, "Configure Analytics & Targeting");
		ip.assertTitle(4, "Configure HTTPS");
		ip.assertPriority(1, "Medium");
		ip.assertPriority(4, "High");
		ip.assertDescription(1, "You can opt in for Analytics and Targeting by selecting your configuration and then adding it to your pages.");
		ip.assertDescription(3, "You can opt in for aggregated usage statistics collection by enabling it for all users");
		ip.assertAssignee(2, "administrators");
		ip.assertStatus(1, "Active");
		//ip.clickCompleteButton();
		//ip.clickReassignButton();
		//ip.clickOpenButton();
		ip.clickCreateButton();
		ip.clickCreateTask();
		ip.setTitle("My Title");
		ip.setProject("Project Title");
		ip.setAssignee("Administrator");
		ip.setDescription("My Description");
		ip.setPriority("Medium");
		ip.setStartDate("2021-04-22 10:49");
		ip.setDueDate("2021-12-22 10:49");
		ip.clickSubmitButton();
		ip.assertCreateTaskHeader("Task Created");
		ip.assertCreateTaskContent("Task My Title has been created");
		ip.clickCreateTaskDoneButton();
		
		ip.selectRow(1);
		ip.clickCompleteButton();
		ip.setTaskCompleteComment("Complete Task Comment");
		ip.clickTaskCompleteButton();
		ut.sleep(1000);
		ip.assertHowManyRows(4);
		
		ut.sleep(5000);
	}
	
	
}
		
	
	
	
