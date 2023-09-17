package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;
public class PaymentPage {
	public PaymentPage() {
		PageFactory.initElements(Driver.getDriver(), this);
}
	@FindBy (partialLinkText = "Payments")
	public WebElement payments_link;
	
	@FindBy (xpath = "//button[text()=' Add Payment']")
	public WebElement payments_addpayment_button;
	
	@FindBy (xpath = "//h3[text()='Payments']")
	public WebElement payments_payment_header;
}
