package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class DashboardPage {

	public DashboardPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (linkText = " Dashboard")
	public WebElement dashboard_tab;
	
	@FindBy (xpath = "//a[text()=' Customers']")
	public WebElement customers_tab;
	
	@FindBy (xpath = "//a[text()=' Items']")
	public WebElement items_tab;
	
	@FindBy (xpath = "//p[text()='Logged in successfully.']")
	public WebElement loggedInSuccess_message;

	@FindBy (xpath = "//h6[text()=' Sales & Expenses']")
	public WebElement dashoboard_salesexpenses_header;
	
	@FindBy (xpath = "//span[text()='Amount Due']")
	public WebElement dashoboard_amountdue_button;
	
	@FindBy (xpath = "//span[text()='Customers']")
	public WebElement dashoboard_customers_button;
	
	@FindBy (xpath = "//span[text()='Invoices']")
	public WebElement dashoboard_invoices_button;
	
	@FindBy (xpath = "//span[text()='Estimates']")
	public WebElement dashoboard_estimates_button;
	
	@FindBy (xpath = "//h6[text()='Due Invoices']")
	public WebElement dashoboard_dueinvoices_header;
	
	@FindBy (xpath = "//h6[text()='Recent Estimates']")
	public WebElement dashoboard_recentestimates_header;
	
	@FindBy (xpath = "//canvas[@id='graph']")
	public WebElement dashoboard_graph;
	
	@FindBy (xpath = "//div[@class='p-0 relative mx-auto w-full flex items-center justify-end box-border cursor-pointer border border-gray-200 rounded-md bg-white text-sm leading-snug outline-none max-h-10']")
	public WebElement dashoboard_year_dropdown;
	
	@FindBy (xpath = "//span[text()='This year']")
	public WebElement dashoboard_thisyear_dropdown_option;
	
	@FindBy (xpath = "//span[text()='Previous year']")
	public WebElement dashoboard_previousyear_dropdown_option;
	
	
}
