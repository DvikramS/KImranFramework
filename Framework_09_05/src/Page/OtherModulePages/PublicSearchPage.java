package Page.OtherModulePages;

import org.openqa.selenium.By;

import Base.BasePage;

public class PublicSearchPage {

	private static String keywordTextBox="//*[@class='form-body']/div/div[1]/input";
	private static String searchButton="//*[@class='form-body']/div[1]/div[2]/input";
	private static String searchResultboxLoad="//*[@id='documentlist']/li[1]";
	
	private static String searchedResultStart="//*[@id='documentlist']/li/div/p/a[contains(text(),'";
	private static String searchedResultEnd="')]";
	
	private static String searchedDocumentText;
	private static String searchedAssertText1;
	
	public static String SearchResult(String DocumentValue)
	{
		searchedDocumentText=searchedResultStart+DocumentValue + searchedResultEnd;
		
		BasePage.driver.findElement(By.xpath(keywordTextBox)).sendKeys(DocumentValue);
		BasePage.driver.findElement(By.xpath(searchButton)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(searchResultboxLoad);
		searchedAssertText1=BasePage.driver.findElement(By.xpath(searchedDocumentText)).getText();
		return(searchedAssertText1);
		
	}
}
