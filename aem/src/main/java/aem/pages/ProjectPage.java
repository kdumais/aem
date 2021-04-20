package aem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.Assert;
import aem.utils.Utils;

public class ProjectPage  {
	WebDriver driver;
	Utils ut;
	//Edit user preferences		
	public By projectIconBy = By.xpath("//coral-icon[@icon='project']");
	public By createButtonBy = By.xpath("//coral-button-label[contains(text(),'Create')]");
	public By projectListItemBy = By.xpath("//coral-list-item-content[contains(text(),'Project')]");
	public By nextButtonBy = By.xpath("//coral-button-label[contains(text(),'Next')]");
	public By titleBy = By.xpath("//coral-panel-content//input[@name='jcr:title']");
	public By descriptionBy = By.xpath("//coral-panel-content//textarea[@name='jcr:description']");
	public By projectStatusBy = By.xpath("coral-switch/input[@name='active']");
	public By startDateBy = By.xpath("//coral-datepicker[@name='project.startDate']/input[@handle='input']");
	public By dueDateBy = By.xpath("//coral-datepicker[@name='project.dueDate']/input[@handle='input']");
	public By basicTabBy = By.xpath("//coral-tab-label[contains(text(),'Basic')]");
	public By advancedTabBy = By.xpath("//coral-tab-label[contains(text(),'Advanced')]");
	public By nameBy = By.xpath("//input[@name='name']");
	public By saveSuccessHeaderBy = By.xpath("//coral-dialog-header");
	public By saveSuccessContentBy = By.xpath("//coral-dialog-content");
	public By saveSuccessDoneButtonBy = By.xpath("//coral-button-label[contains(text(), 'Done')]");
	public By saveSuccessOpenButtonBy = By.xpath("//coral-button-label[contains(text(), 'Open')]");
	
	
	public ProjectPage(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		ut = new Utils(driver, prop);
	}
	
	public void clickProjectIcon() {
		ut.click(projectIconBy);
	}
	
	public void clickCreateButton() {
		ut.click(createButtonBy);
	}
	
	public void clickProjectListItem() {
		ut.click(projectListItemBy);
	}
	
	public void selectProjectTemplate(String text) {
		By selectProjectTemplateBy = By.xpath("//coral-card-title[contains(text(),'"+text+"')]");
		ut.click(selectProjectTemplateBy);
	}
	
	public void clickNextButton() {
		ut.click(nextButtonBy);
	}
	
	public void editTitle(String text) {
		ut.sendKeys(titleBy, text);
	}
	
	public void editDescription(String text) {
		ut.sendKeys(descriptionBy, text);
	}
	
	//Only on edit NOT create
	public void clickProjectStatus() {
		ut.click(projectStatusBy);
	}
	
	public void editStartDate(String text) {
		ut.sendKeys(startDateBy, text);
	}
			
	public void editDueDate(String text) {
		ut.sendKeys(dueDateBy, text);
	}
	
	public void clickBasicTab() {
		ut.click(basicTabBy);
	}
	
	public void clickAdvancedTab() {
		ut.click(advancedTabBy);
	}
	
	public void editName(String text) {
		ut.sendKeys(nameBy, text);
	}
	
	public void assertSaveSuccessHeader(String expected) {
		Assert.assertEquals(ut.getElement(saveSuccessHeaderBy).getText(), expected);
	}
	
	public void assertSaveSuccessContent(String expected) {
		Assert.assertEquals(ut.getElement(saveSuccessContentBy).getText(), expected);
	}
	
	public void clickDoneButton() {
		ut.click(saveSuccessDoneButtonBy);
	}
}
	

