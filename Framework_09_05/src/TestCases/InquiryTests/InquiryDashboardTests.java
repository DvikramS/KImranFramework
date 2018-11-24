package TestCases.InquiryTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.InquiryPages.AddInquiryPage;
import Page.InquiryPages.InquiryDashboardPage;
import Util.UtilityFunctions;

public class InquiryDashboardTests {

	private static String getInquiryDashboardText; 
	private static String getInquiryDashboardText1;
	private static String getInquiryDashboardText2;
	
	private static String getInquiryDashboardText3;
	private static String getInquiryDashboardText4;
	private static String getInquiryDashboardText5;
	
	private static String getInquiryDashboardText6;
	private static String getInquiryDashboardText7;
	
	private static String getInquiryDashboardText8;
	private static String getInquiryDashboardText9;
	
	private static String getInquiryDashboardText10;
	private static String getInquiryDashboardText11;
	private static String getInquiryDashboardText12;
	
	@Test(priority=1)
	public void NavigateToInquiryDashboard()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToInquiryDashboard", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    getInquiryDashboardText=InquiryDashboardPage.NavigateToInquiryDashboardPage();
			Assert.assertEquals(getInquiryDashboardText, "Inquiry Dashboard");
			System.out.println("NavigateToInquiryDashboard ends");
	
	}
	
	@Test(priority=2)
	public void VerifyDirectoryClickableAndCount()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyDirectoryClickableAndCount", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyDirectoryClickableAndCount Test Starts"); 
		    getInquiryDashboardText1=InquiryDashboardPage.VerifyDirectoryNameIsClickable();
			Assert.assertEquals(getInquiryDashboardText1, "True");	
			System.out.println("VerifyDirectoryClickableAndCount ends");
	}
	
	@Test(priority=3)
	public void VerifyCategoryClickableAndCount()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyCategoryClickableAndCount", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyCategoryClickableAndCount Test Starts"); 
		    getInquiryDashboardText2=InquiryDashboardPage.NavigateToInquiryDashboardPage();
		    getInquiryDashboardText5=InquiryDashboardPage.VerifyCategoryNameIsClickable();
			Assert.assertEquals(getInquiryDashboardText5, "True");	
			System.out.println("VerifyCategoryClickableAndCount ends");
	}
	
	@Test(priority=4)
	public void VerifyExcerptIsClickable()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyExcerptIsClickable", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyExcerptIsClickable Test Starts"); 
		    getInquiryDashboardText3=InquiryDashboardPage.NavigateToInquiryDashboardPage();
		    getInquiryDashboardText4=InquiryDashboardPage.InquiryListExcerptIsClickable();
			Assert.assertEquals(getInquiryDashboardText4, "True");	
			System.out.println("VerifyExcerptIsClickable ends");
	}
	
	//Test for Clicking See all records on Inquiry List from Inquiry Dashboard
	//This Test can fail if more than 5 inquiries are not present in a Website
	@Test(priority=5)
	public void VerifyThatSeeAllRecordsIsClickable()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyThatSeeAllRecordsIsClickable", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyThatSeeAllRecordsIsClickable Test Starts"); 
		    getInquiryDashboardText6=InquiryDashboardPage.NavigateToInquiryDashboardPage();
		    getInquiryDashboardText7=InquiryDashboardPage.ClickSeeAllRecordsInquiryList();
			Assert.assertEquals(getInquiryDashboardText7, "True");	
			System.out.println("VerifyThatSeeAllRecordsIsClickable ends");
	}
	
	@Test(priority=6,dataProvider = "getTestDataForVerifyAddInquiryForNewContactNavigationFromInquiryListOptions")
	public void VerifyAddInquiryForNewContactNavigationFromInquiryListOptions(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyAddInquiryForNewContactNavigationFromInquiryListOptions", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyAddInquiryForNewContactNavigationFromInquiryListOptions Test Starts"); 
		    getInquiryDashboardText8=InquiryDashboardPage.NavigateToInquiryDashboardPage();
		    InquiryDashboardPage.SelectInquiryListOptions(TestDataSet.get("OptionValue"));
		    getInquiryDashboardText9=AddInquiryPage.AssertOnNavigatingToAddInquiryPage();
			Assert.assertEquals(getInquiryDashboardText9, "Add Inquiry for new contact");	
			System.out.println("VerifyAddInquiryForNewContactNavigationFromInquiryListOptions ends");
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyAddInquiryForNewContactNavigationFromInquiryListOptions()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyAddInquiryForNewContactNavigationFromInquiryListOptions", BasePage.xls);
		return Data;
	}
	
	@Test(priority=7,dataProvider = "getTestDataForVerifyAddInquiryForExistingContactNavigationFromInquiryListOptions")
	public void VerifyAddInquiryForExistingContactNavigationFromInquiryListOptions(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyAddInquiryForExistingContactNavigationFromInquiryListOptions", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyAddInquiryForExistingContactNavigationFromInquiryListOptions Test Starts"); 
		    getInquiryDashboardText10=InquiryDashboardPage.NavigateToInquiryDashboardPage();
		    InquiryDashboardPage.SelectInquiryListOptions(TestDataSet.get("OptionValue"));
		    getInquiryDashboardText11=AddInquiryPage.AssertOnNavigatingToAddInquiryForExistingContactPage();
			Assert.assertEquals(getInquiryDashboardText11, "Contacts");	
			getInquiryDashboardText12=AddInquiryPage.CancelSearchContactPopUp();
			System.out.println("VerifyAddInquiryForExistingContactNavigationFromInquiryListOptions ends");
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyAddInquiryForExistingContactNavigationFromInquiryListOptions()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyAddInquiryForExistingContactNavigationFromInquiryListOptions", BasePage.xls);
		return Data;
	}
	
}
