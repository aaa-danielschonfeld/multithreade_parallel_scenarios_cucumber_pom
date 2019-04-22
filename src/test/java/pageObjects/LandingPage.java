package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LandingPage {
	
	private WebDriver driver;
	
	@FindBy(id="cruiseSearch")
	public WebElement searchButton;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}
	
	public void navigate(String url) {
		this.driver.get(url);
	}
	
	public ResultsPage clickSearchButton() {
		this.searchButton.click();
		
		try {
			this.driver.findElement(By.id("cruises-container")).isDisplayed();
			return new ResultsPage(this.driver);
		} catch(Exception e) {
			throw e;
		}
	}
	
}
