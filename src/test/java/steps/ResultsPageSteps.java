package steps;

import org.testng.Assert;

import cucumber.api.java.en.Then;

public class ResultsPageSteps {

	private World world;
	
	public ResultsPageSteps(World world) {
		this.world = world;
	}
	
	@Then("The search results should be displayed on a new page")
	public void the_search_results_should_be_displayed_on_a_new_page() {
	    Assert.assertFalse(world.resultsPage.equals(null));
	}
	
}
