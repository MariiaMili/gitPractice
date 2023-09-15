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
		System.out.println(Driver.getDriver().getTitle());
	}

	@Then("I should see the header {string}")
	public void i_should_see_the_header(String string) {
		utils.waitForElementToBeVisible(dashPage.dashoboard_salesexpenses_header);
		Assert.assertTrue(dashPage.dashoboard_salesexpenses_header.isDisplayed());
		
		Driver.quitDriver();
	}
}