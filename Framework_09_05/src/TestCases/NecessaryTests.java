package TestCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.DirectoryPage;
import Util.UtilityFunctions;

public class NecessaryTests {

	private String GetAddedDirectorytext;
	private String GetDirectoryListtext;
	
	@Test(priority=1)
	public void NavigateToDirectoryListPage()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToDirectoryListPage", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		//try {
			GetDirectoryListtext=DirectoryPage.NavigateToDirectoryList();
			Assert.assertEquals(GetDirectoryListtext, "Directories");
			System.out.println("NavigateToDirectoryListPage ends");
		//}catch(Exception e)
		//{
		//	System.out.println("Not able to navigate to Directories"+ e);
		//}
	}
	
	//Create a new directory
	@Test(priority=2,dataProvider = "getTestDataForCreateDirectory")
	public void CreateDirectory(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("CreateDirectory", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
			System.out.println("Add Directory Starts");
			DirectoryPage.NavigateToDirectoryList();
			GetAddedDirectorytext=DirectoryPage.AddDirectory(TestDataSet.get("DirectoryName"),TestDataSet.get("WildField1"));
			Assert.assertEquals(GetAddedDirectorytext,TestDataSet.get("DirectoryName"));
			System.out.println("Add Directory Ends"+ GetAddedDirectorytext );	
	}
	@DataProvider
	public Object[][] getTestDataForCreateDirectory()
	{
		Object[][] Data = UtilityFunctions.getData("CreateDirectory", BasePage.xls);
		return Data;
	}
}
