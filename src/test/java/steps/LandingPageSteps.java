package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;

public class LandingPageSteps {
	private World world;
	
	public LandingPageSteps(World world) {
		this.world = world;
	}
	
	@Given("^I navigate to the landing page for \"([^\"]*)\"$")
	public void i_navigate_to_the_landing_page_for_the_club_specified(String club) throws Throwable {
		world.getExtTest().log(LogStatus.INFO, "Given: I navigate to the landing page for " + club);
		String url;
		switch (club) {
		case "texas":
			url = "https://cruises.texas.aaa.com/cruise";
			break;
		case "california":
			url = "https://cruises.texas.aaa.com/cruise";
			break;
		case "new mexico":
			url = "https://cruises.texas.aaa.com/cruise";
			break;
		case "pennsylvania":
			url = "https://cruises.texas.aaa.com/cruise";
			break;
		default:
			throw new IllegalArgumentException("Invalid argument: " + club);
		}		
		world.getExtTest().assignCategory(club);
  
		try {
			world.landingPage = new LandingPage(world.getDriver());
			world.landingPage.navigate(url);	
		} catch(Exception e) {
			world.testFailed(e);
		}
	}
	
	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		world.getExtTest().log(LogStatus.INFO, "When: I click on the search button");
		try {
			world.resultsPage = world.landingPage.clickSearchButton();	
		} catch(Exception e) {
			world.testFailed(e);
		}
	}
}
