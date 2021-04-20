package aem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.Assert;
import aem.utils.Utils;

public class InboxPage  {
	WebDriver driver;
	Utils ut;
		
	public By bellIconBy = By.xpath("//coral-icon[@icon='bell']");
	public By viewAllBy = By.xpath("//a[@href='/aem/inbox']");
	
	public By howManyRowsBy = By.xpath("//table[@handle='table']/tbody/tr");
	
	public InboxPage(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		ut = new Utils(driver, prop);
	}
	
	public void clickInboxIcon() {
		ut.click(bellIconBy);
	}
	
	public void clickViewAll() {
		ut.click(viewAllBy);
	}
	
	public void assertHowManyRows(int expected) {
		Assert.assertEquals(driver.findElements(howManyRowsBy).size(), expected);
	}
	
	
}
	

