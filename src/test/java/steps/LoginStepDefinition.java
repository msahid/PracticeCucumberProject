package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.DatabasePage;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefinition extends TestBase {
	
	LoginPage loginPage;
	DatabasePage databasePage;

	@Before
	public void methodName() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		databasePage = new DatabasePage();
	}

	@Given("^User is on the TechFios login page$")
	public void user_is_on_the_TechFios_login_page() {
		driver.get("https://techfios.com/billing/?ng=login/");
	}

	@When("^User enters username as \"([^\"]*)\"$")
	public void user_enters_username_as(String username) {
		loginPage.enterUserName(username);

	}

	@When("^User enters \"([^\"]*)\" from database$")
	public void user_enters_from_database(String userData) {
//		if (userData.equalsIgnoreCase("username")) {
//			loginPage.enterUserName("");
//
//		} else if (userData.equalsIgnoreCase("password")) {
//			loginPage.enterPassword("");
//
//		} else {
//			System.out.println("Unable to retrive data:'" + userData + "' from DB!");
//		}

		switch (userData) {
		case "username":
			loginPage.enterUserName(databasePage.getDataFromDb("username"));
			System.out.println("Username From DB"+ databasePage.getDataFromDb("username"));
			break;

		case "password":
			loginPage.enterPassword(databasePage.getDataFromDb("password"));
			System.out.println("Password From DB"+ databasePage.getDataFromDb("password"));
			break;

		default:
			System.out.println("Unable to retrive data:'" + userData + "' from DB!");

		}

	}

	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) {
		loginPage.enterPassword(password);
	}

	@When("^User clicks on submit button$")
	public void user_clicks_on_submit_button() {
		loginPage.clickSignInButton();

	}

	@Then("^User should land on dashboard page$")
	public void user_should_land_on_dashboard_page() {
		Assert.assertEquals("Dashboard- iBilling", loginPage.getPageTitle());
		takeScreenShot(driver);

	}

	@Then("^User should not land on dashboard page$")
	public void user_should_not_land_on_dashboard_page() {
		Assert.assertEquals("Login - iBilling", loginPage.getPageTitle());
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
