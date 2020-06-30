package aem.tests;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import aem.utils.Utils;

public class ListenerClass implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		Logger log = (Logger) result.getAttribute("logger");
		String browser = (String) result.getAttribute("browser");
		String suite = result.getTestContext().getCurrentXmlTest().getSuite().getName();
		String test = result.getTestContext().getName();
		String instance = result.getInstanceName();
		String method = result.getName();
		String message = "Suite:"+suite+" Test:"+test+" Instance:"+instance+" Method:"+method+" Browser:"+browser;
		log.debug("Test Start: "+message);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Logger log = (Logger) result.getAttribute("logger");
		String browser = (String) result.getAttribute("browser");
		String suite = result.getTestContext().getCurrentXmlTest().getSuite().getName();
		String test = result.getTestContext().getName();
		String instance = result.getInstanceName();
		String method = result.getName();
		String message = "Suite:"+suite+" Test:"+test+" Instance:"+instance+" Method:"+method+" Browser:"+browser;
		log.debug("Test Success: "+message);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Utils ut = (Utils) result.getAttribute("utils");
		Logger log = (Logger) result.getAttribute("logger");
		String browser = (String) result.getAttribute("browser");
		String suite = result.getTestContext().getCurrentXmlTest().getSuite().getName();
		String test = result.getTestContext().getName();
		String instance = result.getInstanceName();
		String method = result.getName();
		ut.takeScreenShot(result.getName()+"_failedtest_"+browser+".png");
		String message = "Suite:"+suite+" Test:"+test+" Instance:"+instance+" Method:"+method+" Browser:"+browser;
		log.debug("Test Failure: "+message);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Logger log = (Logger) result.getAttribute("logger");
		String browser = (String) result.getAttribute("browser");
		String suite = result.getTestContext().getCurrentXmlTest().getSuite().getName();
		String test = result.getTestContext().getName();
		String instance = result.getInstanceName();
		String method = result.getName();
		String message = "Suite:"+suite+" Test:"+test+" Instance:"+instance+" Method:"+method+" Browser:"+browser;
		log.debug("Test Skipped: "+message);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub 
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
