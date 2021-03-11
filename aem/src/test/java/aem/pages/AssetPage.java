package aem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;

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
	public By createButtonBy = By.xpath("//coral-button-label[contains(text(),'Create')]//parent::button");
	public By filesListItemBy = By.xpath("//a[@icon='upload']");
	public By folderListItemBy = By.xpath("//a[@icon='folderAdd']");
	By uploadButton2By = By.xpath("//coral-button-label[contains(text(),'Upload')]");
		
	public AssetPage(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		ut = new Utils(driver, prop);
		this.prop=prop;
	}
	
	public void createFolder(String folderName) {
		 
		 ut.click(createButtonBy);
		 ut.click(folderListItemBy);
		 By folderNameBy = By.xpath("//input[@name='./jcr:content/jcr:title']");
		 ut.sendKeys(folderNameBy, folderName);
		 By createButtonBy = By.xpath("//coral-dialog-footer//coral-button-label[contains(text(),'Create')]//parent::button");
		 ut.click(createButtonBy);
	}
	
	public void upload(String fileName) {
		 		 
		 ut.click(createButtonBy);
		 ut.click(filesListItemBy);
		 
		 ut.sleep(2000);
		 		 
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
		 By by = By.xpath("//coral-progress[@id='progress_"+fileName+"']");
		 FluentWait<WebDriver> wait = new WebDriverWait(driver, 600);
		 List<WebElement> elements = driver.findElements(by);
		 wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
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
	 
	 public void loadAssetPage() {
		 //keeps scrolling down the page until a div element per asset exists in the DOM, this is enough to scroll the asset into view
		By byA = By.xpath("//coral-masonry-item");
		int currentNumber = ut.getNumberOfElements(byA);
		int newNumber = -1;
		while (currentNumber != newNumber) {
			By myDivBy = By.xpath("//div[@class='foundation-layout-panel-content foundation-collection-content']");
			WebElement myDiv = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(myDivBy));
			
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollTop=arguments[0].scrollHeight", myDiv);
			waitForPageToLoad();
			ut.sleep(3000);
			currentNumber = newNumber;
			newNumber = ut.getNumberOfElements(byA);
			System.out.println("Numbers:");
			System.out.println(currentNumber);
			System.out.println(newNumber);
		}
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		/* 	System.out.println(ut.getNumberOfElements(byA));
			
			By myDivBy = By.xpath("//div[@class='foundation-layout-panel-content foundation-collection-content']");
			WebElement myDiv = driver.findElement(myDivBy);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollTop=arguments[0].scrollHeight", myDiv);
			waitForPageToLoad();
			long temp = (long)js.executeScript("return arguments[0].scrollHeight", myDiv);
			System.out.println("scroll height:");
			System.out.println(temp);
			ut.sleep(3000);	
			System.out.println(ut.getNumberOfElements(byA));
			/*js.executeScript("arguments[0].scrollTop=arguments[0].scrollHeight", myDiv);
			waitForPageToLoad();
			temp = (long)js.executeScript("return arguments[0].scrollHeight", myDiv);
			System.out.println("scroll height:");
			System.out.println(temp);
			ut.sleep(3000);	
			System.out.println(ut.getNumberOfElements(byA));
			js.executeScript("arguments[0].scrollTop=arguments[0].scrollHeight", myDiv);
			waitForPageToLoad();
			temp = (long)js.executeScript("return arguments[0].scrollHeight", myDiv);
			System.out.println("scroll height:");
			System.out.println(temp);
			ut.sleep(3000);
			System.out.println(ut.getNumberOfElements(byA));
			System.out.println(ut.getNumberOfElements(byA));
			js.executeScript("arguments[0].scrollTop=arguments[0].scrollHeight", myDiv);
			waitForPageToLoad();
			temp = (long)js.executeScript("return arguments[0].scrollHeight", myDiv);
			System.out.println("scroll height:");
			System.out.println(temp);
			ut.sleep(3000);
			System.out.println(ut.getNumberOfElements(byA));
			System.out.println(ut.getNumberOfElements(byA));
			js.executeScript("arguments[0].scrollTop=arguments[0].scrollHeight", myDiv);
			waitForPageToLoad();
			temp = (long)js.executeScript("return arguments[0].scrollHeight", myDiv);
			System.out.println("scroll height:");
			System.out.println(temp);
			ut.sleep(3000);
			System.out.println(ut.getNumberOfElements(byA));
			*/
			
			//By by = By.xpath("//coral-masonry-item[@data-foundation-collection-item-id='/content/dam/today/"+text+"']");
			//WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
			//JavascriptExecutor js = ((JavascriptExecutor) driver);
			//js.executeScript("arguments[0].scrollIntoView()", element);
		 
		 
		 
		 
		 
	 }
	 
	 public void propertiesCard(String text) {
						
	        By cardBy = By.xpath("//coral-masonry-item[@data-foundation-collection-item-id='/content/dam/todaya/"+text+"']");
			WebElement cardElementa = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(cardBy));
			ut.scrollIntoView(cardElementa);
						
			System.out.println("LOC INFO");
			cardElementa = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(cardBy));
			Point currentPoint = cardElementa.getLocation();
			Point oldPoint = new Point(0, 0);
			
			while (!(currentPoint.equals(oldPoint))) {
				oldPoint = currentPoint;
				cardElementa = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(cardBy));
				currentPoint = cardElementa.getLocation();
				System.out.println(currentPoint);
				System.out.println(oldPoint);
				System.out.println(currentPoint.equals(oldPoint));
				ut.sleep(3000);
				
			}
			/*
			WebElement cardElementb = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(cardBy));
			System.out.println(cardElementb.getLocation());
			ut.sleep(1000);
			WebElement cardElementc = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(cardBy));
			System.out.println(cardElementc.getLocation());
			ut.sleep(1000);
			WebElement cardElementd = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(cardBy));
			System.out.println(cardElementd.getLocation());
			ut.sleep(1000);
			WebElement cardElemente = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(cardBy));
			System.out.println(cardElemente.getLocation());
			ut.sleep(1000);
			*/
			
			clickPropertiesIcon(text);
			
		 }
	 
	 public void clickPropertiesIcon(String text) {
		 By cardBy = By.xpath("//coral-masonry-item[contains(@data-foundation-collection-item-id,'"+text+"')]");
		 WebElement cardElementa = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(cardBy));	
		 
		 Actions actions = new Actions(driver);
		 cardElementa = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(cardBy));
		 actions.moveToElement(cardElementa);
		 actions.build().perform();
		 By propertiesIconBy = By.xpath("//coral-quickactions[@aria-hidden='false']//button[@title='Properties']");
		 ut.click(propertiesIconBy);
		 
		 
		 
		 
	 }
	 
	 public void assertPageCount(String expected) {
		 By countBy = By.xpath("//granite-pagingstatus");
		 WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(countBy));
		 String temp = element.getAttribute("guesstotal");
		 Assert.assertEquals(temp, expected);
	 }
	 
	 public void getCurrentCount() {
		 By countBy = By.xpath("//granite-pagingstatus");
		 WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(countBy));
		 String temp = element.getAttribute("current");
		 System.out.println("*****Current*********");
		 System.out.println(temp);
		 System.out.println("******Current********");
		 
	 }
	 
	 public void setTitle(String text) {
		 By fieldBy = By.xpath("//input[@name='./jcr:content/metadata/dc:title']");
		 ut.sendKeys(fieldBy, text);
	 }
	 
	 public void setDescription(String text) {
		 By fieldBy = By.xpath("//input[@name='./jcr:content/metadata/dc:description']");
		 ut.sendKeys(fieldBy, text);
	 }
	 
	 public void setTag(String text) {
		 By dropDownBy = By.xpath("//foundation-autocomplete[@labelled='Tags selection dialog.']//button");
		 ut.click(dropDownBy);
		 By namespaceBy = By.xpath("//coral-columnview-item-content[@title='KD-Test']");
		 ut.click(namespaceBy);
		 By tagBy = By.xpath("//coral-columnview-item[@data-foundation-picker-collection-item-value='"+text+"']/coral-columnview-item-thumbnail");
		 ut.click(tagBy);
		 By selectBy = By.xpath("//coral-button-label[contains(text(),'Select')]");
		 ut.click(selectBy);
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
	 
	 public void setLocation(String text) {
		 By fieldBy = By.xpath("//input[@name='./jcr:content/metadata/Iptc4xmpExt:LocationShown']");
		 ut.sendKeys(fieldBy, text); 
	 }
	 
	 public void setCreatorTool(String text) {
		 By fieldBy = By.xpath("//input[@name='./jcr:content/metadata/xmp:CreatorTool']");
		 ut.sendKeys(fieldBy, text); 
	 }
	 
	 public void clickSaveAndClose() {
			By by = By.xpath("//coral-button-label[contains(text(),'Save & Close')]");
			ut.click(by);
	}
	 
	 public void clickContentOnlyButton() {
		 By contentOnlyButtonBy = By.xpath("//button[contains(@title,'Content Only')]");
		 ut.click(contentOnlyButtonBy);
	 }
	 
	 public void clickListFilter() {
		 By filterChoiceBy = By.xpath("//coral-selectlist-item[contains(text(),'Filter')]");
		 ut.click(filterChoiceBy);
	 }
	 
	 public void clickAccordion(String text) {
		 By accordionBy = By.xpath("//coral-accordion-item-label[contains(text(),'"+text+"')]");
		 ut.click(accordionBy);
	 }
	 
	 public void enterMinMaxFileSize(String min, String max) {
		 By minSizeBy = By.xpath("//input[@id='coral-id-188']");
		 By maxSizeBy = By.xpath("//input[@id='coral-id-189']");
		 driver.findElement(minSizeBy).sendKeys(min);
		 driver.findElement(maxSizeBy).sendKeys(max);
	 }
	 
	 public void typeSearchText(String text) {
		 By searchTextBy = By.xpath("//input[@name='fulltext']");
		 WebElement element = driver.findElement(searchTextBy);
		 element.clear();
		 element.sendKeys(text);
		 element.submit();
	 }
	 
	 
		
}
	

