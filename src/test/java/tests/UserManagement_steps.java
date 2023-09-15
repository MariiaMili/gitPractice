package tests;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;
import pages.DashboardPage;

public class UserManagement_steps {

	BrowserUtils utils = new BrowserUtils();
	LoginPage loginpage = new LoginPage();
	DashboardPage dashboardpage = new DashboardPage();

//valid credential login test - start
	@Given("As a user, I am on the login page")
	public void as_a_user_i_am_on_the_login_page() {
		Driver.getDriver().get(TestDataReader.getProperty("appurl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Driver.getDriver().manage().window().maximize();
		utils.waitForElementToBeVisible(loginpage.login_page_email_box);
	}

	@When("I enter valid usermail and valid password")
	public void ienter_valid_usermail_and_valid_password() {
		utils.sendkeysWithActionsClass(loginpage.login_page_email_box, TestDataReader.getProperty("email"));
		utils.sendkeysWithActionsClass(loginpage.login_page_password_box, TestDataReader.getProperty("password"));
	}

	@When("Click on login button")
	public void click_on_login_button() {
		loginpage.login_page_login_btn.click();
	}

	@Then("I should be logged in")
	public void i_should_be_logged_in() {
		utils.waitUntilElementVisibleWithLocator(By.xpath("//span[text()]='Amount Due']"));
		Assert.assertTrue(dashboardpage.dashboard_tab.isDisplayed());
	}
	// valid credential login test - end

	// invalid email login attempt - start
	@When("I enter invalid usermail and valid password")
	public void i_enter_invalid_usermail_and_valid_password() {
		utils.sendkeysWithActionsClass(loginpage.login_page_email_box, "yummy@primetechschool.com");
		utils.sendkeysWithActionsClass(loginpage.login_page_password_box, TestDataReader.getProperty("password"));
	}

	@Then("I should see an error message {string} displays")
	public void i_should_see_an_error_message_displays(String errorMessage) {
		utils.waitForElementToBeVisible(loginpage.login_page_invalidLogin_message);
		Assert.assertEquals(errorMessage, loginpage.login_page_invalidLogin_message.getText());
		Assert.assertEquals(5, 5);
	}

	@Then("I should not be logged in")
	public void i_should_not_be_logged_in() {
		Assert.assertTrue(loginpage.login_page_login_btn.isDisplayed());
	}
	// invalid email login attempt - end

	// invalid login attempts - start
	@When("I enter invalid useremail {string} and password {string}")
	public void i_enter_invalid_useremail_and_password(String useremail, String password) {
		utils.sendkeysWithActionsClass(loginpage.login_page_email_box, useremail);
		utils.sendkeysWithActionsClass(loginpage.login_page_password_box, password);
	}

	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
		utils.waitForAllElementsToBeVisible(loginpage.login_page_all_error_messages);
		Assert.assertFalse(loginpage.login_page_all_error_messages.isEmpty());
		
	}
	//
	
	}


