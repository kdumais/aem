package aem.pages;

import org.openqa.selenium.WebDriver;
import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.Assert;
import aem.utils.Utils;

public class LogInPage  {
	WebDriver driver;
	Utils ut;
	Properties prop;
		
	public By userNameBy = By.xpath("//input[@name='j_username']");
	public By passwordBy = By.xpath("//input[@name='j_password']");
	public By submitButtonBy = By.xpath("//button[@id='submit-button']");
	public By welcomeTextBy = By.xpath("//div[@id='leftbox']/div/h1");
	
	public LogInPage(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		this.prop = prop;
		ut = new Utils(driver, prop);
	}
	
	public void login(String userName, String password) {
		ut.sendKeys(userNameBy, userName); 
		ut.sendKeys(passwordBy, password);
		ut.click(submitButtonBy);
	}
	
	public void assertWelcomeMessage(String expected) {
		Assert.assertEquals(driver.findElement(welcomeTextBy).getText(), expected);
	}
		
		
}
	

