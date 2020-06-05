package aem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		ut = new Utils(driver);
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
		
}
	

