package TestCases.InquiryTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.InquiryPages.AddInquiryPage;
import Page.InquiryPages.InquiryCategoryPage;
import Util.UtilityFunctions;

public class InquiryCategoryTests {
	
	String GetInquiryCategoryText;
	String GetInquiryCategoryText1;
	
	String GetInquiryCategoryText2;
	
	@Test(priority=1)
	public void NavigateInquiryCategory()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateInquiryCategory", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		GetInquiryCategoryText=InquiryCategoryPage.NavigateToInquriyCategory();
			Assert.assertEquals(GetInquiryCategoryText, "Manage Inquiry Category");
			System.out.println("NavigateInquiryCategory ends");
	
	}
	
	@Test(priority=2,dataProvider = "getTestDataForCreateInquiryCategory")
	public void CreateInquiryCategory(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("CreateInquiryCategory", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("CreateInquiryCategory Test Starts");
		   GetInquiryCategoryText1=InquiryCategoryPage.AddInquiryCategory(TestDataSet.get("CategoryName"));
			Assert.assertEquals(GetInquiryCategoryText1, TestDataSet.get("CategoryName"));
			System.out.println("CreateInquiryCategory ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForCreateInquiryCategory()
	{
		Object[][] Data = UtilityFunctions.getData("CreateInquiryCategory", BasePage.xls);
		return Data;
	}

	//Edit Catgeory
	@Test(priority=3,dataProvider = "getTestDataForEditInquiryCategory")
	public void EditInquiryCategory(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("EditInquiryCategory", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("EditInquiryCategory Test Starts");
		   GetInquiryCategoryText1=InquiryCategoryPage.EditInquiryCategory(TestDataSet.get("CategoryName"));
			Assert.assertEquals(GetInquiryCategoryText1, TestDataSet.get("CategoryName"));
			System.out.println("EditInquiryCategory ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForEditInquiryCategory()
	{
		Object[][] Data = UtilityFunctions.getData("EditInquiryCategory", BasePage.xls);
		return Data;
	}
	
	//Make a Catgeory as public
	@Test(priority=4,dataProvider = "getTestDataForSetCategoryPublic")
	public void SetCategoryPublic(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("SetCategoryPublic", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("SetCategoryPublic Test Starts");
		   GetInquiryCategoryText2=InquiryCategoryPage.SetCategoryVisibilty(TestDataSet.get("CategoryName"));
			Assert.assertEquals(GetInquiryCategoryText2,"Unselected");
			System.out.println("SetCategoryPublic ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForSetCategoryPublic()
	{
		Object[][] Data = UtilityFunctions.getData("SetCategoryPublic", BasePage.xls);
		return Data;
	}
	
	
}
