package TestCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.UsersPage;
import Page.ContactPages.AddContactPage;
import Util.UtilityFunctions;

public class UserTests {

	String GetUserListText;
	String GetUserListText1;
	@Test(priority=1)
	public void NavigateToUserLists()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToUserLists", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		    GetUserListText=UsersPage.NavigateToUserList();
			Assert.assertEquals(GetUserListText, "User Profile for Site  ");
			System.out.println("NavigateToUserLists ends -- " + GetUserListText);
	
	}
	
	@Test(priority=2,dataProvider = "getTestDataForCreateNewUser")
	public void CreateNewUser(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("CreateNewUser", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("CreateNewUser Test Starts");
		   GetUserListText1=UsersPage.AddUser(TestDataSet.get("LoginNameValue"),TestDataSet.get("PasswordValue"),TestDataSet.get("ConfirmPasswordValue"),TestDataSet.get("AssociationValue")
		    		,TestDataSet.get("TitleValue"),TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue")
		    		,TestDataSet.get("CountryValue"),TestDataSet.get("MobileValue"),TestDataSet.get("RoleValue"));
			Assert.assertEquals(GetUserListText1, "User Profile for Site  ");
			System.out.println("CreateNewUser ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForCreateNewUser()
	{
		Object[][] Data = UtilityFunctions.getData("CreateNewUser", BasePage.xls);
		return Data;
	}
	
}
