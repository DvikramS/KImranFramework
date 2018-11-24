package TestCases.InquiryTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.InquiryPages.InquiryCategoryPage;
import Page.InquiryPages.InquiryCategoryReportPage;
import Page.InquiryPages.SearchInquiryPage;
import Util.UtilityFunctions;

public class InquiryCategoryReportTests {

	private static String GetCategoryReportAssertResult1;
	private static String GetCategoryReportAssertResult2;
	
	private static String GetCategoryReportAssertResult3;
	private static String GetCategoryReportAssertResult4;
	
	private static String GetCategoryReportAssertResult5;
	private static String GetCategoryReportAssertResult6;
	
	@Test(priority=1)
	public void NavigateToInquiryCategoryReportPage()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToInquiryCategoryReportPage", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   GetCategoryReportAssertResult1=InquiryCategoryReportPage.NavigateToInquiryCategoryReport();
			Assert.assertEquals(GetCategoryReportAssertResult1,"Inquiry Category Report");
			System.out.println("NavigateToInquiryCategoryReportPage ends");
	
	}
	
	@Test(priority=2,dataProvider = "getTestDataForSearchOnCategoryReport")
	public void SearchOnCategoryReport(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("SearchOnCategoryReport", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("SearchOnCategoryReport Test Starts");
		    GetCategoryReportAssertResult3=SearchInquiryPage.NavigateToSearchInquiry();
		    GetCategoryReportAssertResult4=SearchInquiryPage.ApplyDropdownAction(TestDataSet.get("ActionNameValue"),TestDataSet.get("InquiryText"));
		
		    GetCategoryReportAssertResult1=InquiryCategoryReportPage.NavigateToInquiryCategoryReport();
		    
		    GetCategoryReportAssertResult5=InquiryCategoryReportPage.SearchWithDates(TestDataSet.get("CategoryNameValue"));
		    Assert.assertEquals(GetCategoryReportAssertResult5,TestDataSet.get("CategoryNameValue"));
		    
			System.out.println("SearchOnCategoryReport ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForSearchOnCategoryReport()
	{
		Object[][] Data = UtilityFunctions.getData("SearchOnCategoryReport", BasePage.xls);
		return Data;
	}
	
	@Test(priority=3,dataProvider = "getTestDataForSearchOnCategoryReport")
	public void ClickOnCategoryCount(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("ClickOnCategoryCount", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    System.out.println("ClickOnCategoryCount Test Starts");
		    GetCategoryReportAssertResult6=InquiryCategoryReportPage.CategoryClickableCounts();
		    Assert.assertEquals(GetCategoryReportAssertResult6,"True");
			System.out.println("ClickOnCategoryCount ends");
	}
	
	
}
