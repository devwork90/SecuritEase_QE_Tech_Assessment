package SecuritEase.sipho_qa_demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SecuritEase.sipho_qa_demo.AbstractComponents.AbstractComponent;

public class Formula1FeedSelector extends AbstractComponent{
	
	WebDriver driver;
	public  Formula1FeedSelector(WebDriver driver) 
	{
		super(driver);
		//initialization of all used webElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	//PageFactory
	@FindBy(xpath="(//span[@class='ssrcss-1u47p8g-LinkTextContainer eis6szr1'][normalize-space()='Formula 1'])[1]")
	WebElement formular1_element_selector;
	
	@FindBy(xpath="(//h1[normalize-space()='Formula 1'])[1]")
	WebElement headingElement;
	
	public String getFormula1SportPage()
	{
		try {
			formular1_element_selector.click();
		
			// Get the page source (HTML content)
			String pageContent = driver.getPageSource();
			return pageContent;
		}catch (Exception e) {
			return null;
		}
	}
	
}
