package SecuritEase.sipho_qa_demo.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SecuritEase.sipho_qa_demo.AbstractComponents.AbstractComponent;

public class Formula1ResultTableValidator extends AbstractComponent{
	
	WebDriver driver;
	public Formula1ResultTableValidator(WebDriver driver) 
	{
		super(driver);
		//initialization of all used webElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//	By DatePicker = By.cssSelector("section[aria-label='Date picker']");
	@FindBy(xpath="//div[@type='year'][normalize-space()='2023']")
	WebElement calandar_selector_element_selector;
	
	@FindBy(xpath="//section[1]//h2[1]//button[1]")
	WebElement close_expanded_drop_down_element;
	
	@FindBy(xpath="//span[@data-js-text='true'][normalize-space()='Las Vegas Grand Prix, Las Vegas Street Circuit']")
	WebElement las_vegas_race_selector;
	
	
	By DatePicker = By.cssSelector("section[aria-label='Date picker']");
	By ResultsTable = By.xpath("//*[@id=\"main-data\"]/div");
	
	@FindBy(xpath = "(//tbody)[2]")
	WebElement table;
	
	@FindBy(tagName = "tr")
	List<WebElement> rows;
	
	public List<Object> reportGrandPrixResults() throws InterruptedException, NoSuchElementException, TimeoutException
	{
		// Wait for DatePicker element to be visible
		waitForElementToBeVissible(DatePicker);
		calandar_selector_element_selector.click();
		
		try {
			//close the current expanded drop-down menu
			waitForElementToBeClickable(ResultsTable);
			close_expanded_drop_down_element.click();
		} catch (NoSuchElementException e){
			// Handle the case where there's no expanded drop-down menu to close
	        System.out.println("No expanded drop-down menu found to close.");
		}
		
		// Click on the Las_Vegas Grand_Prix drop-down menu
		las_vegas_race_selector.click();
		
		List<Object> grandPrixResults = new ArrayList<>();
		
		 for (WebElement row : rows) {
			 
			 try {
				 	// Get the cells in the current row
		            List<WebElement> cells = row.findElements(By.tagName("td"));

		            // Access the second cell (assuming Grand Prix results are in the second column)
		            WebElement secondCell = cells.get(1);
		            
		            // Extract the data from the second cell (assuming it's text)
		            String grand_str_PrixResult  = secondCell.getText();
		            
		            // Add the extracted Grand Prix result to the list
		            grandPrixResults.add(grand_str_PrixResult);
			 }catch (IndexOutOfBoundsException e) {
				 
			 } catch (StaleElementReferenceException e) {
		            // Handle cases where elements become stale due to dynamic content updates
		            System.out.println("Element might have become stale due to dynamic content updates.");
		        }
	            
	        }
		
		return grandPrixResults;
	}
}
