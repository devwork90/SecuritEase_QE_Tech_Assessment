package SecuritEase.sipho_qa_demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.testng.annotations.Test;

import SecuritEase.sipho_qa_demo.TestComponent.BaseTest;
import SecuritEase.sipho_qa_demo.pageobjects.SportContentIndexer;

public class SearchResultsRetrieveTest extends BaseTest{
	
	
	@Test
	public void bbcSportArticlesRetriev() throws TimeoutException, IOException
	{
	// TODO Auto-generated method stub
	
	SportContentIndexer sportContentIndexer = new SportContentIndexer(driver);
	sportContentIndexer.getFourRelevantSportResults();
	}

}
