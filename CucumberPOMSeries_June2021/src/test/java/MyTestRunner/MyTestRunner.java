package MyTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		publish = true,
		features = {"src/test/resources/com/Appfeatures"},
		glue= {"StepDefinitions","Apphooks","parallel"},
	    plugin = {"pretty",
	    		"timeline:test-output-thread/"},
	    monochrome = true,
	    strict = true
		//"html:target/cucumber", "json:target/cucumber.json"
		//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		)
public class MyTestRunner {

	
	
}
