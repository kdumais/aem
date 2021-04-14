package aem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.Assert;
import aem.utils.Utils;

public class UserSettingsPage  {
	WebDriver driver;
	Utils ut;
	//Edit user preferences		
	public By emailBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/email']");
	public By titleBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/title']");
	public By fnameBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/givenName']");
	public By lnameBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/familyName']");
	public By genderBy = By.xpath("//form[@id='propertiesform']//coral-select[@name='./profile/gender']");
	public By phoneNumberBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/phoneNumber']");
	public By jobTitleBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/jobTitle']");
	public By aboutBy = By.xpath("//form[@id='propertiesform']//textarea[@name='./profile/aboutMe']");
	public By streetBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/street']");
	public By cityBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/city']");
	public By postalCodeBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/postalCode']");
	public By countryBy = By.xpath("//form[@id='propertiesform']//coral-select[@name='./profile/country']");
	
	
	public UserSettingsPage(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		ut = new Utils(driver, prop);
	}
	
	public void editEmail(String text) {
		ut.getElement(emailBy).clear();
		ut.sendKeys(emailBy, text);
	}
	
	public void editTitle(String text) {
		ut.getElement(titleBy).clear();
		ut.sendKeys(titleBy, text);
	}
	
	public void editFname(String text) {
		ut.getElement(fnameBy).clear();
		ut.sendKeys(fnameBy, text);
	}
	
	public void editLname(String text) {
		ut.getElement(lnameBy).clear();
		ut.sendKeys(lnameBy, text);
	}
	
	public void selectGender(String text) {
		ut.click(genderBy);
		By choiceBy = By.xpath("//form[@id='propertiesform']//coral-selectlist-item[@value='"+text+"']");
		ut.click(choiceBy);
	}
	
	public void editPhoneNumber(String text) {
		ut.getElement(phoneNumberBy).clear();
		ut.sendKeys(phoneNumberBy, text);
	}
	
	public void editJobTitle(String text) {
		ut.getElement(jobTitleBy).clear();
		ut.sendKeys(jobTitleBy, text);
	}
	
	public void editAbout(String text) {
		ut.getElement(aboutBy).clear();
		ut.sendKeys(aboutBy, text);
	}
	
	public void editStreet(String text) {
		ut.getElement(streetBy).clear();
		ut.sendKeys(streetBy, text);
	}
	
	public void editCity(String text) {
		ut.getElement(cityBy).clear();
		ut.sendKeys(cityBy, text);
	}
	
	public void editPostalCode(String text) {
		ut.getElement(postalCodeBy).clear();
		ut.sendKeys(postalCodeBy, text);
	}
	
	public void selectCountry(String text) {
		ut.click(countryBy);
		By choiceBy = By.xpath("//form[@id='propertiesform']//coral-selectlist-item[@value='"+text+"']");
		ut.click(choiceBy);
	}
	
	
}
	

