package TestCases.ContactTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.AddContactPage;
import Page.ContactPages.EditContactPage;
import Page.ContactPages.SearchContactPage;
import Page.GroupPages.AddBasicGroupPage;
import Page.GroupPages.GroupListPage;
import Util.UtilityFunctions;

public class EditContactTests {
	
	String GetDirectoryAssociationText;
	String GetGuestAssociationText;
	String GetGuestAssociationText1;
	String GetGroupAssociationText1;
	
	@Test(priority=1,dataProvider = "getTestDataForVerifyMultipleDirectoryAssociation")
	public void VerifyMultipleDirectoryAssociation(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyMultipleDirectoryAssociation", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("VerifyMultipleDirectoryAssociation Test Starts");
		   SearchContactPage.NavigateToSearchContacts();
		   SearchContactPage.SearchContactByName(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"));
		   SearchContactPage.EditContact();
		   
		   GetDirectoryAssociationText=EditContactPage.AssociateMultipleDirectory(TestDataSet.get("DirectoryValue"));
		   Assert.assertEquals(GetDirectoryAssociationText,TestDataSet.get("DirectoryValue"));
		   System.out.println("VerifyMultipleDirectoryAssociation ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyMultipleDirectoryAssociation()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyMultipleDirectoryAssociation", BasePage.xls);
		return Data;
	}
	
	@Test(priority=2,dataProvider = "getTestDataForVerifyCreateGuestUser")
	public void VerifyCreateGuestUser(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyCreateGuestUser", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("VerifyCreateGuestUser Test Starts");
		   SearchContactPage.NavigateToSearchContacts();
		   SearchContactPage.SearchContactByName(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"));
		   SearchContactPage.EditContact();
		   
		   GetGuestAssociationText=EditContactPage.CreateGuestuser(TestDataSet.get("PasswordValue"));
		   Assert.assertEquals(GetGuestAssociationText,TestDataSet.get("EmailValue"));
		   System.out.println("VerifyCreateGuestUser ends");	
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyCreateGuestUser()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyCreateGuestUser", BasePage.xls);
		return Data;
	}
	
	@Test(priority=3,dataProvider = "getTestDataForVerifyGuestUserMandatoryPasswordMsg")
	public void VerifyGuestUserMandatoryPasswordMsg(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyGuestUserMandatoryPasswordMsg", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("VerifyGuestUserMandatoryPasswordMsg Test Starts");
		   SearchContactPage.NavigateToSearchContacts();
		   SearchContactPage.SearchContactByName(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"));
		   SearchContactPage.EditContact();
		   
		   GetGuestAssociationText1=EditContactPage.ValidateGuestUserPasswordMessage();
		   Assert.assertEquals(GetGuestAssociationText1,EditContactPage.ErrorMessagePasswordMandatory);
		   System.out.println("VerifyGuestUserMandatoryPasswordMsg ends");	
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyGuestUserMandatoryPasswordMsg()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyGuestUserMandatoryPasswordMsg", BasePage.xls);
		return Data;
	}
	
	//Test adds a group and associate contacts to that group and directory
	@Test(priority=4,dataProvider = "getTestDataForVerifyContactGroupAssociationTab")
	public void VerifyContactGroupAssociationTab(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyContactGroupAssociationTab", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("VerifyContactGroupAssociationTab Test Starts");
		   
		   //Create a basic group for association
		   GroupListPage.NavigateToGroupListPage();
		   GroupListPage.ClickOnAddBasicGroup();
		   AddBasicGroupPage.AddBasicGroup(TestDataSet.get("BasicGroupNameValue"), TestDataSet.get("Description"));
		   
		   //Search and edit contact to associate with group
		   SearchContactPage.NavigateToSearchContacts();
		   SearchContactPage.SearchContactByName(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"));
		   SearchContactPage.EditContact();
		   AddContactPage.AddAddressLocation(TestDataSet.get("Latitude_DegreeValue"), TestDataSet.get("Latitude_MinutesValue"), TestDataSet.get("Latitude_SecondsValue"), 
				   TestDataSet.get("Longitude_DegreeValue"), TestDataSet.get("Longitude_MinutesValue"), TestDataSet.get("Longitude_SecondsValue"),TestDataSet.get("Latitude_DirectionValue"),TestDataSet.get("Longitude_DirectionValue"));
		   GetGroupAssociationText1=EditContactPage.AsscoiateGroupWithContactTab(TestDataSet.get("BasicGroupNameValue"));
		   EditContactPage.AssociateMultipleDirectory(TestDataSet.get("DirectoryValue"));
		   Assert.assertEquals(GetGroupAssociationText1,TestDataSet.get("BasicGroupNameValue"));
		   System.out.println("VerifyContactGroupAssociationTab ends");	
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyContactGroupAssociationTab()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyContactGroupAssociationTab", BasePage.xls);
		return Data;
	}
	
	
}
