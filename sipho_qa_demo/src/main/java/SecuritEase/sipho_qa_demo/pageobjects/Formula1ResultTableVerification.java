package SecuritEase.sipho_qa_demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Formula1ResultTableVerification {
	
	WebDriver driver;
	public Formula1ResultTableVerification(WebDriver driver) 
	{
		//initialization of all used webElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='Results']")
	WebElement results_selector_element_selector;

	public void getFormula1ResultsTable()
	{
		results_selector_element_selector.click();
	}
}
