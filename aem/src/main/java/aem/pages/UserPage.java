package aem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.Assert;
import aem.utils.Utils;

public class UserPage  {
	WebDriver driver;
	Utils ut;
			
	public By navigationBarUserIconBy = By.xpath("//coral-shell-header/coral-shell-header-actions//coral-shell-menubar-item[@title='User']");
	
	public By viewUserNameBy = By.xpath("//coral-shell-user//coral-shell-user-name");
	public By viewUserHeadingBy = By.xpath("//coral-shell-user//coral-shell-user-heading");
	public By myPreferencesButtonBy = By.xpath("//coral-shell-user//coral-shell-user-subheading//coral-button-label[contains(text(),'My Preferences')]");
	
	public By profileButtonBy = By.xpath("//coral-shell-user//coral-shell-user-footer//coral-anchorbutton-label[contains(text(),'Profile')]"); 
	public By signOutButtonBy = By.xpath("//coral-shell-user//coral-shell-user-footer//coral-anchorbutton-label[contains(text(),'Sign Out')]");
	
	public UserPage(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		ut = new Utils(driver, prop);
	}
	
	public void clickUserIcon() {
		ut.click(navigationBarUserIconBy);
	}
	
	public void assertUserName(String expected) {
		Assert.assertEquals(ut.getElement(viewUserNameBy).getText(), expected);
	}
	
	public void assertUserHeading(String expected) {
		Assert.assertEquals(ut.getElement(viewUserHeadingBy).getText(), expected);
	}
	
	public void assertDisplayedMyPreferencesButton() {
		Assert.assertTrue(ut.getElement(myPreferencesButtonBy).isDisplayed());
	}
	
	public void assertDisplayedProfileButton() {
		Assert.assertTrue(ut.getElement(profileButtonBy).isDisplayed());
	}
	
	public void assertDisplayedSignOutButton() {
		Assert.assertTrue(ut.getElement(signOutButtonBy).isDisplayed());
	}
	
	public void clickMyPreferencesButton() {
		ut.click(myPreferencesButtonBy);
	}
	
	public void clickProfileButton() {
		ut.click(profileButtonBy);
	}
	
	public void clickSignOutButton() {
		ut.click(signOutButtonBy);
	}
		
		
}
	

