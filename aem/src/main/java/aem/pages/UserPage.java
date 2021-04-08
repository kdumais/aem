package aem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.Assert;
import aem.utils.Utils;

public class UserPage  {
	WebDriver driver;
	Utils ut;
			
	public By navigationBarUserIconBy = By.xpath("//coral-shell-header/coral-shell-header-actions//coral-shell-menubar-item[@title='User']");
	
	
	public UserPage(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		ut = new Utils(driver, prop);
	}
	
	public void clickUserIcon() {
		ut.click(navigationBarUserIconBy);
		
		
	}
	
	
		
		
}
	

