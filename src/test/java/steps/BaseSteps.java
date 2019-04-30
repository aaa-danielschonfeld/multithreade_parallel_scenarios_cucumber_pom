package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseSteps {

	private World world;
	
	public BaseSteps(World world) {
		this.world = world;
	}
	
	@Before()
	public void setUp(Scenario s) {
		world.test = world.rep.startTest(s.getName());
		world.setExtentTest(world.test);
		String browser = System.getProperty("browserType");
		world.openBrowser(browser);
		world.getExtTest().assignCategory(browser);
	}

	@After()
	public void endTest() {
		world.tearDown();
	}

}