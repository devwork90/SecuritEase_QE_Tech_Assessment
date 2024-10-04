package SecuritEase.sipho_qa_demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import SecuritEase.sipho_qa_demo.TestComponent.BaseTest;
import SecuritEase.sipho_qa_demo.pageobjects.Formula1FeedSelector;
import SecuritEase.sipho_qa_demo.pageobjects.Formula1ResultTableValidator;
import SecuritEase.sipho_qa_demo.pageobjects.Formula1ResultTableVerification;
import junit.framework.Assert;

public class TableResultsValidationTest extends BaseTest{

		@Test
		public void bbcSportNewsRender() throws TimeoutException, IOException
		{
		// TODO Auto-generated method stub
		Formula1FeedSelector resultTableValidator = new Formula1FeedSelector(driver);
		String table_res = resultTableValidator.getFormula1SportPage();
		WebElement headingElement = driver.findElement(By.xpath("(//h1[normalize-space()='Formula 1'])[1]"));
		String headingText = headingElement.getText();
		Assert.assertTrue(table_res.contains(headingText));
//		Assert.assertEquals("Formula 1", headingText);
		
		Formula1ResultTableVerification formula1ResultTableVerification = new Formula1ResultTableVerification(driver);
		formula1ResultTableVerification.getFormula1ResultsTable();
		
		Formula1ResultTableValidator formula1ResultTableValidator = new Formula1ResultTableValidator(driver);
		try {
			List<Object> myList = new ArrayList<>();
			myList = formula1ResultTableValidator.reportGrandPrixResults();
			
			//Limit the returned list object to the top 3 items
//	        if (myList.size() > 3) {
//	            myList = myList.subList(0, 3);
//	        }
			
			// Filter out null or empty elements and limit to top 3
	        List<Object> top3Results = myList.stream()
	            .filter(item -> item != null && !item.toString().trim().isEmpty()) // Filter out null/empty
	            .limit(3)  // Limit to the top 3 elements
	            .collect(Collectors.toList());
			
			// Expected product names
	        List<String> ActucalDriverNames = Arrays.asList("Max Verstappen", "Charles Leclerc", "Sergio Perez");
			
	        if(ActucalDriverNames.size() != top3Results.size()) {
	        	System.err.println("List sizes are different.");
	        }
			for (int i=0; i<top3Results.size(); i++) {
				Object items = top3Results.get(i);
			    System.out.println(items);
			    
			    // Assert product name and price
			    Assert.assertEquals(items, ActucalDriverNames.get(i));
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
