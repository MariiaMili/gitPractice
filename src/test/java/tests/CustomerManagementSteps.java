package tests;

import org.junit.Assert;
import org.openqa.selenium.By;

import utils.BrowserUtils;
import utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CustomersPage;
import pages.DashboardPage;

public class CustomerManagementSteps {

	BrowserUtils utils = new BrowserUtils();
	DashboardPage dashPage = new DashboardPage();
	CustomersPage customerPage = new CustomersPage();

	static String name;

	@When("I navigate to the customers tab")
	public void i_navigate_to_the_customers_tab() {
		utils.waitForElementToBeVisible(dashPage.customers_tab);
		dashPage.customers_tab.click();
		utils.waitForElementToBeVisible(customerPage.customer_page_Customers_TextHeader);
		Assert.assertTrue(customerPage.customer_page_Customers_TextHeader.isDisplayed());

	}

	@Then("I should see the New Customer button displayed")
	public void i_should_see_the_new_customer_button_displayed() {
		Assert.assertTrue(customerPage.customer_page_NewCustomerBTN.isDisplayed());
		Driver.quitDriver();
	}

	@When("I click on the New Customer button")
	public void i_click_on_the_new_customer_button() {
		utils.waitForElementToBeVisible(customerPage.customer_page_NewCustomerBTN);
		customerPage.customer_page_NewCustomerBTN.click();
	}

	@Then("I should see the Basic Info form label")
	public void i_should_see_the_basic_info_form_label() {
		utils.waitForElementToBeVisible(customerPage.customer_page_basic_info_label);
		Assert.assertTrue(customerPage.customer_page_basic_info_label.isDisplayed());
		Driver.quitDriver();
	}
	// @newCustomerBasicInfoFormLabel - end

	// @newCustomerBasicInfoFormFields - start
	@Then("I should see the fields Display name, Primary Contact Name,, Email, Primary Currency,Website and Prefix")
	public void i_should_see_the_fields_display_name_primary_contact_name_email_primary_currency_website_and_prefix() {
		utils.waitForElementToBeVisible(customerPage.customer_page_BasicInfo_DisplayName_Field);

		if (customerPage.customer_page_BasicInfo_DisplayName_Field.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Display Name Field visible, PASS");
		} else {
			Assert.assertTrue(false);
			System.out.println("Display Name Field not visible, FAIL");
		}
		Assert.assertTrue(customerPage.customer_page_BasicInfo_DisplayName_Field.isDisplayed());
		Assert.assertTrue(customerPage.customer_page_BasicInfo_PrimaryContactName_Field.isDisplayed());
		Assert.assertTrue(customerPage.customer_page_BasicInfo_Email_Field.isDisplayed());
		Assert.assertTrue(customerPage.customer_page_BasicInfo_PrimaryCurrency_Field.isDisplayed());
		Assert.assertTrue(customerPage.customer_page_BasicInfo_Website_Field.isDisplayed());
		Assert.assertTrue(customerPage.customer_page_BasicInfo_Prefix_Field.isDisplayed());
		Driver.quitDriver();
	}

	// @newCustomerTableList - start
	@Then("I should see the Customer List Table")
	public void i_should_see_the_customer_list_table() {
		utils.waitForElementToBeVisible(customerPage.customer_page_Customers_TextHeader);

		if (customerPage.customer_page_NoCustomersYet_text.isDisplayed()) {
			customerPage.customer_page_NewCustomerBTN.click();
			utils.waitForElementToBeVisible(customerPage.customer_page_BasicInfo_DisplayName_Field);
			customerPage.customer_page_BasicInfo_DisplayName_Field.sendKeys("Student");
			customerPage.customer_page_NewCustomerSubmit_BTN.click();
			dashPage.customers_tab.click();
			// utils.waitForElementToBeVisible(customerPage.customer_page_Customers_TextHeader);
		}
		Assert.assertTrue(customerPage.customer_page_CustomerTable.isDisplayed());

		Driver.quitDriver();
	}

	// @CustomerTableColumns - start
	@Then("I should see table columns NAME, PHONE, AMOUNT DUE, ADDED ON")
	public void i_should_see_table_columns_name_phone_amount_due_added_on() {
		utils.waitForElementToBeVisible(customerPage.customer_page_CustomerTable);

		Assert.assertTrue(customerPage.customer_page_name_column.isDisplayed());
		Assert.assertTrue(customerPage.customer_page_phone_column.isDisplayed());
		Assert.assertTrue(customerPage.customer_page_amount_due_column.isDisplayed());
		Assert.assertTrue(customerPage.customer_page_added_on_column.isDisplayed());

		Driver.quitDriver();
	}

	// @CustomerLinkOptions - start
	@When("I click on More link")
	public void i_click_on_more_link() {
		utils.waitForElementToBeVisible(customerPage.customer_page_CustomerTable);

		customerPage.customer_page_3dot_menu.click();
	}

