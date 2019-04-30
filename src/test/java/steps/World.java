package steps;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.LandingPage;
import pageObjects.ResultsPage;
import utils.ExtentManager;

public class World {
	public LandingPage landingPage;
	public ResultsPage resultsPage;
	
	private WebDriver driver;
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return dr.get();
	}

	public void setDriver(WebDriver driver) {
		dr.set(driver);
	}
	
	public void openBrowser(String browser) {
		if (browser.equals("chrome")) { 
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
			driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
        	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver");
        	driver = new FirefoxDriver();
        } else {
        	throw new IllegalArgumentException("Invalid argument: " + browser);
        } 
        setDriver(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void quitBrowser() {
		getDriver().quit();
	}
	
	public ExtentTest test;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ThreadLocal<ExtentTest> exTest = new ThreadLocal<ExtentTest>();
	
	public void setExtentTest(ExtentTest et){
		exTest.set(et);
	}
		
	public ExtentTest getExtTest(){	
		return exTest.get();
	}
	
	public void testPassed(String message){
		getExtTest().log(LogStatus.PASS, message);
	}
	
	public void testFailed(Exception e) {
		getExtTest().log(LogStatus.FAIL, e);
		captureScreenshot();
		quitBrowser();
		Assert.fail();
	}
	
	public void tearDown(){		
		if(rep!=null){
			rep.endTest(getExtTest());
			rep.flush();
		}
		quitBrowser();
	}
	
	
	public void captureScreenshot() {
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		String screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + screenshotName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String screenshotPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + screenshotName;
		getExtTest().log(LogStatus.INFO,  " Screenshot -> "+ test.addScreenCapture(screenshotPath));
	}
}