package steps;

import org.testng.Assert;

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
		
		world.landingPage = new LandingPage(world.getDriver());
		world.landingPage.navigate(url);	 
	}
	
	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		world.resultsPage = world.landingPage.clickSearchButton();
	}
}
