package TestCases.ContactTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.AddContactPage;
import Page.ContactPages.DirectoryPage;
import Util.UtilityFunctions;

public class AddContactTests {
	
	private String GetAddContactText;
	private String GetAddedContactText;
	String ContactFullName1;
	private String ContactAssertText1;
	
	@Test(priority=1)
	public void NavigateToAddContact()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToAddContact", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    GetAddContactText=AddContactPage.NavigateToAddContact();
			Assert.assertEquals(GetAddContactText, "Add Contact");
			System.out.println("NavigateToAddContactPage ends");
	
	}

	@Test(priority=2,dataProvider = "getTestDataForCreateNewContact")
	public void CreateNewContact(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("CreateNewContact", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("AddContact Test Starts");
		    GetAddedContactText=AddContactPage.AddContact(TestDataSet.get("SalutationValue"),TestDataSet.get("TitleValue"),TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue")
		    		,TestDataSet.get("EmailValue"),TestDataSet.get("AlternateEmailValue"),TestDataSet.get("CountryValue"),TestDataSet.get("MobileValue")
		    		,TestDataSet.get("DayPhoneValue"),TestDataSet.get("HomePhoneValue"),TestDataSet.get("NoteValue"),TestDataSet.get("CompanyNameValue"),TestDataSet.get("FacebookIdValue"),TestDataSet.get("TwitterIdValue"),TestDataSet.get("SMS1Value")
		    		,TestDataSet.get("SMS2Value"),TestDataSet.get("SMS3Value"),TestDataSet.get("AddressValue"),TestDataSet.get("cityValue"),TestDataSet.get("ZipCodeValue"),TestDataSet.get("StateValue")
		    		,TestDataSet.get("Latitude_DegreeValue"),TestDataSet.get("Latitude_MinutesValue"),TestDataSet.get("Latitude_SecondsValue"),TestDataSet.get("Longitude_DegreeValue")
		    		,TestDataSet.get("Longitude_MinutesValue"),TestDataSet.get("Longitude_SecondsValue"));
		  //  if(TestDataSet.get("SalutationValue")!=null && !TestDataSet.get("SalutationValue").isEmpty())
		    ContactFullName1=TestDataSet.get("SalutationValue")+" "+TestDataSet.get("FirstNameValue")+" "+TestDataSet.get("LastNameValue");
			System.out.println(ContactFullName1+ "----"+ GetAddedContactText);
		    Assert.assertEquals(GetAddedContactText, ContactFullName1);
			System.out.println("AddContact ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForCreateNewContact()
	{
		Object[][] Data = UtilityFunctions.getData("CreateNewContact", BasePage.xls);
		return Data;
	}
	
	//Verify Duplicate contact alert message
	@Test(priority=3,dataProvider = "getTestDataForVerifyDuplicateContactCheck")
	public void VerifyDuplicateContactCheck(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyDuplicateContactCheck", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("VerifyDuplicateContactCheck Test Starts");
		   AddContactPage.NavigateToAddContact();
		   ContactAssertText1=AddContactPage.DuplicateContactCheck(TestDataSet.get("SalutationValue"),TestDataSet.get("TitleValue"),TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue")
		    		,TestDataSet.get("EmailValue"));
			Assert.assertEquals(ContactAssertText1, AddContactPage.DuplicateContactAlertMessage);
			System.out.println("VerifyDuplicateContactCheck ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyDuplicateContactCheck()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyDuplicateContactCheck", BasePage.xls);
		return Data;
	}
}
