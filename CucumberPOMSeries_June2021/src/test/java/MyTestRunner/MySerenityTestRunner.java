package MyTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;



	@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(
			publish = true,
			features = {"src/test/resources/com/Appfeatures"},
			glue= {"parallel"},
		    plugin = {"pretty",
		    		"timeline:test-output-thread/"}
			)
	
	public class MySerenityTestRunner {
	
}
