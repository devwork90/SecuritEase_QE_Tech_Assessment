package SecuritEase.sipho_qa_demo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SecuritEase.sipho_qa_demo.AbstractComponents.AbstractComponent;

public class SportContentIndexer extends AbstractComponent{
	
	WebDriver driver;
	public SportContentIndexer(WebDriver driver) 
	{
		super(driver);
		//initialization of all used webElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//span[@class='ssrcss-1tt7th2-SearchText eki2hvo11']")
	WebElement bbc_search_locator;
	
	@FindBy(xpath="(//input[@id='searchInput'])[1]")
	WebElement bbc_search_inputbox_locator;
	
	By bbs_selector_await = By.xpath("(//input[@id='searchInput'])[1]");
	
	@FindBy(xpath="//ul[@class='ssrcss-1020bd1-Stack e1y4nx260']")
	WebElement ulLocator;
	
	//Find the <ul> Element
//    WebElement ulElement = (WebElement) ulLocator;
	
	By awaited_List_element = By.tagName("li");
	
	@FindBy(tagName = "li")
	WebElement searchResults;
	
	public void getFourRelevantSportResults()
	{
		bbc_search_locator.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.cursor = 'none'");
        
        waitForElementToBeVissible(bbs_selector_await);
        bbc_search_inputbox_locator.sendKeys("Sport in 2023");
        bbc_search_inputbox_locator.sendKeys(Keys.ENTER);
        
      //Wait until the elements until all child li elements are visible
        waitForElementToBeVissible(awaited_List_element);
        List<WebElement> searchResults = ulLocator.findElements(By.tagName("li"));
        
        // Assert that there are at least 4 results
        //Assert.assertTrue(searchResults.size() >= 4, "Less than 4 search results found");
	    if (searchResults.size() >= 4){
	    	System.out.print(true);
	    }else {
	    	System.out.println(false);
	    }
	}
	
}
