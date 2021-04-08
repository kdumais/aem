package aem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.Assert;
import aem.utils.Utils;

public class LogInPage  {
	WebDriver driver;
	Utils ut;
			
	public By userNameBy = By.xpath("//input[@name='j_username']");
	public By passwordBy = By.xpath("//input[@name='j_password']");
	public By submitButtonBy = By.xpath("//button[@id='submit-button']");
	public By welcomeHeadingBy = By.xpath("//div[@id='leftbox']/div/h1");
	public By welcomeMessageBy = By.xpath("//div[@id='leftbox']/p");
	
	
	public LogInPage(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		ut = new Utils(driver, prop);
	}
	
	public void login(String userName, String password) {
		ut.sendKeys(userNameBy, userName); 
		ut.sendKeys(passwordBy, password);
		ut.click(submitButtonBy);
	}
	
	public void assertUserNameInputExists() {
		Assert.assertTrue(ut.getElement(userNameBy).isDisplayed());
	}
	
	public void assertPasswordInputExists() {
		Assert.assertTrue(ut.getElement(passwordBy).isDisplayed());
	}
	
	public void assertSubmitButtonExists() {
		Assert.assertTrue(ut.getElement(submitButtonBy).isDisplayed());
	}
	
	public void assertWelomeHeadingExists() {
		Assert.assertTrue(ut.getElement(welcomeHeadingBy).isDisplayed());
	}
	
	public void assertWelcomeMessageExists() {
		Assert.assertTrue(ut.getElement(welcomeMessageBy).isDisplayed());
	}
	
	public void assertWelcomeHeading(String expected) {
		Assert.assertEquals(ut.getElement(welcomeHeadingBy).getText(), expected);
	}
	
	public void assertWelcomeMessageContains(String expected) {
		Assert.assertTrue(ut.getElement(welcomeMessageBy).getText().contains((expected)));
	}
		
		
}
	

