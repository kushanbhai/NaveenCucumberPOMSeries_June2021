package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ContactUsSteps {
	private ContactUsPage contactsuspage = new ContactUsPage(DriverFactory.getDriver());

	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("C:\\Users\\91900\\Desktop\\automation.xlsx\\", sheetName);
		String heading = testData.get(rowNumber).get("subjectHeading");
		String email = testData.get(rowNumber).get("email");
		String orderref = testData.get(rowNumber).get("orderref");
		String message = testData.get(rowNumber).get("message");

		contactsuspage.fillContactUsForm(heading, email, orderref, message);
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactsuspage.clickSend();
	}

	@Then("it shows successful message {string}")
	public void it_shows_successful_message(String expSuccMsg) {
		String actualSuccMsg = contactsuspage.getSuccessMessg();
		Assert.assertEquals(actualSuccMsg, expSuccMsg);
	}
}
