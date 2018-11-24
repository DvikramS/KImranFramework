package TestCases.ContactTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.AddContactPage;
import Page.GroupPages.AddBasicGroupPage;
import Page.GroupPages.AddSmartGroupPage;
import Page.GroupPages.AssociateContactToGroupPage;
import Page.GroupPages.GroupListPage;
import Util.UtilityFunctions;

public class GroupTests {

	String GetGroupAssertText1;
	String GetGroupAssertText2;
	String ExpectedContactFullName;
	String GetSmartGroupAssertText1;
	String GetSmartGroupAssertText2;
	String GetSmartGroupAssertText3;
	String GetSmartGroupAssertText4;
	String GetSmartGroupAssertText5;
	
	GroupListPage GroupListPageObject;
	
	//Verify Navigation to Group List Page
	@Test(priority=1)
	public void VerifyNavigationToGroupListPage()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyNavigationToGroupListPage", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
			GetGroupAssertText1=GroupListPage.NavigateToGroupListPage();
			Assert.assertEquals(GetGroupAssertText1, "Groups");
			System.out.println("VerifyNavigationToGroupListPage ends");
	}

	//Verify Basic groups are added and contacts can be assoicated to them
	@Test(priority=2,dataProvider = "getTestDataForAddBasicGroupAndAssociateContact")
		public void AddBasicGroupAndAssociateContact(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("AddBasicGroupAndAssociateContact", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			   System.out.println("AddBasicGroupAndAssociateContact Test Starts");
			   GroupListPage.ClickOnAddBasicGroup();
			   AddBasicGroupPage.AddBasicGroup(TestDataSet.get("BasicGroupNameValue"),TestDataSet.get("Description"));
			   GetGroupAssertText2=AssociateContactToGroupPage.SearchAndAssociateContacts(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"));
			   ExpectedContactFullName=TestDataSet.get("FirstNameValue")+ " " + TestDataSet.get("LastNameValue");
			   Assert.assertEquals(GetGroupAssertText2,ExpectedContactFullName);
			   System.out.println("AddBasicGroupAndAssociateContact ends");
		
		}
		
		@DataProvider
		public Object[][] getTestDataForAddBasicGroupAndAssociateContact()
		{
			Object[][] Data = UtilityFunctions.getData("AddBasicGroupAndAssociateContact", BasePage.xls);
			return Data;
		}
		
		//Verify User is able to view details of added Basic Group 
		//Test assert on count of contact displayed in grid vs on details page and First & Last name of contacts
		@Test(priority=3,dataProvider = "getTestDataForViewDetailsOfBasicGroup")
		public void ViewDetailsOfBasicGroup(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("ViewDetailsOfBasicGroup", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			   System.out.println("ViewDetailsOfBasicGroup Test Starts");
			   GroupListPage.NavigateToGroupListPage();
			   GroupListPageObject=GroupListPage.ClickOnViewBasicGroup(TestDataSet.get("BasicGroupNameValue"));
			   Assert.assertEquals(GroupListPageObject.GroupAssertText2,GroupListPageObject.GetContactCountFromGrid);
			   Assert.assertEquals(GroupListPageObject.GetFirstNameOfAssociatedContact,TestDataSet.get("FirstNameValue"));
			   Assert.assertEquals(GroupListPageObject.GetLastNameOfAssociatedContact,TestDataSet.get("LastNameValue"));
			   System.out.println("ViewDetailsOfBasicGroup ends");
		
		}
		
		@DataProvider
		public Object[][] getTestDataForViewDetailsOfBasicGroup()
		{
			Object[][] Data = UtilityFunctions.getData("ViewDetailsOfBasicGroup", BasePage.xls);
			return Data;
		}	
		
		//Verify User is able to Edit added Basic Group , change Name , description and associate one more contact
			@Test(priority=4,dataProvider = "getTestDataForEditBasicGroup")
			public void EditBasicGroup(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("EditBasicGroup", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					   System.out.println("EditBasicGroup Test Starts");
					   GroupListPage.NavigateToGroupListPage();
					   GroupListPageObject=GroupListPage.EditBasicgroup(TestDataSet.get("BasicGroupNameValue"),TestDataSet.get("NewBasicGroupNameValue"), TestDataSet.get("NewDescription"));					   
					   Assert.assertEquals(GroupListPageObject.GetEditedGroupName,TestDataSet.get("NewBasicGroupNameValue"));
					   Assert.assertEquals(GroupListPageObject.GetEditedDescription,TestDataSet.get("NewDescription"));
					   System.out.println("EditBasicGroup ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForEditBasicGroup()
				{
					Object[][] Data = UtilityFunctions.getData("EditBasicGroup", BasePage.xls);
					return Data;
				}	
				
				//Verify User is able to Add Smart Group and its displayed on group list page
				@Test(priority=5,dataProvider = "getTestDataForAddSmartGroup")
				public void AddSmartGroup(Hashtable<String, String> TestDataSet)
					{
						//Check for runmode
						if (UtilityFunctions.IsExecutable("AddSmartGroup", BasePage.xls)!=true)
							throw new SkipException("Run Mode Set to No");
						
						   System.out.println("AddSmartGroup Test Starts");
						   GroupListPage.NavigateToGroupListPage();
						   GroupListPage.ClickOnAddSmartGroup();
						   GetSmartGroupAssertText1=AddSmartGroupPage.AddSmartGroup(TestDataSet.get("SmartGroupNameValue"),TestDataSet.get("Condition1"), TestDataSet.get("Condition2"),
								   TestDataSet.get("ContactFirstNameValue"),TestDataSet.get("ContactLastNameValue"));					   
						   Assert.assertEquals(GetSmartGroupAssertText1,TestDataSet.get("SmartGroupNameValue"));
						   System.out.println("AddSmartGroup ends");
					}
					
					@DataProvider
					public Object[][] getTestDataForAddSmartGroup()
					{
						Object[][] Data = UtilityFunctions.getData("AddSmartGroup", BasePage.xls);
						return Data;
					}	
					
					//Verify User is able to Add Smart Group and its displayed on group list page
					@Test(priority=6,dataProvider = "getTestDataForVerifySearchGroup")
					public void VerifySearchGroup(Hashtable<String, String> TestDataSet)
						{
							//Check for runmode
							if (UtilityFunctions.IsExecutable("VerifySearchGroup", BasePage.xls)!=true)
								throw new SkipException("Run Mode Set to No");
							
							   System.out.println("VerifySearchGroup Test Starts");
							   GroupListPage.NavigateToGroupListPage();
							   GetSmartGroupAssertText2=GroupListPage.SearchGroup(TestDataSet.get("SearchGroupName1"));					   
							   Assert.assertEquals(GetSmartGroupAssertText2,TestDataSet.get("SearchGroupName1"));
							   GetSmartGroupAssertText3=GroupListPage.SearchGroup(TestDataSet.get("SearchGroupName2"));					   
							   Assert.assertEquals(GetSmartGroupAssertText3,TestDataSet.get("SearchGroupName2"));
							   System.out.println("VerifySearchGroup ends");
						}
						
						@DataProvider
						public Object[][] getTestDataForVerifySearchGroup()
						{
							Object[][] Data = UtilityFunctions.getData("VerifySearchGroup", BasePage.xls);
							return Data;
						}	
					
						//Verify User is able to Edit a smart group
						@Test(priority=7,dataProvider = "getTestDataForVerifyEditSmartGroup")
						public void VerifyEditSmartGroup(Hashtable<String, String> TestDataSet)
							{
								//Check for runmode
								if (UtilityFunctions.IsExecutable("VerifyEditSmartGroup", BasePage.xls)!=true)
									throw new SkipException("Run Mode Set to No");
								
								   System.out.println("VerifyEditSmartGroup Test Starts");
								   GroupListPage.NavigateToGroupListPage();
								   GetSmartGroupAssertText4=AddSmartGroupPage.EditSmartGroup(TestDataSet.get("SmartGroupNameValue"), TestDataSet.get("NewSmartGroupNameValue"), TestDataSet.get("Condition2"),TestDataSet.get("EmailValue"));				   
								   Assert.assertEquals(GetSmartGroupAssertText4,TestDataSet.get("NewSmartGroupNameValue"));
								   System.out.println("VerifyEditSmartGroup ends");
							}
							
							@DataProvider
							public Object[][] getTestDataForVerifyEditSmartGroup()
							{
								Object[][] Data = UtilityFunctions.getData("VerifyEditSmartGroup", BasePage.xls);
								return Data;
							}	
				
							//Verify User is able to delete a group succesfully
							@Test(priority=8,dataProvider = "getTestDataForVerifyDeleteGroup")
							public void VerifyDeleteGroup(Hashtable<String, String> TestDataSet)
								{
									//Check for runmode
									if (UtilityFunctions.IsExecutable("VerifyDeleteGroup", BasePage.xls)!=true)
										throw new SkipException("Run Mode Set to No");
									
									   System.out.println("VerifyDeleteGroup Test Starts");
									   GroupListPage.NavigateToGroupListPage();
									   GroupListPageObject=GroupListPage.DeleteGroup(TestDataSet.get("GroupNameValue"));
									   Assert.assertEquals(GroupListPageObject.DeleteAssertText1,"True");
									   Assert.assertEquals(GroupListPageObject.GetDeletionMessage,GroupListPageObject.DeletionLabel);
									   System.out.println("VerifyDeleteGroup ends");
								}
								
								@DataProvider
								public Object[][] getTestDataForVerifyDeleteGroup()
								{
									Object[][] Data = UtilityFunctions.getData("VerifyDeleteGroup", BasePage.xls);
									return Data;
								}	
										
			
}
