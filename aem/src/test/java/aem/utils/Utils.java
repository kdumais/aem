package aem.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

public class Utils  {
	public WebDriver driver;
	
	public Utils(WebDriver driver)  { 
		this.driver=driver;
	}
	
	
	public void sleep(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void takeScreenShot(Properties prop, String fileName) {
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
	
	public void click(By by) {
		FluentWait<WebDriver> wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();
		
	}
		
	public void sendKeys(By by, String text) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
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
	
	
	
	
	
}
