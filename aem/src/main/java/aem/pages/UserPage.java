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
	//Header Navigation to user		
	public By navigationBarUserIconBy = By.xpath("//coral-shell-header/coral-shell-header-actions//coral-shell-menubar-item[@title='User']");
	//Fields on the main user page
	public By viewUserNameBy = By.xpath("//coral-shell-user//coral-shell-user-name");
	public By viewUserHeadingBy = By.xpath("//coral-shell-user//coral-shell-user-heading");
	public By myPreferencesButtonBy = By.xpath("//coral-shell-user//coral-shell-user-subheading//coral-button-label[contains(text(),'My Preferences')]");
	public By profileButtonBy = By.xpath("//coral-shell-user//coral-shell-user-footer//coral-anchorbutton-label[contains(text(),'Profile')]"); 
	public By signOutButtonBy = By.xpath("//coral-shell-user//coral-shell-user-footer//coral-anchorbutton-label[contains(text(),'Sign Out')]");
	//Fields on the My Preferences Page
	public By languageBy = By.xpath("//form[@id='granite-user-preferences']//coral-select[@name='language']//button");
	public By languageCurrentValueBy = By.xpath("//form[@id='granite-user-preferences']//coral-select[@name='language']//span");
	public By windowManagementBy = By.xpath("//form[@id='granite-user-preferences']//coral-select[@name='winMode']//button");
	public By windowManagementCurrentValueBy = By.xpath("//form[@id='granite-user-preferences']//coral-select[@name='winMode']//span");
	public By showHelpOverlaysBy = By.xpath("//form[@id='granite-user-preferences']//coral-checkbox[@name='granite.shell.showonboarding620']/input");
	public By showHelpDesktopActionsBy = By.xpath("//form[@id='granite-user-preferences']//coral-checkbox[@name='showAssetDesktopLinks']/input");
	public By relativeDateBy = By.xpath("//form[@id='granite-user-preferences']//coral-select[@name='relativeDateCutoff']//button");
	public By relativeDateCurrentValueBy = By.xpath("//form[@id='granite-user-preferences']//coral-select[@name='relativeDateCutoff']//span");
	public By enableShortcutsBy = By.xpath("//form[@id='granite-user-preferences']//coral-checkbox[@name='shortcutsEnabled']/input");
	public By useClassicAuthoringBy = By.xpath("//form[@id='granite-user-preferences']//coral-checkbox[@name='authoringMode']/input");
	public By enableAssetHomePageBy = By.xpath("//form[@id='granite-user-preferences']//coral-checkbox[@name='enableHomePage']/input");
	public By userPrefCancelButtonBy = By.xpath("//coral-dialog-footer//coral-button-label[contains(text(),'Cancel')]");
	public By userPrefAcceptButtonBy = By.xpath("//coral-dialog-footer//coral-button-label[contains(text(),'Accept')]");
	
	public UserPage(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		ut = new Utils(driver, prop);
	}
	
	public void clickUserIcon() {
		ut.click(navigationBarUserIconBy);
		//Temp fix to no implement wait for element to be in its final coordinates
		ut.sleep(1000);
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
		
	//Methods for My Preferences
	public void selectLanguage(String language) {
		ut.getElement(languageBy).click();
		By choiceBy = By.xpath("//form[@id='granite-user-preferences']//coral-select[@name='language']//coral-overlay//coral-selectlist-item[contains(text(),'"+language+"')]");
		ut.click(choiceBy);
	}
	
	public void assertLanguageValue(String expected) {
		Assert.assertEquals(ut.getElement(languageCurrentValueBy).getText(), expected);
	}
	
	public void selectWindowManagement(String winMode) {
		ut.getElement(windowManagementBy).click();
		By choiceBy = By.xpath("//form[@id='granite-user-preferences']//coral-select[@name='winMode']//coral-overlay//coral-selectlist-item[contains(text(),'"+winMode+"')]");
		ut.click(choiceBy);
	}
	
	public void assertWindowManagementValue(String expected) {
		Assert.assertEquals(ut.getElement(windowManagementCurrentValueBy).getText(), expected);
	}
	
	public void selectShowHelpOverlay() {
		ut.click(showHelpOverlaysBy);
	}
	
	public void assertShowHelpOverlayIsSelected(boolean expected) {
		Assert.assertEquals(ut.getElement(showHelpOverlaysBy).isSelected(), expected);
	}
	
	public void selectShowDesktopActions() {
		ut.click(showHelpDesktopActionsBy);
	}
	
	public void assertShowDesktopActionsIsSelected(boolean expected) {
		Assert.assertEquals(ut.getElement(showHelpDesktopActionsBy).isSelected(), expected);
	}
	
	public void selectRelativeDate(String relativeDate) {
		ut.getElement(relativeDateBy).click();
		By choiceBy = By.xpath("//form[@id='granite-user-preferences']//coral-select[@name='relativeDateCutoff']//coral-overlay//coral-selectlist-item[contains(text(),'"+relativeDate+"')]");
		ut.click(choiceBy);
	}
	
	public void assertRelativeDateValue(String expected) {
		Assert.assertEquals(ut.getElement(relativeDateCurrentValueBy).getText(), expected);
	}
	
	public void selectEnableShortcuts() {
		ut.click(enableShortcutsBy);
	}
	
	public void assertEnableShortcutsIsSelected(boolean expected) {
		Assert.assertEquals(ut.getElement(enableShortcutsBy).isSelected(), expected);
	}
	
	public void selectUseClassicAuthoring() {
		ut.click(useClassicAuthoringBy);
	}
	
	public void assertUseClassicAuthoringIsSelected(boolean expected) {
		Assert.assertEquals(ut.getElement(useClassicAuthoringBy).isSelected(), expected);
	}
	
	public void selectEnableAssetHomePage() {
		ut.click(enableAssetHomePageBy);
	}
	
	public void assertEnableAssetHomePageIsSelected(boolean expected) {
		Assert.assertEquals(ut.getElement(enableAssetHomePageBy).isSelected(), expected);
	}
	
	public void clickCancelButton() {
		ut.click(userPrefCancelButtonBy);
	}
}
	

