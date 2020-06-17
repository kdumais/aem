package aem.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class BaseTest  {
	public static Properties prop;
	public static SoftAssert softAssert;
	
	@BeforeSuite(groups= {"Important"})
	public void beforeSuite()  {
		prop=new Properties();
		softAssert = new SoftAssert();
		try {
			FileInputStream fis=new FileInputStream("test.properties");
			prop.load(fis);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}
	
	public WebDriver getDriver(String ffProfileName, String browser) {
		WebDriver driver;
		
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckodriverloc"));
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "geckodriver.log");
			FirefoxProfile fp;
			ProfilesIni pi = new ProfilesIni();
		    fp = pi.getProfile(ffProfileName);
		    fp.setPreference("security.default_personal_cert",  "Select Automatically");
		    FirefoxOptions options = new FirefoxOptions();
		    options.setHeadless(Boolean.valueOf(prop.getProperty("headless")));
	        options.setProfile(fp);
	        options.setBinary(prop.getProperty("firefoxloc"));
	        driver = new FirefoxDriver(options);
		} else if (browser.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverloc"));
			System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(Boolean.valueOf(prop.getProperty("headless")));
	        driver = new ChromeDriver(options);
		}else {
			driver = null;
		}
		
		//Zero because explicit waits can be customized how often to check
		//Are not global
		//Can check for various conditions, beyond found element
		//Explicit wait can also ignore certain exceptions
		//elementToBeClickable, numberOfElementsToBeMoreThan, invisibilityOf
		//Complete list https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;        
        
	}
	
}
