package TestCases.ContactTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.AddChannelPage;
import Page.ContactPages.ChannelListPage;
import Page.ContactPages.EditContactPage;
import Page.ContactPages.SearchContactPage;
import Page.InquiryPages.SearchInquiryPage;
import Page.NotificationPages.SendNotificationPage;
import Util.UtilityFunctions;

public class ChannelTests {

	private static String GetChannelListText1;
	private static String GetChannelListText2;
	private static String GetChannelListText3;
	private static String GetChannelListText4;
	
	ChannelListPage ChannelListPageObject;
	EditContactPage EditContactPageObject1;
	
	//Navigate to channel list page
	@Test(priority=1)
	public void NavigateToChannelListPage()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("NavigateToChannelListPage", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
			GetChannelListText1=ChannelListPage.NavigateToChannelListPage();
			Assert.assertEquals(GetChannelListText1, "Channels");
			System.out.println("NavigateToChannelListPage ends");
	
	}
	
	//Verify Add Channel functionality
	@Test(priority=2,dataProvider = "getTestDataForVerifyAddChannel")
	public void VerifyAddChannel(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyAddChannel", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("Verify Add Channel functionality Test Starts");
		   GetChannelListText2=AddChannelPage.AddChannel(TestDataSet.get("ChannelNameValue"), TestDataSet.get("ChannelNameDescription"), TestDataSet.get("FromEmailAddressValue"));
			Assert.assertEquals(GetChannelListText2,TestDataSet.get("ChannelNameValue"));	
			System.out.println("Verify Add Channel functionality ends");
	
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyAddChannel()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyAddChannel", BasePage.xls);
		return Data;
	}
	
	//Verify Edit Channel functionality
		@Test(priority=3,dataProvider = "getTestDataForVerifyEditChannel")
		public void VerifyEditChannel(Hashtable<String, String> TestDataSet)
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyEditChannel", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			   System.out.println("Verify Edit Channel functionality Test Starts");
			   ChannelListPage.NavigateToChannelListPage();
			   GetChannelListText2= AddChannelPage.EditChannel(TestDataSet.get("ChannelNameValue"), TestDataSet.get("NewChannelNameValue"), TestDataSet.get("NewChannelDescriptionValue"));
			  Assert.assertEquals(GetChannelListText2,TestDataSet.get("NewChannelNameValue"));	
				System.out.println("Verify Edit Channel functionality ends");
		
		}
		
		@DataProvider
		public Object[][] getTestDataForVerifyEditChannel()
		{
			Object[][] Data = UtilityFunctions.getData("VerifyEditChannel", BasePage.xls);
			return Data;
		}
	
		//Verify Delete Channel functionality
			@Test(priority=4,dataProvider = "getTestDataForVerifyDeleteChannel")
			public void VerifyDeleteChannel(Hashtable<String, String> TestDataSet)
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("VerifyDeleteChannel", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				
				   System.out.println("Verify Delete Channel functionality Test Starts");
				   ChannelListPage.NavigateToChannelListPage();
				   ChannelListPageObject=ChannelListPage.DeleteChannel(TestDataSet.get("ChannelNameValue"));
					Assert.assertEquals(ChannelListPageObject.ChannelDeleteAsserttext1,ChannelListPageObject.DeleteChannelConfirmationLabel);	
					Assert.assertTrue(ChannelListPageObject.ChannelDeleteAsserttext2.contains(ChannelListPageObject.DeleteMessageLabel));
					System.out.println("Verify Delete Channel functionality ends");
			
			}
			
			@DataProvider
			public Object[][] getTestDataForVerifyDeleteChannel()
			{
				Object[][] Data = UtilityFunctions.getData("VerifyDeleteChannel", BasePage.xls);
				return Data;
			}
			
			//Verify Contact is able to subscribe channel successfully, creating a new channel for subscription
			@Test(priority=5,dataProvider = "getTestDataForVerifyContactSubscribeChannelSuccessfully")
			public void VerifyContactSubscribeChannelSuccessfully(Hashtable<String, String> TestDataSet)
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("VerifyContactSubscribeChannelSuccessfully", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				
				   System.out.println("Verify Contact is able to subcribe Channel functionality Test Starts");
				   ChannelListPage.NavigateToChannelListPage();
				   AddChannelPage.AddChannel(TestDataSet.get("ChannelNameValue"), TestDataSet.get("ChannelNameDescription"), TestDataSet.get("FromEmailAddressValue"));
				   SearchContactPage.NavigateToSearchContacts();
				   SearchContactPage.SearchContactByName(TestDataSet.get("FirstNameValue"), TestDataSet.get("LastNameValue"), TestDataSet.get("EmailValue"));
				   SearchContactPage.EditContact();
				   EditContactPageObject1=EditContactPage.ContactSubscribeToChannel(TestDataSet.get("ChannelNameValue"));
				   //Assert.assertEquals(EditContactPage.GetContactSubscriptionSuccessMessage,EditContactPage.ContactSubscriptionSuccessMessageLabel);	
				   Assert.assertTrue(EditContactPage.IsEmailSelected);
				   Assert.assertTrue(EditContactPage.IsPhoneSelected);
				   Assert.assertTrue(EditContactPage.IsSMSSelected);
				   System.out.println("Verify Contact is able to subcribe Channel functionality ends");
			
			}
			
			@DataProvider
			public Object[][] getTestDataForVerifyContactSubscribeChannelSuccessfully()
			{
				Object[][] Data = UtilityFunctions.getData("VerifyContactSubscribeChannelSuccessfully", BasePage.xls);
				return Data;
			}
			
			//Verify that user is able to Select a channel and send Notification
			@Test(priority=6,dataProvider = "getTestDataForVerifySendNotificationtUsingChannel")
			public void VerifySendNotificationtUsingChannel(Hashtable<String, String> TestDataSet)
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("VerifySendNotificationtUsingChannel", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				
				   System.out.println("Verify Send Notification using Channel functionality Test Starts");
				   SendNotificationPage.NavigateToSendNotificationPage();
				   SendNotificationPage.SelectChannel(TestDataSet.get("ChannelNameValue"));
				   GetChannelListText3=SendNotificationPage.EnterDataAndSendNotification(TestDataSet.get("TitleValue"), TestDataSet.get("BodyTextValue"));
				   GetChannelListText4=SendNotificationPage.VerifySentNotification();
				   Assert.assertEquals(GetChannelListText4,TestDataSet.get("TitleValue"));
				   System.out.println("Verify Send Notification using Channel functionality ends");
			}
			
			@DataProvider
			public Object[][] getTestDataForVerifySendNotificationtUsingChannel()
			{
				Object[][] Data = UtilityFunctions.getData("VerifySendNotificationtUsingChannel", BasePage.xls);
				return Data;
			}
			
}
