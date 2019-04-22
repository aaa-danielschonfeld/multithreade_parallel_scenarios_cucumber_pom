package steps;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.LandingPage;
import pageObjects.ResultsPage;

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
}