package TestCases.ContactTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.AddContactPage;
import Page.ContactPages.CombineContactsPage;
import Page.InquiryPages.AddInquiryPage;
import Util.UtilityFunctions;

public class CombineContactsTests {

	//Variables will receive assert text from function of pages
	String GetCombineContactsText1;
	String GetCombineContactsText2;
	String CombinedContactName;
	
	//Expected Labels used for Assertion in tests
	String NavigatedToContactSearchPopUp="Contacts";
	
	
	//Test Verify user has successfully navigated to 2nd combine contact screen where he/she needs to select contact from Contact Search Pop-Up
	@Test(priority=1)
	public void VerifyNavigationToCombineContactPage()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyNavigationToCombineContactPage", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		    GetCombineContactsText1=CombineContactsPage.NavigateToCombineContacts();
			Assert.assertEquals(GetCombineContactsText1, NavigatedToContactSearchPopUp);
			System.out.println("VerifyNavigationToCombineContactPage ends");
	
	}
	
	@Test(priority=2,dataProvider = "getTestDataForVerifyCombiningContacts")
	public void VerifyCombiningContacts(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyCombiningContacts", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("VerifyCombiningContacts Test Starts");
		   CombineContactsPage.SelectContactsForCombining(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"),TestDataSet.get("FirstNameValue2")
		    		,TestDataSet.get("LastNameValue2"),TestDataSet.get("EmailValue2"));
		   
		   GetCombineContactsText1=CombineContactsPage.SelectColumnForCombiningContact(TestDataSet.get("DirectoryValue"),TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"));
		   CombinedContactName=TestDataSet.get("FirstNameValue")+ " "+TestDataSet.get("LastNameValue");
		   Assert.assertEquals(GetCombineContactsText1,CombinedContactName);
		   System.out.println("VerifyCombiningContacts ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyCombiningContacts()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyCombiningContacts", BasePage.xls);
		return Data;
	}
	
	
}
