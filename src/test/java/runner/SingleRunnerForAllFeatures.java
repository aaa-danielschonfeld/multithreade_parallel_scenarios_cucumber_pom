package runner;

import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(glue = "steps", plugin = {"json:target/json-cucumber-reports/cukejson.json",
"testng:target/testng-cucumber-reports/cuketestng.xml" }, features = "src/test/java/features/")
public class SingleRunnerForAllFeatures extends AbstractTestNGCucumberTests {
	
	// executes scenarios of all features in parallel, one scenario per thread, default of 10 threads at a time
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	// todo: add tagging
}
