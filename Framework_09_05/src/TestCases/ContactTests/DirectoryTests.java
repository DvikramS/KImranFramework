package TestCases.ContactTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.AddContactPage;
import Page.ContactPages.DirectoryPage;
import Page.ContactPages.SearchContactPage;
import Util.UtilityFunctions;

public class DirectoryTests {
	
	String GetDirectoryListtext;
	String GetAddedDirectorytext;
	String GetAddedDirectorytext2;
	String GetEditedDirectorytext3;
	String GetDirectoryStatus1;
	String GetDirectorytext4;
	String GetDirectorytext5;
	
	DirectoryPage DirectoryPageObject;
	AddContactPage AddContactPageObject;
	
	//Create a internal directory with 10 wield fields and different visibilties
	@Test(priority=1,dataProvider = "getTestDataForCreateDirectoryWithAllWildFields")
	public void CreateDirectoryWithAllWildFields(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("CreateDirectoryWithAllWildFields", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
			System.out.println("CreateDirectoryWithAllWildFields Starts");
			DirectoryPage.NavigateToDirectoryList();
			GetAddedDirectorytext2=DirectoryPage.AddDirectory10WildFields(TestDataSet.get("DirectoryNameValue"),TestDataSet.get("WildField1Value"),TestDataSet.get("WildField2Value"),TestDataSet.get("WildField3Value")
					,TestDataSet.get("WildField4Value"),TestDataSet.get("WildField5Value"),TestDataSet.get("WildField6Value"),TestDataSet.get("WildField7Value"),TestDataSet.get("WildField8Value")
					,TestDataSet.get("WildField9Value"),TestDataSet.get("WildField10Value"));
			Assert.assertEquals(GetAddedDirectorytext2,TestDataSet.get("DirectoryNameValue"));
			System.out.println("CreateDirectoryWithAllWildFields Ends :: "+ GetAddedDirectorytext2 );	
	}
	
	@DataProvider
	public Object[][] getTestDataForCreateDirectoryWithAllWildFields()
	{
		Object[][] Data = UtilityFunctions.getData("CreateDirectoryWithAllWildFields", BasePage.xls);
		return Data;
	}	
		
	 //Edit a directory, edit its name, status and a wild field
		@Test(priority=2,dataProvider = "getTestDataForEditDirectory")
		public void EditDirectory(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("EditDirectory", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
				System.out.println("EditDirectory Starts");
				DirectoryPage.NavigateToDirectoryList();
				DirectoryPageObject=DirectoryPage.EditDirectory(TestDataSet.get("DirectoryNameValue"), TestDataSet.get("NewDirectoryNameValue"), TestDataSet.get("WieldField5NewValue"));
				System.out.println("Value:: " + DirectoryPageObject.DirectoryAssertLabel3);
				Assert.assertEquals(DirectoryPageObject.DirectoryAssertLabel3,TestDataSet.get("NewDirectoryNameValue"));
				//Assert.assertEquals(GetEditedDirectorytext3,TestDataSet.get("NewDirectoryNameValue"));
				System.out.println("EditDirectory Ends");	
		}
		
		@DataProvider
		public Object[][] getTestDataForEditDirectory()
		{
			Object[][] Data = UtilityFunctions.getData("EditDirectory", BasePage.xls);
			return Data;
		}	
		
		//Verify that directory added in above test should be public
		@Test(priority=3,dataProvider = "getTestDataForVerifyDirectoryisPublic")
		public void VerifyDirectoryisPublic(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyDirectoryisPublic", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
				DirectoryPage.NavigateToDirectoryList();
				GetDirectoryStatus1=DirectoryPage.CheckVisibiltyOfDirectory(TestDataSet.get("DirectoryNameValue"));
				Assert.assertEquals(GetDirectoryStatus1, "Public");
				System.out.println("VerifyDirectoryisPublic ends");
		}
		
		@DataProvider
		public Object[][] getTestDataForVerifyDirectoryisPublic()
		{
			Object[][] Data = UtilityFunctions.getData("VerifyDirectoryisPublic", BasePage.xls);
			return Data;
		}	
		
		@Test(priority=4)
		public void VerifyActionsIconsOnDirectoryPage()
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyActionsIconsOnDirectoryPage", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
				DirectoryPage.NavigateToDirectoryList(); 
				DirectoryPageObject=DirectoryPage.VerifyPresenceOfActionIcons();
				Assert.assertTrue(DirectoryPageObject.ViewIconPresence);
				Assert.assertTrue(DirectoryPageObject.EditIconPresence);
				Assert.assertTrue(DirectoryPageObject.DeleteIconPresence);
				Assert.assertTrue(DirectoryPageObject.AddIconPresence);
				Assert.assertTrue(DirectoryPageObject.SearchBoxPresence);
				System.out.println("VerifyActionsIconsOnDirectoryPage ends");
		}
		
		//Verify that New added Directory is displayed under contacts Dropdown
				@Test(priority=5,dataProvider = "getTestDataForVerifyAddedDirectoryIsDisplayedInContacts")
				public void VerifyAddedDirectoryIsDisplayedInContacts(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyAddedDirectoryIsDisplayedInContacts", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
						AddContactPage.NavigateToAddContact();
						GetDirectorytext4=AddContactPage.ValidateDirectoryNameOnContactPage(TestDataSet.get("DirectoryNameValue"));
						Assert.assertEquals(GetDirectorytext4,TestDataSet.get("DirectoryNameValue"));
						System.out.println("VerifyAddedDirectoryIsDisplayedInContacts ends");
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyAddedDirectoryIsDisplayedInContacts()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyAddedDirectoryIsDisplayedInContacts", BasePage.xls);
					return Data;
				}	
				
		//Verify that Wield fields are displayed according to selected directory on Add Contact Page
		@Test(priority=6,dataProvider = "getTestDataForVerifyWildFieldsForDifferentDirectoriesOnAddContacPage")
		public void VerifyWildFieldsForDifferentDirectoriesOnAddContacPage(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyWildFieldsForDifferentDirectoriesOnAddContacPage", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
					
				AddContactPage.NavigateToAddContact();
				AddContactPageObject=AddContactPage.ValidateWieldFieldsVisibiltyBasedOnDirectory(TestDataSet.get("FirstDirectoryName"),TestDataSet.get("SecondDirectoryName"));
				Assert.assertEquals(AddContactPageObject.GetWildFieldName,TestDataSet.get("FirstDirectoryWildField1"));
				Assert.assertEquals(AddContactPageObject.GetWildFieldName1,TestDataSet.get("SecondDirectoryWildField1"));
				Assert.assertEquals(AddContactPageObject.GetWildFieldName2,TestDataSet.get("SecondDirectoryWildField2"));
				Assert.assertEquals(AddContactPageObject.GetWildFieldName3,TestDataSet.get("SecondDirectoryWildField3"));
				Assert.assertEquals(AddContactPageObject.GetWildFieldName4,TestDataSet.get("SecondDirectoryWildField4"));
				Assert.assertEquals(AddContactPageObject.GetWildFieldName5,TestDataSet.get("SecondDirectoryWildField5"));
				Assert.assertEquals(AddContactPageObject.GetWildFieldName6,TestDataSet.get("SecondDirectoryWildField6"));
				Assert.assertEquals(AddContactPageObject.GetWildFieldName7,TestDataSet.get("SecondDirectoryWildField7"));
				Assert.assertEquals(AddContactPageObject.GetWildFieldName8,TestDataSet.get("SecondDirectoryWildField8"));
				Assert.assertEquals(AddContactPageObject.GetWildFieldName9,TestDataSet.get("SecondDirectoryWildField9"));
				Assert.assertEquals(AddContactPageObject.GetWildFieldName10,TestDataSet.get("SecondDirectoryWildField10"));
				Assert.assertEquals(AddContactPageObject.GetWildFieldMandatoryLabel1,TestDataSet.get("SecondDirectoryWildField2Label"));
				
				System.out.println("VerifyWildFieldsForDifferentDirectoriesOnAddContacPage ends");
			}
				
				@DataProvider
				public Object[][] getTestDataForVerifyWildFieldsForDifferentDirectoriesOnAddContacPage()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyWildFieldsForDifferentDirectoriesOnAddContacPage", BasePage.xls);
					return Data;
				}	
			
