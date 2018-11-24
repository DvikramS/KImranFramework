package TestCases.NotificationTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.AddChannelPage;
import Page.ContactPages.AddContactPage;
import Page.ContactPages.ChannelListPage;
import Page.ContactPages.EditContactPage;
import Page.ContactPages.SearchContactPage;
import Page.NotificationPages.DistributionDetailspage;
import Page.NotificationPages.DistributionReportListPage;
import Page.NotificationPages.SendNotificationPage;
import Util.UtilityFunctions;

public class SendNotificationTests {

	private static String SendNotificationAssertText1;
	private static String SendNotificationAssertText2;
	private static String SendNotificationAssertText3;
	private static String SendNotificationAssertText4;
	private static String SendNotificationAssertText5;
	private static String Recipent1FullName;
	private static String Recipent2FullName;
	private static String GetRecipent1FullName;
	private static String GetRecipent2FullName;
	private static String GetRecipentName;
	private static String GetSelectedContactText;
	private static String SendNotificationAssertText6;
	
	
	SendNotificationPage SendNotificationPageObject;
	DistributionDetailspage DistributionDetailspageObject;
	
	//Navigate to Send Notification page
		@Test(priority=1)
		public void NavigateToSendNotificationPage()
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("NavigateToSendNotificationPage", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			    SendNotificationAssertText1=SendNotificationPage.NavigateToSendNotificationPage();
				Assert.assertEquals(SendNotificationAssertText1, "Send Notification");
				System.out.println("NavigateToSendNotificationPage ends");
		
		}
		
		@Test(priority=2,dataProvider = "getTestDataForVerifyContactDetailsOnPopUp_Channel")
		public void VerifyContactDetailsOnPopUp_Channel(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyContactDetailsOnPopUp_Channel", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			   System.out.println("Verify Contact is displayed in Contact Search PopUp Test Starts");
			   SendNotificationPage.NavigateToSendNotificationPage();
			   SendNotificationPage.SelectChannel(TestDataSet.get("ChannelNameValue"));
			   SendNotificationPageObject=SendNotificationPage.VerifyContactInPopUp();
			   Assert.assertEquals(SendNotificationPageObject.SendNotificationAssertText3,TestDataSet.get("FirstNameValue"));
			   Assert.assertEquals(SendNotificationPageObject.SendNotificationAssertText4,TestDataSet.get("LastNameValue"));
			   System.out.println("Verify Contact is displayed in Contact Search PopUp ends");
		
		}
		
		@DataProvider
		public Object[][] getTestDataForVerifyContactDetailsOnPopUp_Channel()
		{
			Object[][] Data = UtilityFunctions.getData("VerifyContactDetailsOnPopUp_Channel", BasePage.xls);
			return Data;
		}
		
