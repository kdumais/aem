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
	public By viewAllBy = By.xpath("//coral-shell-menu[@aria-hidden='false']//a[@href='/aem/inbox']");
	public By howManyRowsBy = By.xpath("//table[@handle='table']/tbody/tr");
		
	public InboxPage(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		ut = new Utils(driver, prop);
	}
	
	public void clickInboxIcon() {
		ut.click(bellIconBy);
		//Temp fix to no implement wait for element to be in its final coordinates
		ut.sleep(1000);
	}
	
	public void clickViewAll() {
		ut.click(viewAllBy);
	}
	
	public void assertHowManyRows(int expected) {
		Assert.assertEquals(driver.findElements(howManyRowsBy).size(), expected);
	}
	
	public void selectRow(int rowNum) {
		By selectBy = By.xpath("//table[@handle='table']/tbody/tr["+rowNum+"]/td");
		ut.click(selectBy);
	}
	
	public void assertTitle(int rowNum, String expected) {
		By selectBy = By.xpath("//table[@handle='table']/tbody/tr["+rowNum+"]/td[2]");
		Assert.assertEquals(ut.getElement(selectBy).getText(), expected);
	}
	
	public void assertPriority(int rowNum, String expected) {
		By selectBy = By.xpath("//table[@handle='table']/tbody/tr["+rowNum+"]/td[3]//coral-tag-label");
		Assert.assertEquals(ut.getElement(selectBy).getText(), expected);
	}
	
	
}
	

