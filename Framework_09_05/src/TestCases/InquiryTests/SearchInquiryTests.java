package TestCases.InquiryTests;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.InquiryPages.AddInquiryPage;
import Page.InquiryPages.SearchInquiryPage;
import Util.UtilityFunctions;

public class SearchInquiryTests {
	
	String GetSearchInquiryAssertResult1;
	String GetSearchInquiryAssertResult2;
	String GetSearchInquiryAssertResult3;
	String GetSearchInquiryAssertResult4;
	String GetSearchInquiryAssertResult5;
	
	String GetSearchInquiryAssertResult6;
	String GetSearchInquiryAssertResult7;
	String GetSearchInquiryAssertResult8;
	String GetSearchInquiryAssertResult9;
	String GetSearchInquiryAssertResult10;
	
	String GetSearchInquiryAssertResult11;
	String GetSearchInquiryAssertResult12;
	String GetSearchInquiryAssertResult13;
	String GetSearchInquiryAssertResult14;
	
	SearchInquiryPage SearchInquiryPageObject;
	
	@Test(priority=1)
	public void NavigateToSearchInquiry()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToSearchInquiry", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		GetSearchInquiryAssertResult1=SearchInquiryPage.NavigateToSearchInquiry();
			Assert.assertEquals(GetSearchInquiryAssertResult1, "Search Inquiry");
			System.out.println("NavigateToSearchInquiry ends");
	
	}
	
	//Test for applying action from action dropdown on Inquiry Search page
	//In Test data provide partial or complete of text of inquiry on which action needs to be applied
	@Test(priority=2,dataProvider = "getTestDataForApplyActionCategory")
	public void ApplyActionCategory(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("ApplyActionCategory", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("ApplyActionCategory Test Starts");
		   //Functions return applied category name and we verify category applied category
		   GetSearchInquiryAssertResult2=SearchInquiryPage.ApplyDropdownAction(TestDataSet.get("ActionNameValue"),TestDataSet.get("InquiryText"));
			Assert.assertTrue(GetSearchInquiryAssertResult2.contains(TestDataSet.get("ActionNameValue")));	
			System.out.println("ApplyActionCategory ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForApplyActionCategory()
	{
		Object[][] Data = UtilityFunctions.getData("ApplyActionCategory", BasePage.xls);
		return Data;
	}
	
	@Test(priority=3,dataProvider = "getTestDataForApplyActionCategoryRemove")
	public void ApplyActionCategoryRemove(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("ApplyActionCategoryRemove", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("ApplyActionCategoryRemove Test Starts");
		   //Functions return applied category name and we verify remove category
		   GetSearchInquiryAssertResult3=SearchInquiryPage.ApplyDropdownActionRemove(TestDataSet.get("ActionNameValue"),TestDataSet.get("InquiryText"));
			Assert.assertFalse(GetSearchInquiryAssertResult3.contains(TestDataSet.get("ActionNameValue")));	
		   //Assert.assertEquals(GetSearchInquiryAssertResult2," ");
			System.out.println("ApplyActionCategoryRemove ends");
	}
	
	@DataProvider
	public Object[][] getTestDataForApplyActionCategoryRemove()
	{
		Object[][] Data = UtilityFunctions.getData("ApplyActionCategoryRemove", BasePage.xls);
		return Data;
	}
	
	//To test multiple response for inquiries, In Test data provide Partial or complete Text of inquiry for which response needs to be submitted
	@Test(priority=4,dataProvider = "getTestDataForSubmitResponseMultipleInquiries")
	public void SubmitResponseMultipleInquiries(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("SubmitResponseMultipleInquiries", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("SubmitResponseMultipleInquiries Test Starts");
		    GetSearchInquiryAssertResult1=SearchInquiryPage.NavigateToSearchInquiry();
		   //Submit response for multiple inquiries
		    SearchInquiryPage.MultipleResponseForInquiry(TestDataSet.get("FirstInquiryText"),TestDataSet.get("SecondInquiryText"),TestDataSet.get("ResponseTextValue"));
			System.out.println("SubmitResponseMultipleInquiries ends");
	}
	
	@DataProvider
	public Object[][] getTestDataForSubmitResponseMultipleInquiries()
	{
		Object[][] Data = UtilityFunctions.getData("SubmitResponseMultipleInquiries", BasePage.xls);
		return Data;
	}
	
	//Test for searching inquiry based on Inquiry ID
	@Test(priority=5,dataProvider = "getTestDataForSearchWithInquiryId")
	public void SearchWithInquiryId(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("SearchWithInquiryId", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("SearchWithInquiryId Test Starts");
		    GetSearchInquiryAssertResult1=SearchInquiryPage.NavigateToSearchInquiry();
		    GetSearchInquiryAssertResult5= SearchInquiryPage.SearchInquiryByID_SearchBox(TestDataSet.get("QuestionValue"));
			System.out.println("SearchWithInquiryId ends");
			Assert.assertEquals(GetSearchInquiryAssertResult5,"True");
	}
	
	@DataProvider
	public Object[][] getTestDataForSearchWithInquiryId()
	{
		Object[][] Data = UtilityFunctions.getData("SearchWithInquiryId", BasePage.xls);
		return Data;
	}
	
	@Test(priority=6)
	public void NavigateToAdvanceSearchBox()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToAdvanceSearchBox", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("NavigateToAdvanceSearchBox Test Starts");
		    GetSearchInquiryAssertResult1=SearchInquiryPage.NavigateToSearchInquiry();
		    GetSearchInquiryAssertResult6= SearchInquiryPage.OpenAdvanceSearchPopUp();
			System.out.println("NavigateToAdvanceSearchBox ends");
			Assert.assertEquals(GetSearchInquiryAssertResult6,"Keywords");
	}
	
	
	@Test(priority=7,dataProvider="getTestDataForVerifyAdvanceSearchUsingkeyword")
	public void VerifyAdvanceSearchUsingkeyword(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyAdvanceSearchUsingkeyword", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyAdvanceSearchUsingkeyword Test Starts");	    
		    GetSearchInquiryAssertResult7= SearchInquiryPage.SearchUsingKeyword(TestDataSet.get("KeywordValue"));
		    SearchInquiryPage.ClearAdvanceSearch();
			System.out.println("VerifyAdvanceSearchUsingkeyword ends");
			Assert.assertEquals(GetSearchInquiryAssertResult7,"True");
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyAdvanceSearchUsingkeyword()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyAdvanceSearchUsingkeyword", BasePage.xls);
		return Data;
	}
	
	@Test(priority=8,dataProvider="getTestDataForVerifyAdvanceSearchUsingDirectory")
	public void VerifyAdvanceSearchUsingDirectory(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyAdvanceSearchUsingDirectory", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyAdvanceSearchUsingDirectory Test Starts");
		    GetSearchInquiryAssertResult6= SearchInquiryPage.OpenAdvanceSearchPopUp();
		    SearchInquiryPage.SearchUsingDirectory(TestDataSet.get("DirectoryValue"),TestDataSet.get("QuestionValue"));
		    SearchInquiryPage.ClearAdvanceSearch();
			System.out.println("VerifyAdvanceSearchUsingDirectory ends");
			//Assert.assertEquals(GetSearchInquiryAssertResult8,TestDataSet.get("QuestionValue"));
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyAdvanceSearchUsingDirectory()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyAdvanceSearchUsingDirectory", BasePage.xls);
		return Data;
	}
	
	@Test(priority=9,dataProvider="getTestDataForVerifyAdvanceSearchUsingReceivedVia")
	public void VerifyAdvanceSearchUsingReceivedVia(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyAdvanceSearchUsingReceivedVia", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyAdvanceSearchUsingReceivedVia Test Starts");
		    GetSearchInquiryAssertResult6= SearchInquiryPage.OpenAdvanceSearchPopUp();
		    GetSearchInquiryAssertResult9=SearchInquiryPage.SearchUsingReceivedVia(TestDataSet.get("ReceivedViaValue"),TestDataSet.get("QuestionValue"));
		    SearchInquiryPage.ClearAdvanceSearch();
			System.out.println("VerifyAdvanceSearchUsingReceivedVia ends");
			Assert.assertEquals(GetSearchInquiryAssertResult9,TestDataSet.get("QuestionValue"));
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyAdvanceSearchUsingReceivedVia()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyAdvanceSearchUsingReceivedVia", BasePage.xls);
		return Data;
	}
	
	@Test(priority=10,dataProvider="getTestDataForVerifyAdvanceSearchUsingStatus")
	public void VerifyAdvanceSearchUsingStatus(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyAdvanceSearchUsingStatus", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyAdvanceSearchUsingStatus Test Starts");
		    SearchInquiryPage.ApplyDropdownAction(TestDataSet.get("ActionNameValue"),TestDataSet.get("InquiryText"));
		    try {
				 Thread.sleep(5000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
		    GetSearchInquiryAssertResult6= SearchInquiryPage.OpenAdvanceSearchPopUp();
		    GetSearchInquiryAssertResult10=SearchInquiryPage.SearchUsingStatus(TestDataSet.get("ActionNameValue"),TestDataSet.get("InquiryText"));
		    SearchInquiryPage.ClearAdvanceSearch();
			System.out.println("VerifyAdvanceSearchUsingStatus ends");
			Assert.assertEquals(GetSearchInquiryAssertResult10,TestDataSet.get("InquiryText"));
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyAdvanceSearchUsingStatus()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyAdvanceSearchUsingStatus", BasePage.xls);
		return Data;
	}
	
	@Test(priority=11,dataProvider="getTestDataForVerifyInquiryAssignedToMine")
	public void VerifyInquiryAssignedToMine(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyInquiryAssignedToMine", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyInquiryAssignedToMine Test Starts");
		    GetSearchInquiryAssertResult11=SearchInquiryPage.NavigateToSearchInquiry();
		    SearchInquiryPage.ApplyDropdownAction(TestDataSet.get("ActionNameValue"),TestDataSet.get("QuestionValue"));
		    try {
				 Thread.sleep(4000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
		    GetSearchInquiryAssertResult12= SearchInquiryPage.InquiriesAssignedToMine(TestDataSet.get("QuestionValue"));
			System.out.println("VerifyInquiryAssignedToMine ends");
			Assert.assertEquals(GetSearchInquiryAssertResult12,TestDataSet.get("QuestionValue"));
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyInquiryAssignedToMine()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyInquiryAssignedToMine", BasePage.xls);
		return Data;
	}
	
	@Test(priority=12,dataProvider="getTestDataForVerifyViewAsReportButton")
	public void VerifyViewAsReportButton(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyViewAsReportButton", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
			System.out.println("VerifyViewAsReportButton Starts");
			GetSearchInquiryAssertResult14=SearchInquiryPage.NavigateToSearchInquiry();
			SearchInquiryPageObject=SearchInquiryPage.ViewAsReportButton(TestDataSet.get("FirstInquiryValue"), TestDataSet.get("SecondInquiryValue"));
			
			Assert.assertEquals(SearchInquiryPageObject.GetSearchInquiryAssertLabel13,TestDataSet.get("FirstInquiryValue"));
			Assert.assertEquals(SearchInquiryPageObject.GetSearchInquiryAssertLabel14,  TestDataSet.get("SecondInquiryValue"));
			Assert.assertEquals(SearchInquiryPageObject.GetSearchInquiryAssertLabel15, SearchInquiryPageObject.ReportHeaderLabel);
			System.out.println("VerifyViewAsReportButton ends");
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyViewAsReportButton()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyViewAsReportButton", BasePage.xls);
		return Data;
	}
}