			//Verify That Labels displayed on Add/Edit Directory Page are correct	
				@Test(priority=7,dataProvider = "getTestDataForVerifyLabelsOnEditDirectoryPage")
				public void VerifyLabelsOnEditDirectoryPage(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyLabelsOnEditDirectoryPage", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
						
						DirectoryPage.NavigateToDirectoryList();
						DirectoryPageObject=DirectoryPage.VerifyLabelsOnEditDirectoryPage();
						Assert.assertEquals(DirectoryPageObject.GetDirectoryNameLabelText,TestDataSet.get("DirectoryLabel"));
						Assert.assertEquals(DirectoryPageObject.GetInternalDirectoryLabelText,TestDataSet.get("InternalDirectoryLabel"));
						Assert.assertEquals(DirectoryPageObject.GetStandardFieldsLabelText,TestDataSet.get("StandardFieldsLabel"));
						Assert.assertEquals(DirectoryPageObject.GetStandardFieldsDisplayOnlyLabelText,TestDataSet.get("StandardFieldsDisplayOnlyLabel"));
						Assert.assertEquals(DirectoryPageObject.GetStandardFieldsDisplayandRequireLabelText,TestDataSet.get("StandardFieldsDisplayandRequireLabel"));
						Assert.assertEquals(DirectoryPageObject.GetStandardFieldsDontDisplayLabelText,TestDataSet.get("StandardFieldsDontDisplayLabel"));
						Assert.assertEquals(DirectoryPageObject.GetStandardFieldsOptionsLabelText,TestDataSet.get("StandardFieldsOptionsLabel"));
						Assert.assertEquals(DirectoryPageObject.GetCustomFieldsLabelText,TestDataSet.get("CustomFieldsLabel"));
						Assert.assertEquals(DirectoryPageObject.GetCustomFieldsDisplayOnlyLabelText,TestDataSet.get("CustomFieldsDisplayOnlyLabel"));
						Assert.assertEquals(DirectoryPageObject.GetCustomFieldsDisplayandRequireLabelText,TestDataSet.get("CustomFieldsDisplayandRequireLabel"));
						Assert.assertEquals(DirectoryPageObject.GetCustomFieldsDontDisplayLabelText,TestDataSet.get("CustomFieldsDontDisplayLabel"));
						Assert.assertEquals(DirectoryPageObject.GetSaveButtonText,TestDataSet.get("SaveButtonLabel"));
						Assert.assertEquals(DirectoryPageObject.GetCancelButtonText,TestDataSet.get("CancelButtonLabel"));
						
						System.out.println("VerifyLabelsOnEditDirectoryPage ends");
					}
						
