package TestCases.ContactTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.ImportContactPage;
import Page.InquiryPages.AddInquiryPage;
import Page.InquiryPages.InquiryDashboardPage;
import Util.UtilityFunctions;

public class ImportContactTests {

	private static String GetImportContactText1;
	private static String GetImportContactText2;
	
	@Test(priority=1)
	public void NavigateToImportContactPage()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToImportContactPage", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    GetImportContactText1=ImportContactPage.NavigateToImportContactPage();
			Assert.assertEquals(GetImportContactText1,ImportContactPage.ImportContactHeaderLabel);
			System.out.println("NavigateToImportContactPage ends");
	
	}
	
	@Test(priority=2,dataProvider = "getTestDataForVerifyLookupSearch")
	public void VerifyLookupSearch(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyLookupSearch", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("VerifyLookupSearch Test Starts");
		    GetImportContactText2=ImportContactPage.VerifyLookupMasterCode(TestDataSet.get("LookupValue"), TestDataSet.get("SearchValue"));
			Assert.assertEquals(GetImportContactText2, TestDataSet.get("SearchValue"));	
			System.out.println("VerifyLookupSearch ends");
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyLookupSearch()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyLookupSearch", BasePage.xls);
		return Data;
	}
	
}
