package TestCases.ContactTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.AddContactPage;
import Page.ContactPages.ContactDashboardPage;
import Page.ContactPages.SearchContactPage;
import Page.InquiryPages.InquiryDashboardPage;
import Util.UtilityFunctions;

public class ContactDashboardTests {

	String GetContactDashboardAssertText1;
	String GetContactDashboardAssertText2;
	String GetContactDashboardAssertText3;
	String GetContactDashboardAssertText4;
	String GetContactDashboardAssertText5;
	String GetContactDashboardAssertText6;
	String GetContactDashboardAssertText7;
	
	private static String AddedContactFullName;
	
	//Navigate to Contact Dashboard successfully
	@Test(priority=1)
	public void NavigateToContactDashboard()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToContactDashboard", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    GetContactDashboardAssertText1=ContactDashboardPage.NavigateToContactDashboard();
			Assert.assertEquals(GetContactDashboardAssertText1, ContactDashboardPage.ContactDashboardAssertLabel);
			System.out.println("NavigateToContactDashboard ends");
	}
	
	//Verify Directories are displayed and clickable from contact dashboard, there corresponding count is displayed correctly 
	//First Directory in widget is selected for test
	@Test(priority=2)
	public void VerifyDirectoryClickableAndCountOnContactDasboard()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyDirectoryClickableAndCountOnContactDasboard", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyDirectoryClickableAndCountOnContactDasboard Test Starts"); 
		    GetContactDashboardAssertText2=ContactDashboardPage.VerifyDirectoryNameIsClickableOnCD();
			Assert.assertEquals(GetContactDashboardAssertText2, "True");	
			System.out.println("VerifyDirectoryClickableAndCountOnContactDasboard ends");
	}
	
	//Verify groups are displayed and clickable from contact dashboard, there corresponding count is displayed correctly 
	//First Group in widget is selected for test
	@Test(priority=3)
	public void VerifyGroupClickableAndCountOnContactDasboard()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyGroupClickableAndCountOnContactDasboard", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyGroupClickableAndCountOnContactDasboard Test Starts"); 
		    ContactDashboardPage.NavigateToContactDashboard();
		    GetContactDashboardAssertText3=ContactDashboardPage.VerifyGroupNameIsClickable();
			Assert.assertEquals(GetContactDashboardAssertText3, "True");	
			System.out.println("VerifyGroupClickableAndCountOnContactDasboard ends");
	}
	
	//Verify Subscription channel are dispalyed and clickable from contact dashboard
	@Test(priority=4)
	public void VerifySubscriptionIsClickableAndCountOnContactDasboard()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifySubscriptionIsClickableAndCountOnContactDasboard", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifySubscriptionIsClickableAndCountOnContactDasboard Test Starts"); 
		    ContactDashboardPage.NavigateToContactDashboard();
		    GetContactDashboardAssertText4=ContactDashboardPage.VerifySubscriptionNameIsClickable();
			Assert.assertEquals(GetContactDashboardAssertText4, "True");	
			System.out.println("VerifySubscriptionIsClickableAndCountOnContactDasboard ends");
	}
	
	//Verify user is successfully able to Add contact from Contact Dashboard
	@Test(priority=5,dataProvider = "getTestDataForVerifyAddContactFromContactDashBoard")
	public void VerifyAddContactFromContactDashBoard(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyAddContactFromContactDashBoard", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyAddContactFromContactDashBoard Test Starts"); 
		    ContactDashboardPage.NavigateToContactDashboard();
		    GetContactDashboardAssertText5=ContactDashboardPage.NavigateToAddContactFromContactDashboard();
			Assert.assertEquals(GetContactDashboardAssertText5, "Add Contact");	
			GetContactDashboardAssertText5=AddContactPage.AddContact(TestDataSet.get("SalutationValue"),TestDataSet.get("TitleValue"),TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue")
		    		,TestDataSet.get("EmailValue"),TestDataSet.get("AlternateEmailValue"),TestDataSet.get("CountryValue"),TestDataSet.get("MobileValue")
		    		,TestDataSet.get("DayPhoneValue"),TestDataSet.get("HomePhoneValue"),TestDataSet.get("NoteValue"),TestDataSet.get("CompanyNameValue"),TestDataSet.get("FacebookIdValue"),TestDataSet.get("TwitterIdValue"),TestDataSet.get("SMS1Value")
		    		,TestDataSet.get("SMS2Value"),TestDataSet.get("SMS3Value"),TestDataSet.get("AddressValue"),TestDataSet.get("cityValue"),TestDataSet.get("ZipCodeValue"),TestDataSet.get("StateValue")
		    		,TestDataSet.get("Latitude_DegreeValue"),TestDataSet.get("Latitude_MinutesValue"),TestDataSet.get("Latitude_SecondsValue"),TestDataSet.get("Longitude_DegreeValue")
		    		,TestDataSet.get("Longitude_MinutesValue"),TestDataSet.get("Longitude_SecondsValue"));
			AddedContactFullName=TestDataSet.get("SalutationValue")+" "+TestDataSet.get("FirstNameValue")+" "+TestDataSet.get("LastNameValue");
			Assert.assertEquals(GetContactDashboardAssertText5, AddedContactFullName);
			System.out.println("VerifyAddContactFromContactDashBoard ends");
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyAddContactFromContactDashBoard()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyAddContactFromContactDashBoard", BasePage.xls);
		return Data;
	}
	
	//Verify user is able to successfully navigate to Search Contact Screen from Contact Dashboard
	@Test(priority=6)
	public void VerifySearchContactNavigationFromContactDashboard()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifySearchContactNavigationFromContactDashboard", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifySearchContactNavigationFromContactDashboard Test Starts"); 
		    ContactDashboardPage.NavigateToContactDashboard();
		    GetContactDashboardAssertText7=ContactDashboardPage.NavigateToSearchContactFromContactDashboard();
			Assert.assertEquals(GetContactDashboardAssertText7, "Contacts");	
			System.out.println("VerifySearchContactNavigationFromContactDashboard ends");
	}
	
}