	@Then("I should see options Edit, View and Delete")
	public void i_should_see_options_edit_view_and_delete() {
		utils.waitForElementToBeVisible(customerPage.customer_page_3dot_menu_block);

		Assert.assertTrue(customerPage.customer_page_3dot_edit_option.isDisplayed());
		Assert.assertTrue(customerPage.customer_page_3dot_view_option.isDisplayed());
		Assert.assertTrue(customerPage.customer_page_3dot_delete_option.isDisplayed());

		Driver.quitDriver();
	}

	// @CreateNewCustomer - start
	@Then("I enter a display name")
	public void i_enter_a_display_name() {
		utils.waitForElementToBeVisible(customerPage.customer_page_new_customer_text_header);
		customerPage.customer_page_BasicInfo_DisplayName_Field.sendKeys("Student");
	}

	@Then("I click save")
	public void i_click_save() {
		customerPage.customer_page_NewCustomerSubmit_BTN.click();
	}

	@Then("I should see the pop up message {string}")
	public void i_should_see_the_pop_up_message(String message) {
		utils.waitForElementToBeVisible(customerPage.customer_page_new_customer_success_message);
		Assert.assertEquals(customerPage.customer_page_new_customer_success_message.getText(), message);

	}

	@Then("I delete the customer")
	public void i_delete_the_customer() {
		utils.waitForElementToBeVisible(dashPage.customers_tab);
		dashPage.customers_tab.click();
		utils.waitForElementToBeVisible(customerPage.customer_page_customerTable_3dotMoreLink);
		customerPage.customer_page_customerTable_3dotMoreLink.click();
		utils.waitForElementToBeVisible(customerPage.customer_page_3dot_delete_option);
		customerPage.customer_page_3dot_delete_option.click();
		utils.waitForElementToBeVisible(customerPage.customer_page_customer_table_3dot_more_link_delete_ok_button);
		customerPage.customer_page_customer_table_3dot_more_link_delete_ok_button.click();

		Driver.quitDriver();
	}

	// @CreateNewCustomerInvalid- start
	@Then("I should see the message {string}")
	public void i_should_see_the_message(String message) {
		utils.waitForElementToBeVisible(customerPage.customer_page_field_required_error_message);
		Assert.assertEquals(customerPage.customer_page_field_required_error_message.getText(), message);

		Driver.quitDriver();
	}

	// @newCustomers - start
	@When("I enter a valid {string}, {string}, {string}, {string}, and {string}")
	public void i_enter_a_valid_and(String displayName, String email, String state, String city, String zipcode) {
		name = displayName;

		utils.waitForElementToBeVisible(customerPage.customer_page_BasicInfo_DisplayName_Field);
		customerPage.customer_page_BasicInfo_DisplayName_Field.sendKeys(name);
		customerPage.customer_page_BasicInfo_Email_Field.sendKeys(email);
		customerPage.customer_page_new_customer_billing_name_field.sendKeys(name);
		customerPage.customer_page_new_customer_billing_city_field.sendKeys(city);
		customerPage.customer_page_new_customer_billing_zip_city.sendKeys(zipcode);
		utils.clickWithActionsClass(customerPage.customer_page_new_customer_billing_country_dropdown);
		utils.waitForElementToBeVisible(customerPage.customer_page_new_customer_billing_country_dropdown_USA);
		utils.clickWithActionsClass(customerPage.customer_page_new_customer_billing_country_dropdown_USA);
		utils.clickWithActionsClass(customerPage.customer_page_new_customer_copy_from_billing_button);

		utils.moveToWithActionsClass(customerPage.customer_page_NewCustomerSubmit_BTN);
		utils.waitUntilElementClickable(customerPage.customer_page_NewCustomerSubmit_BTN);
		customerPage.customer_page_NewCustomerSubmit_BTN.click();
	}

	@Then("I should see the new customer in the data table")
	public void i_should_see_the_new_customer_in_the_data_table() {
		utils.waitForElementToBeVisible(customerPage.customer_page_sales_and_expenses_header);
		Assert.assertTrue(
				Driver.getDriver().findElement(By.xpath("//p[contains(text(), '" + name + "')]")).isDisplayed());
	}
	// @newCustomers end -

	// @customersInvalid - start
	@When("I enter {string} and {string}")
	public void i_enter_and(String displayName, String email) {
		utils.waitForElementToBeVisible(customerPage.customer_page_BasicInfo_DisplayName_Field);
		utils.sendkeysWithActionsClass(customerPage.customer_page_BasicInfo_DisplayName_Field, displayName);
		utils.sendkeysWithActionsClass(customerPage.customer_page_BasicInfo_Email_Field, email);
	}

	@Then("I should see invalid fields error messages")
	public void i_should_see_invalid_fields_error_messages() {
		utils.waitForAllElementsToBeVisible(customerPage.customer_page_basic_info_error_messages);
		Assert.assertFalse(customerPage.customer_page_basic_info_error_messages.isEmpty());

	}

}
