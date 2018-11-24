package TestCases.InquiryTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.InquiryPages.InquiryDetailsPage;
import Page.InquiryPages.SearchInquiryPage;
import Util.UtilityFunctions;

public class InquiryDetailsTests {

	String GetInquiryDetailsAssertResult1;
	String GetInquiryDetailsAssertResult2;
	String GetInquiryDetailsAssertResult3;
	
	@Test(priority=1, dataProvider= "getTestDataForVerifyApplyActionFromInquiryDetails")
	public void VerifyApplyActionFromInquiryDetails(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyApplyActionFromInquiryDetails", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("VerifyApplyActionFromInquiryDetails Test Starts");
		    SearchInquiryPage.NavigateToSearchInquiry();
		    SearchInquiryPage.EditFirstInquiry();
		    InquiryDetailsPage.ApplyDropdownActiononInquiryDetails(TestDataSet.get("ActionValue"));
		    GetInquiryDetailsAssertResult1=InquiryDetailsPage.ValidateAddedCategoryInEvents(TestDataSet.get("ActionValue"));	   
			System.out.println("VerifyApplyActionFromInquiryDetails ends");
			Assert.assertTrue(GetInquiryDetailsAssertResult1.contains(TestDataSet.get("ActionValue")));
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyApplyActionFromInquiryDetails()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyApplyActionFromInquiryDetails", BasePage.xls);
		return Data;
	}
	
	@Test(priority=2, dataProvider= "getTestDataForVerifyInquiryDeletion")
	public void VerifyInquiryDeletion(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyInquiryDeletion", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("VerifyInquiryDeletion Test Starts");
		    SearchInquiryPage.NavigateToSearchInquiry();
		    SearchInquiryPage.SelectOptionFromInquiryGrid(TestDataSet.get("OptionValue"));
		    SearchInquiryPage.EditInquiry(TestDataSet.get("QuestionValue"));
		    InquiryDetailsPage.ApplyDropdownActiononInquiryDetails(TestDataSet.get("ActionValue"));
		    GetInquiryDetailsAssertResult3=InquiryDetailsPage.DeletionConfirmation();	   
			System.out.println("VerifyInquiryDeletion ends");
			Assert.assertEquals(GetInquiryDetailsAssertResult3,"Search Inquiry");
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyInquiryDeletion()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyInquiryDeletion", BasePage.xls);
		return Data;
	}
}
