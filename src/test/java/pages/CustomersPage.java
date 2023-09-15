package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class CustomersPage {
	public CustomersPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//h3[text()='Customers']")
	public WebElement customer_page_Customers_TextHeader;
	
	@FindBy (xpath = "//h3[text()='New Customer']")
	public WebElement customer_page_NewCustomer_TextHeader;

	@FindBy(xpath = "//button[text()=' New Customer']")
	public WebElement customer_page_NewCustomerBTN;

	@FindBy(xpath = "//h6[text()='Basic Info']")
	public WebElement customer_page_basic_info_label;

	@FindBy(xpath = "(//input[@name='name'])[1]")
	public WebElement customer_page_BasicInfo_DisplayName_Field;

	@FindBy(xpath = "(//div[@class='relative rounded-md shadow-sm font-base']/input)[2]")
	public WebElement customer_page_BasicInfo_PrimaryContactName_Field;

	@FindBy(xpath = "(//input[@name='phone'])[1]")
	public WebElement customer_page_BasicInfo_Phone_Field;

	@FindBy(xpath = "(//div//child::input[@type='text'])[6]")
	public WebElement customer_page_BasicInfo_PrimaryCurrency_Field;

	@FindBy(xpath = "//input[@name='email']")
	public WebElement customer_page_BasicInfo_Email_Field;

	@FindBy(xpath = "//input[@type='url']")
	public WebElement customer_page_BasicInfo_Website_Field;

	@FindBy(xpath = "(//input[@name='name'])[2]")
	public WebElement customer_page_BasicInfo_Prefix_Field;

	@FindBy(xpath = "//table")
	public WebElement customer_page_CustomerTable;

	@FindBy(css = ".min-w-full")
	public WebElement customer_page_Customer_List_Table;

	@FindBy(xpath = "//label[text()='No customers yet!']")
	public WebElement customer_page_NoCustomersYet_text;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement customer_page_NewCustomerSubmit_BTN;

	// @CustomerTableColumns
	@FindBy(xpath = "//th[contains(text(), 'Name')]")
	public WebElement customer_page_name_column;

	@FindBy(xpath = "//th[contains(text(), 'Phone')]")
	public WebElement customer_page_phone_column;

	@FindBy(xpath = "//th[contains(text(), 'Amount Due')]")
	public WebElement customer_page_amount_due_column;

	@FindBy(xpath = "//th[contains(text(), 'Added On')]")
	public WebElement customer_page_added_on_column;

	@FindBy(xpath = "(//button[contains(@id, 'headlessui-menu-button')])[3]")
	public WebElement customer_page_3dot_menu;
	
	@FindBy (xpath = "(//button[contains(@id, 'headlessui')])[3]")
	public WebElement customer_page_customerTable_3dotMoreLink;

	@FindBy(xpath = "(//div[@data-popper-placement='bottom-end'])[3]")
	public WebElement customer_page_3dot_menu_block;
	
	@FindBy (xpath = "(//button[contains(@id, 'headlessui')])[4]")
	public WebElement customer_page_newCustomer_3dotMoreLink;

	@FindBy(xpath = "//a[text()=' Edit']")
	public WebElement customer_page_3dot_edit_option;

	@FindBy(xpath = "//a[text()=' View']")
	public WebElement customer_page_3dot_view_option;

	@FindBy(xpath = "//a[text()=' Delete']")
	public WebElement customer_page_3dot_delete_option;

	
	
	@FindBy(xpath = "//h3[text()='New Customer']")
	public WebElement customer_page_new_customer_text_header;

	@FindBy(xpath = "//button[text()=' Save Customer']")
	public WebElement customer_page_save_customer_button;

	@FindBy(xpath="//input[@name='name']")
	public WebElement customer_page_display_name_field;
	
	@FindBy(xpath="//p[text()='Customer created successfully']")
	public WebElement customer_page_new_customer_success_message;
	
	@FindBy(xpath="//button[contains(@id, 'headlessui')])[4]")
	public WebElement customer_page_new_customer_3dot_more_link;
	
	@FindBy(xpath="//span[text()='Field is required']")
	public WebElement customer_page_field_required_error_message;
	
	@FindBy(xpath = "//button[text()='Ok']")
	public WebElement customer_page_customer_table_3dot_more_link_delete_ok_button;
	
	
	//creating new customer
	@FindBy(xpath="(//div[text()='Select Country'])[1]")
	public WebElement customer_page_new_customer_billing_country_field;
	
	@FindBy (xpath ="//input[@name='billing.state']")
	public WebElement customer_page_new_customer_billing_state_field;
	
	@FindBy (xpath = "(//input[@name='address_name'])[1]")
	public WebElement customer_page_new_customer_billing_name_field;
	
	@FindBy (xpath ="//input[@name=\'billing.city\']")
	public WebElement customer_page_new_customer_billing_city_field;
	
	@FindBy (xpath ="(//input[@name=\"zip\"])[1]")
	public WebElement customer_page_new_customer_billing_zip_city;
	
	@FindBy (xpath ="//button[text()=' Copy from Billing']")
	public WebElement customer_page_new_customer_copy_from_billing_button;
	
	@FindBy (xpath = "//input[@name='address_name']")
	public WebElement customer_page_new_customer_shipping_name_field;
	
	@FindBy(xpath="(//input[@type='text']//following-sibling::div[text()='Select Country'])[1]")
	public WebElement customer_page_new_customer_billing_country_dropdown;
	
	@FindBy(xpath="(//span[text()='United States'] )[1]")
	public WebElement customer_page_new_customer_billing_country_dropdown_USA;
	
	@FindBy(xpath="//h6[text()=' Sales & Expenses']")
	public WebElement customer_page_sales_and_expenses_header;
	
	
	//@homework
	@FindBy(xpath="//span[text()='Incorrect Email.']")
	public WebElement customer_page_incorrect_email_error_message;
	
	@FindBy(xpath="//span[text()='Field is required']")
	public WebElement customer_page_display_name_field_required_error_message;
	
	@FindBy(xpath="(//span[text()='Incorrect Email.'] | //span[text()='Name must have at least 3 letters.'] | //span[text()='Field is required'])")
	public List<WebElement> customer_page_basic_info_error_messages;
	
	//span[text()='Incorrect Email.']
	//span[text()='Name must have at least 3 letters.']
	//span[text()='Field is required']
}
