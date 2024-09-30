package SecuritEase.sipho_qa_demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import org.testng.annotations.Test;

import SecuritEase.sipho_qa_demo.TestComponent.BaseTest;
import SecuritEase.sipho_qa_demo.pageobjects.Formula1FeedSelector;
import SecuritEase.sipho_qa_demo.pageobjects.Formula1ResultTableValidator;
import SecuritEase.sipho_qa_demo.pageobjects.Formula1ResultTableVerification;

public class TableResultsValidationTest extends BaseTest{

		@Test
		public void bbcSportNewsRender() throws TimeoutException, IOException
		{
		// TODO Auto-generated method stub
		Formula1FeedSelector resultTableValidator = new Formula1FeedSelector(driver);
		resultTableValidator.getFormula1SportPage();
		
		Formula1ResultTableVerification formula1ResultTableVerification = new Formula1ResultTableVerification(driver);
		formula1ResultTableVerification.getFormula1ResultsTable();
		
		Formula1ResultTableValidator formula1ResultTableValidator = new Formula1ResultTableValidator(driver);
		try {
			List<Object> myList = new ArrayList<>(); 
			myList = formula1ResultTableValidator.reportGrandPrixResults();
			for (Object item : myList) {
			    System.out.println(item);
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
