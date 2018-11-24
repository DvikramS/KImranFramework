package TestCases.InquiryTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.SearchContactPage;
import Page.InquiryPages.AddInquiryPage;
import Page.InquiryPages.InquiryDetailsPage;
import Page.InquiryPages.SearchInquiryPage;
import Util.UtilityFunctions;

public class AddInquiryTests {
	
	private String GetAddInquiryText;
	private String GetAddedInquiryText;
	
	private String GetAddInquiryText1;
	private String GetAddedInquiryText1;
	
	private String GetAddedInquiryText2;
	
	private String GetAddedInquiryDetailText;
	private String GetSearchInquiryText;
	private String GetResponseText;
	
	private String GetInquiryContactsText1;
	private String GetInquiryContactsText2;
	private String GetInquiryContactsText3;
	
	private String GetInquiryResponseText;
	
	@Test(priority=1)
	public void NavigateToAddInquiryForNewContact()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToAddInquiryForNewContact", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		GetAddInquiryText=AddInquiryPage.NavigateToAddInquiryForNewContact();
			Assert.assertEquals(GetAddInquiryText, "Add Inquiry for new contact");
			System.out.println("NavigateToAddInquiry ends");
	
	}
	
	@Test(priority=2,dataProvider = "getTestDataForCreateNewContact")
	public void CreateNewInquiry(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("CreateNewInquiry", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("CreateNewInquiry Test Starts");
		   GetAddedInquiryText=AddInquiryPage.CreateInquiryForNewContact(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"),TestDataSet.get("MobileValue")
		    		,TestDataSet.get("CountryValue"),TestDataSet.get("QuestionValue"),TestDataSet.get("ResponseTextValue"),TestDataSet.get("SelectedsResponseTypeValue"),TestDataSet.get("DirectoryNameValue"));
			Assert.assertEquals(GetAddedInquiryText, TestDataSet.get("QuestionValue"));
			System.out.println("CreateNewInquiry ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForCreateNewContact()
	{
		Object[][] Data = UtilityFunctions.getData("CreateNewInquiry", BasePage.xls);
		return Data;
	}
	
	@Test(priority=3)
	public void NavigateToAddInquiryForExistingContact()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToAddInquiryForExistingContact", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		GetAddInquiryText1=AddInquiryPage.NavigateToAddInquiryForExistingContact();
			Assert.assertEquals(GetAddInquiryText1, "Contacts");
			System.out.println("NavigateToAddInquiryForExistingContact ends");
	
	}
	@Test(priority=4,dataProvider = "getTestDataForCreateNewInquiryForExistingContact")
	public void CreateNewInquiryForExistingContact(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("CreateNewInquiryForExistingContact", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("CreateNewInquiryForExistingContact Test Starts");
		   GetAddedInquiryText1=AddInquiryPage.CreateInquiryForExistingContact(TestDataSet.get("ContactSearch_FirstNameValue"),TestDataSet.get("ContactSearch_LastNameValue")
		    		,TestDataSet.get("CountryValue"),TestDataSet.get("QuestionValue"),TestDataSet.get("ResponseTextValue"));
			Assert.assertEquals(GetAddedInquiryText1, TestDataSet.get("QuestionValue"));
			System.out.println("CreateNewInquiryForExistingContact ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForCreateNewInquiryForExistingContact()
	{
		Object[][] Data = UtilityFunctions.getData("CreateNewInquiryForExistingContact", BasePage.xls);
		return Data;
	}
	
	@Test(priority=5,dataProvider = "getTestDataForCreateNewInquiryForNewContact_LogReponse")
	public void CreateNewInquiryForNewContact_LogReponse(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("CreateNewInquiryForNewContact_LogReponse", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   GetAddInquiryText=AddInquiryPage.NavigateToAddInquiryForNewContact();
		
		   System.out.println("CreateNewInquiryForNewContact_LogReponse Test Starts");
		   GetAddedInquiryText2=AddInquiryPage.CreateInquiryForNewContact(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"),TestDataSet.get("MobileValue")
		    		,TestDataSet.get("CountryValue"),TestDataSet.get("QuestionValue"),TestDataSet.get("ResponseTextValue"),TestDataSet.get("SelectedsResponseTypeValue"),TestDataSet.get("DirectoryNameValue"));
			Assert.assertEquals(GetAddedInquiryText2, TestDataSet.get("QuestionValue"));
			
			GetAddedInquiryDetailText=SearchInquiryPage.EditInquiry(TestDataSet.get("QuestionValue"));
			
			System.out.println("CreateNewInquiryForNewContact_LogReponse ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForCreateNewInquiryForNewContact_LogReponse()
	{
		Object[][] Data = UtilityFunctions.getData("CreateNewInquiryForNewContact_LogReponse", BasePage.xls);
		return Data;
	}
	
	//Verify event action is properly logged for an inquiry on inquiry details page
	@Test(priority=6,dataProvider = "getTestDataForVerifyInquiryEventActions")
	public void VerifyInquiryEventActions(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyInquiryEventActions", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    GetSearchInquiryText=SearchInquiryPage.NavigateToSearchInquiry();
			GetAddedInquiryDetailText=SearchInquiryPage.EditInquiry(TestDataSet.get("QuestionValue"));
			GetResponseText=InquiryDetailsPage.VerifyEventActions(TestDataSet.get("EventAction"));
			Assert.assertTrue(GetResponseText.contains("Response Added"));	
			
			GetInquiryResponseText=InquiryDetailsPage.SubmitInquiryResponse(TestDataSet.get("ResponseType"), TestDataSet.get("ResponseText"));
			Assert.assertEquals(GetInquiryResponseText, "Search Inquiry");
			System.out.println("VerifyInquiryEventActions ends");
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyInquiryEventActions()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyInquiryEventActions", BasePage.xls);
		return Data;
	}
	
	
	//Verify the contact created from Inquiry 
	//Test Data is dependent on CreateNewInquiry test, therefore any change must be done in both test data's
	@Test(priority=7,dataProvider = "getTestDataForVerifyContactsCreatedFromInquiry")
	public void VerifyContactsCreatedFromInquiry(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyContactsCreatedFromInquiry", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    GetInquiryContactsText1=SearchContactPage.NavigateToSearchContacts();
		    GetInquiryContactsText2=SearchContactPage.SearchContactByName(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"), TestDataSet.get("EmailValue"));
		    GetInquiryContactsText3=TestDataSet.get("FirstNameValue")+" "+TestDataSet.get("LastNameValue");
			Assert.assertEquals(GetInquiryContactsText2, GetInquiryContactsText3);		
			System.out.println("VerifyContactsCreatedFromInquiry ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyContactsCreatedFromInquiry()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyContactsCreatedFromInquiry", BasePage.xls);
		return Data;
	}
}
