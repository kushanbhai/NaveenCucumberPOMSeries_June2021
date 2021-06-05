package StepDefinitions;

import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		publish = true,
		features = { "src/test/resources/com/Appfeatures" }, 
		glue = {
				"StepDefinitions","Apphooks","parallel" }, plugin = { "pretty"
		,"timeline:test-output-thread/",
		"rerun:target/failedrerun.txt"
}, 
						//tags = "not @Skip",
						monochrome = true, strict = true

)
//src/test/resources/com/Appfeatures

public class ParallelRun extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
