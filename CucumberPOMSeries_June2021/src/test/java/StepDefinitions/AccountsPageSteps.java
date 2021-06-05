package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountspage;
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
	    List<Map<String, String>> credList = dataTable.asMaps();
	    String uid = credList.get(0).get("username");
	    String pwd = credList.get(0).get("password");
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    accountspage = loginpage.doLogin(uid, pwd);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	   String accountsPageTitle = accountspage.AccountsPageTitle();
	   System.out.println("The accounts page title is: "+accountsPageTitle);
	}
	

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable secTable) {
	   List<String> expAccountsSectionsList = secTable.asList();
	   System.out.println("Expected accounts sections list: "+expAccountsSectionsList);
	   List<String> actualAccountsSeclist = accountspage.getAccountsSectionList();
	   System.out.println("Actual accounts sections list: "+actualAccountsSeclist);
	   Assert.assertTrue(expAccountsSectionsList.containsAll(expAccountsSectionsList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
	   Assert.assertTrue(accountspage.getAccountsSection() == expectedSectionCount);
	}

}
