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
	
}
