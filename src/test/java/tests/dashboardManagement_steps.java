package tests;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pages.DashboardPage;
import utils.BrowserUtils;
import utils.Driver;

public class dashboardManagement_steps {
	BrowserUtils utils = new BrowserUtils();
	DashboardPage dashPage = new DashboardPage();

	@Then("I should be on the Dashboard home page")
	public void i_should_be_on_the_dashboard_home_page() {
		utils.waitForElementToBeVisible(dashPage.dashoboard_salesexpenses_header);
//		System.out.println(Driver.getDriver().getTitle());
	}

	@Then("I should see the header {string}")
	public void i_should_see_the_header(String string) {
		utils.waitForElementToBeVisible(dashPage.dashoboard_salesexpenses_header);
		Assert.assertTrue(dashPage.dashoboard_salesexpenses_header.isDisplayed());

		Driver.quitDriver();
	}

//	@dashboardButtons -start
	@Then("I should see the buttons {string},{string}, {string} and {string}")
	public void i_should_see_the_buttons_and(String amountdue, String customers, String invoices, String estimates) {
		if (dashPage.dashoboard_amountdue_button.getText().contains(amountdue)) {
			Assert.assertTrue(true);
		}
		if (dashPage.dashoboard_customers_button.getText().contains(customers)) {
			Assert.assertTrue(true);
		}
		if (dashPage.dashoboard_invoices_button.getText().contains(invoices)) {
			Assert.assertTrue(true);
		}
		if (dashPage.dashoboard_estimates_button.getText().contains(estimates)) {
			Assert.assertTrue(true);
		}
		Driver.quitDriver();
	}

//	 @DashboardHeaders - start
	@Then("I should see the headers {string} and {string}")
	public void i_should_see_the_headers_and(String dueinvoices, String recentestimates) {
		if (dashPage.dashoboard_dueinvoices_header.getText().contains(dueinvoices)) {
			Assert.assertTrue(true);
			System.out.println("The header Due Invoices is displayed");
		}
		if (dashPage.dashoboard_recentestimates_header.getText().contains(recentestimates)) {
			Assert.assertTrue(true);
			System.out.println("The header Recent Estimates is displayed");
		}
		Driver.quitDriver();
	}

//	@DashboardGraph- start
	@Then("I should see the graph and a dropdown menu having options {string} and {string}")
	public void i_should_see_the_graph_and_a_dropdown_menu_having_options_and(String thisyear, String previousyear) {
		utils.waitForElementToBeVisible(dashPage.dashoboard_graph);
		Assert.assertTrue(dashPage.dashoboard_graph.isDisplayed());
		Assert.assertTrue(dashPage.dashoboard_year_dropdown.isDisplayed());
		dashPage.dashoboard_year_dropdown.click();
		utils.waitForElementToBeVisible(dashPage.dashoboard_previousyear_dropdown_option);
		Assert.assertTrue(dashPage.dashoboard_thisyear_dropdown_option.isDisplayed());
		Assert.assertTrue(dashPage.dashoboard_previousyear_dropdown_option.isDisplayed());

		Driver.quitDriver();
	}
}