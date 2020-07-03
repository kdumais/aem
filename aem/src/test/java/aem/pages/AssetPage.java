package aem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import aem.utils.Utils;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AssetPage  {
	WebDriver driver;
	Utils ut; 
	Properties prop;
	
	public By fileUploadBy = By.xpath("/html/body/coral-dialog[4]/div[2]/coral-dialog-content/div/input");
	public By uploadButtonBy = By.xpath("/html/body/coral-dialog[4]/div[2]/coral-dialog-footer/button[2]/coral-button-label");
	//public By createButtonBy = By.xpath("//coral-button-label[contains(text(),'Create')]");
	public By createButtonBy = By.xpath("//coral-button-label[contains(text(),'Create')]//parent::button");
	public By filesListItemBy = By.xpath("//a[@icon='upload']");
	By uploadButton2By = By.xpath("//coral-button-label[contains(text(),'Upload')]");
		
	public AssetPage(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		ut = new Utils(driver, prop);
		this.prop=prop;
	}
	
	
	public void upload(String fileName) {
		 		 
		 ut.click(createButtonBy);
		 ut.click(filesListItemBy);
		 		 
		 StringSelection stringSelection = new StringSelection(prop.getProperty("assetfiledir")+fileName);
		 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		 clipboard.setContents(stringSelection, stringSelection);
		 try {
				Robot rb= new Robot();
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_ENTER);
	            rb.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 ut.click(uploadButton2By);
		 
			 		 
		
	}
	
	public void waitForPageToLoad() {
		//this ensures the overlay is gone so that the Create button can be clicked
		By by = By.xpath("//coral-list-item-content[@class='coral3-BasicList-item-content']");
		FluentWait<WebDriver> wait = new WebDriverWait(driver, 10);
		List<WebElement> elements = driver.findElements(by);
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
		
	}
	
	public void clickAssetCard(String text) {
		By by = By.xpath("//coral-card-content//coral-card-title[contains(text(),'"+text+"')]");
		ut.click(by);
	}
	
	 public void selectCard(String text) {
		Actions actions = new Actions(driver);
		By cardBy = By.xpath("//coral-card-content//coral-card-title[contains(text(),'"+text+"')]");
		WebElement cardElement = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(cardBy));
		actions.moveToElement(cardElement);
		actions.build().perform();
		By selectIconBy = By.xpath("//coral-quickactions[@aria-hidden='false']//button[@title='Select']");
		ut.click(selectIconBy);
	 }
	 
	 public void propertiesCard(String text) {
			Actions actions = new Actions(driver);
			By cardBy = By.xpath("//coral-card-content//coral-card-title[contains(text(),'"+text+"')]");
			WebElement cardElement = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(cardBy));
			actions.moveToElement(cardElement);
			actions.build().perform();
			By propertiesIconBy = By.xpath("//coral-quickactions[@aria-hidden='false']//button[@title='Properties']");
			ut.click(propertiesIconBy);
		 }
	 
	 public void setTitle(String text) {
		 By fieldBy = By.xpath("//input[@name='./jcr:content/metadata/dc:title']");
		 ut.sendKeys(fieldBy, text);
	 }
	 
	 public void setDescription(String text) {
		 By fieldBy = By.xpath("//input[@name='./jcr:content/metadata/dc:description']");
		 ut.sendKeys(fieldBy, text);
	 }
	 	 
	 public void setOnTime(String text) {
		 By fieldBy = By.xpath("//coral-datepicker[@name='./jcr:content/onTime']/input[@is='coral-textfield']");
		 ut.sendKeys(fieldBy, text); 
	 }
	 
	 public void setOffTime(String text) {
		 By fieldBy = By.xpath("//coral-datepicker[@name='./jcr:content/offTime']/input[@is='coral-textfield']");
		 ut.sendKeys(fieldBy, text); 
	 }
	 
	 
	 public void selectLanguage(String text) {
		 By fieldBy = By.xpath("//coral-select[@name='./jcr:content/metadata/dc:language']/button");
		 ut.click(fieldBy);
		 By fieldBy2 = By.xpath("//coral-selectlist-item[contains(text(),'"+text+"')]");
		 ut.click(fieldBy2); 
	 }
	 
	 public int getNumberOfTags() {
		 By fieldBy = By.xpath("(//coral-taglist)[3 ]/coral-tag/coral-tag-label");
		 List<WebElement> tags = driver.findElements(fieldBy);
		 return tags.size();
	 }
	 
	 public boolean containsTag(String value) {
		 By fieldBy = By.xpath("(//coral-taglist)[3]/coral-tag/coral-tag-label");
		 List<WebElement> elementTags = driver.findElements(fieldBy);
		 List<String> tags = new ArrayList<String>();
		 for (WebElement  element : elementTags) {
			tags.add(element.getText());
		 }
		 return tags.contains(value);
		 
		 
	}
		
}
	

