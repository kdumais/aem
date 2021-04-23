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
	//There are two elements like this, but this works because we want the first one
	public By completeButtonBy = By.xpath("//coral-button-label[contains(text(),'Complete')]");
	public By reassignButtonBy = By.xpath("//coral-button-label[contains(text(),'Re-assign')]");
	public By openButtonBy = By.xpath("//coral-button-label[contains(text(),'Open')]");
	//Create Tasks
	public By createButtonBy = By.xpath("//coral-button-label[contains(text(),'Create')]");
	public By createTaskBy = By.xpath("//coral-list-item-content[contains(text(), 'Task')]");
	public By titleBy = By.xpath("//input[@name='name']");
	public By projectBy = By.xpath("//coral-select[@name='projectPath']");
	public By assigneeBy = By.xpath("//div[@id='coral-2']//button");
	public By descriptionBy = By.xpath("//textarea[@name='description']");
	public By priorityBy = By.xpath("//coral-select[@name='taskPriority']");
	public By startDateBy = By.xpath("//coral-datepicker[@name='taskStartDate']/input[@type='text']");
	public By dueDateBy = By.xpath("//coral-datepicker[@name='taskDueDate']/input[@type='text']");
	public By submitButtonBy = By.xpath("//coral-button-label[contains(text(), 'Submit')]");
	public By taskCreatedHeaderBy = By.xpath("//coral-dialog-header");
	public By taskCreatedContentBy = By.xpath("//coral-dialog-content");
	public By taskCreateDoneButtonBy = By.xpath("//coral-button-label[contains(text(), 'Done')]");
		
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
	
	public void assertDescription(int rowNum, String expected) {
		By selectBy = By.xpath("//table[@handle='table']/tbody/tr["+rowNum+"]/td[4]/span");
		Assert.assertEquals(ut.getElement(selectBy).getText(), expected);
	}
	
	public void assertAssignee(int rowNum, String expected) {
		By selectBy = By.xpath("//table[@handle='table']/tbody/tr["+rowNum+"]/td[5]//span");
		Assert.assertEquals(ut.getElement(selectBy).getText(), expected);
	}
	
	public void assertStatus(int rowNum, String expected) {
		By selectBy = By.xpath("//table[@handle='table']/tbody/tr["+rowNum+"]/td[8]");
		Assert.assertEquals(ut.getElement(selectBy).getAttribute("value"), expected);
	}
	
	public void clickCompleteButton() {
		ut.click(completeButtonBy);
	}
	
	public void clickReassignButton() {
		ut.click(reassignButtonBy);
	}
	
	public void clickOpenButton() {
		ut.click(openButtonBy);
	}
	
	public void clickCreateButton() {
		ut.click(createButtonBy);
	}
	
	public void clickCreateTask() {
		ut.click(createTaskBy);
	}
	
	public void setTitle(String text) {
		ut.sendKeys(titleBy, text);
	}
	
	public void setAssignee(String text) {
		ut.click(assigneeBy);
		By choiceBy = By.xpath("//li[@data-display='"+text+"']");
		ut.click(choiceBy); 
	}
	
	public void setProject(String text) {
		ut.click(projectBy);
		By choiceBy = By.xpath("//coral-selectlist-item[contains(text(), '"+text+"')]");
		ut.click(choiceBy);
	}
	
	public void setDescription(String text) {
		ut.sendKeys(descriptionBy, text);
	}
	
	public void setPriority(String text) {
		ut.click(priorityBy);
		By choiceBy = By.xpath("//coral-selectlist-item[contains(text(),'"+text+"')]");
		ut.click(choiceBy);
	}
	
	public void setStartDate(String text) {
		ut.sendKeys(startDateBy, text);
	}
	
	public void setDueDate(String text) {
		ut.sendKeys(dueDateBy, text);
	}
	
	public void clickSubmitButton() {
		ut.click(submitButtonBy);
	}
	
	public void assertCreateTaskHeader(String expected) {
		Assert.assertEquals(ut.getElement(taskCreatedHeaderBy).getText(), expected);
	}
	
	public void assertCreateTaskContent(String expected) {
		Assert.assertEquals(ut.getElement(taskCreatedContentBy).getText(), expected);
	}
	
	public void clickCreateTaskDoneButton() {
		ut.click(taskCreateDoneButtonBy);
	}
	
}
	

