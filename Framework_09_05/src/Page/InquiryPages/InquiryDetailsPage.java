package Page.InquiryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Util.UtilityFunctions;
import Base.BasePage;

public class InquiryDetailsPage {

	private static String InquiryDetailsAssertLabel1;
	private static String InquiryDetailsAssertLabel2;
	//private static String VerifyEventActionResponseAdded="//*[@id='collapseOne']/table/tbody/tr[1]/td/div/div[contains(text(),'Response Added')]";
	private static String ResponseTypeRadioButton;
	private static String ResponseText="//*[@id='collapseTwo']/div/div[3]/div/div";
	private static String SubmitButton="//*[@id='divInQuiryDetail']/div/div/a[contains(text(),'Submit')]";
	private static String ConfirmationCancelButton="//*[@id='confirmedCancel']";
	public static String InquiryDetailPageLoadAssertPoint="//*[@id='collapseTwo']/div/div[1]/div[1]/div[4]/label/span[contains(text(),'Send Response to Inquirer Via')]";
	public static String InquiryTextLabel="//*[@id='divInQuiryDetail']/div[3]/div[1]/div[1]/div[1]/div[2]/span";
	public static String ActionDropdownsID="//*[@id='ActionDropdownlist']";
	private static String OkButton="//*[@id='confirmedOk']";
	private static String AnswerDropdown="//*[@id='collapseTwo']/div/div[2]/div[1]/select";
	private static String StartInquiryAnswerPath="//*[@id='collapseTwo']/div/div[2]/div[1]/select/option[contains(text(),'";
	private static String EndInquiryAnswerPath="')]";
	
	
	//Variable for SubmitInquiryResponse
	private static String InquiryDetailsAssertlabel1;
	
	//Variables for Apply Action on inquiry details page
	static Select ApplyActiondropdownID;
	private static String InquiryEvent1;
	private static String getText1;
	private static String InquiryDetailsAssertlabel2;
	public static String InquiryDetailsAssertlabel3;
	public static String InquiryDetailsAssertlabel4;
	public static String InquiryAnswerExpected;
	
	public static void NavigateToUpdateInquiry(String QuestionValue)
	{
		String VerifyInquiryText="//*[@id='divInQuiryDetail']/div[3]/div[1]/div/div/div/span[contains(text(),'"+QuestionValue+"')]";
		InquiryDetailsAssertLabel1=BasePage.driver.findElement(By.xpath(VerifyInquiryText)).getText();
		Assert.assertEquals(InquiryDetailsAssertLabel1, QuestionValue);
		
	}
	
	public static String VerifyEventActions(String EventAction)
	{
		String VerifyEventActionResponseAdded="//*[@id='collapseOne']/table/tbody/tr[1]/td/div/div[contains(text(),'"+EventAction+"')]";
		InquiryDetailsAssertLabel2=BasePage.driver.findElement(By.xpath(VerifyEventActionResponseAdded)).getText();
		return(InquiryDetailsAssertLabel2);
	}
	
	public static String SubmitInquiryResponse(String ResponseType,String ResponseTextValue)
	{
		ResponseTypeRadioButton="//*[@id='collapseTwo']/div/div[1]/div/div/label/span[contains(text(),'"+ResponseType+"')]/preceding-sibling::div/span";
		UtilityFunctions.WaitUntilPresenceOfElement(ResponseTypeRadioButton);
		
		BasePage.driver.findElement(By.xpath(ResponseTypeRadioButton)).click();
		BasePage.driver.findElement(By.xpath(ResponseText)).sendKeys(ResponseTextValue);
		
		BasePage.driver.findElement(By.xpath(SubmitButton)).click();
		BasePage.driver.findElement(By.xpath(ConfirmationCancelButton)).click();
		try {
			 Thread.sleep(5000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiryPage.SearchInquiryPageLoadAssert1);
		InquiryDetailsAssertlabel1=BasePage.driver.findElement(By.xpath(SearchInquiryPage.SearchInquiryPageLoadAssert1)).getText();
        return(InquiryDetailsAssertlabel1);
		
	}
	
	public static void ApplyDropdownActiononInquiryDetails(String ActionNameValue)
	{
		
			ApplyActiondropdownID = new Select(BasePage.driver.findElement(By.xpath(ActionDropdownsID)));
			ApplyActiondropdownID.selectByVisibleText(ActionNameValue);
		
		 try {
			 Thread.sleep(5000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	}
		
	public static String ValidateAddedCategoryInEvents(String ActionNameValue)
	{
		InquiryEvent1="//*[@id='collapseOne']/table/tbody/tr/td/div/div/p[contains(text(),'Category Added ("+ActionNameValue+")')]";
		
		getText1=BasePage.driver.findElement(By.xpath(InquiryEvent1)).getText();
		return(getText1);
	}
	
	public static String DeletionConfirmation()
	{
		BasePage.driver.findElement(By.xpath(OkButton)).click();
		try {
			 Thread.sleep(7000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		
		UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiryPage.SearchInquiryPageLoadAssert1);
		InquiryDetailsAssertlabel2=BasePage.driver.findElement(By.xpath(SearchInquiryPage.SearchInquiryPageLoadAssert1)).getText();
       return(InquiryDetailsAssertlabel2);
	}
	
	// Validate saved inquiry answer in dropdown and validate it text
	public static InquiryDetailsPage ValidateAnswerInInquiryAnswerDropdown(String InquiryAnswerValue)
	{
		InquiryAnswerExpected=StartInquiryAnswerPath+InquiryAnswerValue+EndInquiryAnswerPath;
		Select Answerdropdown = new Select(BasePage.driver.findElement(By.xpath(AnswerDropdown)));
		InquiryDetailsAssertlabel3=BasePage.driver.findElement(By.xpath(InquiryAnswerExpected)).getText();
		Answerdropdown.selectByVisibleText(InquiryAnswerValue);
		try {
			 Thread.sleep(5000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		UtilityFunctions.WaitUntilPresenceOfElement(ResponseText);
		InquiryDetailsAssertlabel4=BasePage.driver.findElement(By.xpath(ResponseText)).getText();
		return new InquiryDetailsPage();
	}
}
