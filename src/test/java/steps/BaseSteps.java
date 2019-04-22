package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseSteps {

	private World world;
	
	public BaseSteps(World world) {
		this.world = world;
	}
	
	@Before()
	public void setUp() {
		String browser = System.getProperty("browserType");
		world.openBrowser(browser);
	}

	@After()
	public void endTest() {
		world.quitBrowser();
	}

}