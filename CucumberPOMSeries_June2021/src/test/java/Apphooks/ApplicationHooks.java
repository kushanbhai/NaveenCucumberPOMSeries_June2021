package Apphooks;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	//public String browserName;
	
	@Before(value="@skip_scenario", order=0)
	public void skip_scenario(Scenario scenario) {
		System.out.println("Skipped Scenario is: "+scenario.getName());
		Assume.assumeTrue(false);
	}
	@Before(order = 1)
	public void getProperty() {
		configreader = new ConfigReader();
		prop = configreader.init_prop();
	}
	
	@Before(order = 2)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_browser(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}
