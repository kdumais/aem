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
	public By genderValueBy = By.xpath("//form[@id='propertiesform']//coral-select[@name='./profile/gender']/button/span");
	public By phoneNumberBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/phoneNumber']");
	public By jobTitleBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/jobTitle']");
	public By aboutBy = By.xpath("//form[@id='propertiesform']//textarea[@name='./profile/aboutMe']");
	public By streetBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/street']");
	public By cityBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/city']");
	public By postalCodeBy = By.xpath("//form[@id='propertiesform']//input[@name='./profile/postalCode']");
	public By countryBy = By.xpath("//form[@id='propertiesform']//coral-select[@name='./profile/country']");
	public By countryValueBy = By.xpath("//form[@id='propertiesform']//coral-select[@name='./profile/country']/button/span");
	
	public UserSettingsPage(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		ut = new Utils(driver, prop);
	}
	
	public void editEmail(String text) {
		ut.sendKeys(emailBy, text);
	}
	
	public void assertEmail(String expected) {
		Assert.assertEquals(ut.getElement(emailBy).getAttribute("value"), expected);
	}
	
	public void editTitle(String text) {
		ut.sendKeys(titleBy, text);
	}
	
	public void assertTitle(String expected) {
		Assert.assertEquals(ut.getElement(titleBy).getAttribute("value"), expected);
	}
	
	public void editFname(String text) {
		ut.sendKeys(fnameBy, text);
	}
	
	public void assertFname(String expected) {
		Assert.assertEquals(ut.getElement(fnameBy).getAttribute("value"), expected);
	}
	
	public void editLname(String text) {
		ut.sendKeys(lnameBy, text);
	}
	
	public void assertLname(String expected) {
		Assert.assertEquals(ut.getElement(lnameBy).getAttribute("value"), expected);
	}
	
	public void selectGender(String text) {
		ut.click(genderBy);
		By choiceBy = By.xpath("//form[@id='propertiesform']//coral-selectlist-item[@value='"+text+"']");
		ut.click(choiceBy);
	}
	
	public void assertGender(String expected) {
		Assert.assertEquals(ut.getElement(genderValueBy).getText(), expected);
	}
	
	public void editPhoneNumber(String text) {
		ut.sendKeys(phoneNumberBy, text);
	}
	
	public void assertPhoneNumber(String expected) {
		Assert.assertEquals(ut.getElement(phoneNumberBy).getAttribute("value"), expected);
	}
	
	public void editJobTitle(String text) {
		ut.sendKeys(jobTitleBy, text);
	}
	
	public void assertJobTitle(String expected) {
		Assert.assertEquals(ut.getElement(jobTitleBy).getAttribute("value"), expected);
	}
	
	public void editAbout(String text) {
		ut.sendKeys(aboutBy, text);
	}
	
	public void assertAbout(String expected) {
		Assert.assertEquals(ut.getElement(aboutBy).getAttribute("value"), expected);
	}
	
	public void editStreet(String text) {
		ut.sendKeys(streetBy, text);
	}
	
	public void assertStreet(String expected) {
		Assert.assertEquals(ut.getElement(streetBy).getAttribute("value"), expected);
	}
	
	public void editCity(String text) {
		ut.sendKeys(cityBy, text);
	}
	
	public void assertCity(String expected) {
		Assert.assertEquals(ut.getElement(cityBy).getAttribute("value"), expected);
	}
	
	public void editPostalCode(String text) {
		ut.sendKeys(postalCodeBy, text);
	}
	
	public void assertPostalCode(String expected) {
		Assert.assertEquals(ut.getElement(postalCodeBy).getAttribute("value"), expected);
	}
	
	public void selectCountry(String text) {
		ut.click(countryBy);
		By choiceBy = By.xpath("//form[@id='propertiesform']//coral-selectlist-item[@value='"+text+"']");
		ut.click(choiceBy);
	}
	
	public void assertCountry(String expected) {
		Assert.assertEquals(ut.getElement(countryValueBy).getText(), expected);
	}
}
	