						@DataProvider
						public Object[][] getTestDataForVerifyLabelsOnEditDirectoryPage()
						{
							Object[][] Data = UtilityFunctions.getData("VerifyLabelsOnEditDirectoryPage", BasePage.xls);
							return Data;
						}	
						
			//Verify That user is able to delete directory successfully and Confirmation message displayed before deletion	
			@Test(priority=8,dataProvider = "getTestDataForVerifyDeleteDirectory")
			public void VerifyDeleteDirectory(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyDeleteDirectory", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
								
						DirectoryPage.NavigateToDirectoryList();
						DirectoryPageObject=DirectoryPage.DeleteDirectory(TestDataSet.get("DirectoryNameValue"));
						Assert.assertEquals(DirectoryPageObject.AssertTextForDeleteDirectory,DirectoryPage.AssertTextForDeleteDirectory);
						Assert.assertEquals(DirectoryPageObject.DeletedDirectoryPresenceValue,"False");	
						System.out.println("VerifyDeleteDirectory ends");
					}
								
			@DataProvider
			public Object[][] getTestDataForVerifyDeleteDirectory()
				{
						Object[][] Data = UtilityFunctions.getData("VerifyDeleteDirectory", BasePage.xls);
						return Data;
					}	
			
			//Verify that deleted directory is not displayed under search contact and method will run only when Above test is passed
			@Test(priority=9,dataProvider = "getTestDataForVerifyDeletedDirectoryNotDisplayedInSearchContact")
			public void VerifyDeletedDirectoryNotDisplayedInSearchContact(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyDeletedDirectoryNotDisplayedInSearchContact", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
								
						SearchContactPage.NavigateToSearchContacts();
						GetDirectorytext5=SearchContactPage.ValidateDirectoryPresenceInSearchContactOptions(TestDataSet.get("DirectoryNameValue"));	
						Assert.assertEquals(GetDirectorytext5,"True");
						System.out.println("VerifyDeletedDirectoryNotDisplayedInSearchContact ends");
					}
								
			@DataProvider
			public Object[][] getTestDataForVerifyDeletedDirectoryNotDisplayedInSearchContact()
				{
						Object[][] Data = UtilityFunctions.getData("VerifyDeletedDirectoryNotDisplayedInSearchContact", BasePage.xls);
						return Data;
					}	
}
