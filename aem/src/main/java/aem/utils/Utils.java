package aem.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.testng.Assert;

public class Utils  {
	public WebDriver driver;
	public Properties prop;
	
	public Utils(WebDriver driver, Properties prop)  { 
		this.driver=driver;
		this.prop=prop;
	}
	
	
	public void sleep(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void takeScreenShot(String fileName) {
    	//Convert web driver object to TakeScreenshot
    	TakesScreenshot scrShot =((TakesScreenshot)driver);
    	//Call getScreenshotAs method to create image file
    	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
    	//Move image file to new destination
    	String path=prop.getProperty("screenshotdir");
    	File DestFile=new File(path+fileName);
    	//Copy file at destination
    	try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
	}
	
	public int getNumberOfElementsOnPage() {
		List<WebElement> list = driver.findElements(By.xpath("//*"));
		int count = list.size();
		return count;
	}
	
	public int getNumberOfElements(By by) {
		List<WebElement> list = driver.findElements(by);
		int count = list.size();
		return count;
	}
	
	public void click(By by) {
		FluentWait<WebDriver> wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();
		
	}
		
	public void sendKeys(By by, String text) {
		WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
		element.clear();
		element.sendKeys(text);
	}
	
	public WebElement getElement(By by) {
		return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void assertPageTitle(String expected) {
		String title=driver.getTitle();
		Assert.assertEquals(title, expected);
	}
	
	public void assertElementPresent(By by) {
		Assert.assertTrue(driver.findElements(by).size()>0);
	}
	
	public void assertElementNotPresent(By by) {
		Assert.assertTrue(driver.findElements(by).size()==0);
	}
	
	
	
	
	
	
	
	
	
	
	
	public void addBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public void generateAlert(String message ) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public void refreshBrowserByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
	public String getTitleByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title").toString();
		return title;
	}
	
	public String getPageInnerText() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText").toString();
		return pageText;
	}
	
	public void scrollPageDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}