		@Test(priority=3)
		public void VerifyGeofencingSectionPresence()
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyGeofencingSectionPresence", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
				System.out.println("VerifyGeofencingSectionPresence Start");
				SendNotificationPage.NavigateToSendNotificationPage();
				SendNotificationPage.SwtichToManualTab();
				SendNotificationAssertText3=SendNotificationPage.SelectGeofencingCheckbox();
				Assert.assertEquals(SendNotificationAssertText3, SendNotificationPage.BufferZoneLabel);
				System.out.println("VerifyGeofencingSectionPresence ends");
		
		}
		
		 //Associate contacts with group and directory for notification Sending purposes
		@Test(priority=4,dataProvider = "getTestDataForVerifyContacAssociations")
		public void VerifyContacAssociations(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyContacAssociations", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			   System.out.println("VerifyContacAssociations Test Starts");
			   //Associate contacts with group and directory for notification Sending purposes
			   SearchContactPage.NavigateToSearchContacts();
			   SearchContactPage.SearchContactByName(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"));
			   SearchContactPage.EditContact();
			   EditContactPage.AsscoiateGroupWithContactTab(TestDataSet.get("BasicGroupNameValue"));
			   //Enable when contact in test data is used other than Jason Tyler
			  // EditContactPage.AssociateMultipleDirectory(TestDataSet.get("DirectoryValue"));
			   System.out.println("VerifyContacAssociations ends");
		
		}
		
		@DataProvider
		public Object[][] getTestDataForVerifyContacAssociations()
		{
			Object[][] Data = UtilityFunctions.getData("VerifyContacAssociations", BasePage.xls);
			return Data;
		}
		
		
		//Verify Contacts on contact Details Popup
		@Test(priority=5,dataProvider = "getTestDataForVerifyContactDetailsOnGroupsPopUp")
		public void VerifyContactDetailsOnGroupPopUp(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyContactDetailsOnGroupPopUp", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			   System.out.println("VerifyContactDetailsOnGroupPopUp Test Starts");
			   SendNotificationPage.NavigateToSendNotificationPage();
			   SendNotificationPage.SwtichToManualTab();
			   SendNotificationPage.SelectGroup(TestDataSet.get("GroupNameValue"));
			   SendNotificationPageObject=SendNotificationPage.VerifySelectedGroupContactInPopUp();
			   Assert.assertEquals(SendNotificationPage.SendNotificationAssertText7,TestDataSet.get("FirstNameValue"));
			   Assert.assertEquals(SendNotificationPage.SendNotificationAssertText8,TestDataSet.get("LastNameValue"));
			   System.out.println("VerifyContactDetailsOnGroupPopUp ends");
		
		}
		
		@DataProvider
		public Object[][] getTestDataForVerifyContactDetailsOnGroupsPopUp()
		{
			Object[][] Data = UtilityFunctions.getData("VerifyContactDetailsOnGroupPopUp", BasePage.xls);
			return Data;
		}
		
		@Test(priority=6,dataProvider = "getTestDataForVerifySendNotificationToGroup_Geofencing")
		public void VerifySendNotificationToGroup_Geofencing(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifySendNotificationToGroup_Geofencing", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			   System.out.println("VerifySendNotificationToGroup_Geofencing Test Starts");
			  
			   SendNotificationPage.SelectGeofencingCheckbox();
			   SendNotificationPage.SelectLocationFromGeofencingPopUp(TestDataSet.get("AddressValue"));
			   SendNotificationPage.EnterDataAndSendNotification(TestDataSet.get("TitleValue"),TestDataSet.get("BodyTextValue"));
			   SendNotificationPage.VerifySentNotification();
			   SendNotificationAssertText4=DistributionReportListPage.ValidateSentNotificationOnList(TestDataSet.get("TitleValue"));
			   DistributionReportListPage.NavigateToDistributionDetails(TestDataSet.get("TitleValue"));
			   DistributionDetailspage.NavigateToRecipentTab();
			   Recipent1FullName=TestDataSet.get("FirstNameValue")+" "+TestDataSet.get("LastNameValue");
			   DistributionDetailspageObject=DistributionDetailspage.ValidateRecipentisDisplayed(Recipent1FullName);
			   Assert.assertEquals(DistributionDetailspageObject.GetRecipentFullName,Recipent1FullName);
			   Assert.assertEquals(DistributionDetailspageObject.GetRecipentPresence,"True");
			   Recipent2FullName=TestDataSet.get("FirstName2Value")+" "+TestDataSet.get("LastName2Value");
			   DistributionDetailspageObject=DistributionDetailspage.ValidateRecipentisDisplayed(Recipent2FullName);
			   Assert.assertEquals(DistributionDetailspageObject.GetRecipentPresence,"False");
			   System.out.println("VerifySendNotificationToGroup_Geofencing ends");
		
		}
		
		@DataProvider
		public Object[][] getTestDataForVerifySendNotificationToGroup_Geofencing()
		{
			Object[][] Data = UtilityFunctions.getData("VerifySendNotificationToGroup_Geofencing", BasePage.xls);
			return Data;
		}
		
		//Verify Contacts on contact Details Popup of a directory
				@Test(priority=7,dataProvider = "getTestDataForVerifyContactDetailsOnDirectoryPopUp")
				public void VerifyContactDetailsOnDirectoryPopUp(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifyContactDetailsOnDirectoryPopUp", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					   System.out.println("VerifyContactDetailsOnDirectoryPopUp Test Starts");
					   SendNotificationPage.NavigateToSendNotificationPage();
					   SendNotificationPage.SwtichToManualTab();
					   SendNotificationPage.SelectDirectory(TestDataSet.get("DirectoryNameValue"));
					   SendNotificationPageObject=SendNotificationPage.VerifySelectedDirectoryContactInPopUp(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"));
					   Assert.assertEquals(SendNotificationPage.SendNotificationAssertText9,TestDataSet.get("FirstNameValue"));
					   Assert.assertEquals(SendNotificationPage.SendNotificationAssertText10,TestDataSet.get("LastNameValue"));
					   System.out.println("VerifyContactDetailsOnDirectoryPopUp ends");
				
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifyContactDetailsOnDirectoryPopUp()
				{
					Object[][] Data = UtilityFunctions.getData("VerifyContactDetailsOnDirectoryPopUp", BasePage.xls);
					return Data;
				}
		
				//Test Send Notification to a directory through GeoFencing where one contact recives notification and another doesn't
				@Test(priority=8,dataProvider = "getTestDataForVerifySendNotificationToDirectory_Geofencing")
				public void VerifySendNotificationToDirectory_Geofencing(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifySendNotificationToDirectory_Geofencing", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					   System.out.println("VerifySendNotificationToDirectory_Geofencing Test Starts");
					  
					   SendNotificationPage.SelectGeofencingCheckbox();
					   SendNotificationPage.SelectLocationFromGeofencingPopUp(TestDataSet.get("AddressValue"));
					   SendNotificationPage.EnterDataAndSendNotification(TestDataSet.get("TitleValue"),TestDataSet.get("BodyTextValue"));
					   SendNotificationPage.VerifySentNotification();
					   SendNotificationAssertText4=DistributionReportListPage.ValidateSentNotificationOnList(TestDataSet.get("TitleValue"));
					   DistributionReportListPage.NavigateToDistributionDetails(TestDataSet.get("TitleValue"));
					   DistributionDetailspage.NavigateToRecipentTab();
					   Recipent1FullName=TestDataSet.get("FirstNameValue")+" "+TestDataSet.get("LastNameValue");
					   DistributionDetailspageObject=DistributionDetailspage.ValidateRecipentisDisplayed(Recipent1FullName);
					   Assert.assertEquals(DistributionDetailspageObject.GetRecipentFullName,Recipent1FullName);
					   Assert.assertEquals(DistributionDetailspageObject.GetRecipentPresence,"True");
					   Recipent2FullName=TestDataSet.get("FirstName2Value")+" "+TestDataSet.get("LastName2Value");
					   DistributionDetailspageObject=DistributionDetailspage.ValidateRecipentisDisplayed(Recipent2FullName);
					   Assert.assertEquals(DistributionDetailspageObject.GetRecipentPresence,"False");
					   System.out.println("VerifySendNotificationToDirectory_Geofencing ends");
				
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifySendNotificationToDirectory_Geofencing()
				{
					Object[][] Data = UtilityFunctions.getData("VerifySendNotificationToDirectory_Geofencing", BasePage.xls);
					return Data;
				}
				
				//Test Send Notification to a contact Popup through GeoFencing
				@Test(priority=8,dataProvider = "getTestDataForVerifySendNotificationToContact_Geofencing")
				public void VerifySendNotificationToContact_Geofencing(Hashtable<String, String> TestDataSet)
				{
					//Check for runmode
					if (UtilityFunctions.IsExecutable("VerifySendNotificationToContact_Geofencing", BasePage.xls)!=true)
						throw new SkipException("Run Mode Set to No");
					
					   System.out.println("VerifySendNotificationToContact_Geofencing Test Starts");
					   SendNotificationPage.NavigateToSendNotificationPage();
					   SendNotificationPage.SwtichToManualTab();
					   GetRecipentName=SendNotificationPage.SelectContact(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"));
					   GetSelectedContactText=TestDataSet.get("FirstNameValue")+" "+TestDataSet.get("LastNameValue")+" - "+TestDataSet.get("EmailValue");
					   Assert.assertEquals(GetRecipentName,GetSelectedContactText);
					   SendNotificationPage.SelectGeofencingCheckbox();
					   SendNotificationPage.SelectLocationFromGeofencingPopUp(TestDataSet.get("AddressValue"));
					   SendNotificationPage.EnterDataAndSendNotification(TestDataSet.get("TitleValue"),TestDataSet.get("BodyTextValue"));
					   SendNotificationAssertText6=SendNotificationPage.VerifySentNotification();
					   Assert.assertEquals(SendNotificationAssertText6,TestDataSet.get("TitleValue"));
				}
				
				@DataProvider
				public Object[][] getTestDataForVerifySendNotificationToContact_Geofencing()
				{
					Object[][] Data = UtilityFunctions.getData("VerifySendNotificationToContact_Geofencing", BasePage.xls);
					return Data;
				}
				
}
