package TestCases.InquiryTests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.InquiryPages.NotificationSettingsPage;
import Page.InquiryPages.SearchInquiryPage;
import Util.UtilityFunctions;

public class NotificationSettingTests {

	String GetnotificationSettingAssertResult1;
	String GetnotificationSettingAssertResult2;
	String GetnotificationSettingAssertResult3;
	
	//Validate Navigation to Notification setting page
	@Test(priority=1)
	public void VerifyNavigateToNotificationSetting()
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("VerifyNavigateToNotificationSetting", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		GetnotificationSettingAssertResult1=NotificationSettingsPage.NavigateToNotificationSettingPage();
			Assert.assertEquals(GetnotificationSettingAssertResult1, "Email Notification Options");
			System.out.println("VerifyNavigateToNotificationSetting ends");
	}
	
	//Function for assigning Inquiry Notification List user and Selecting option Send Notifications for Internally-Created Inquiries to No and Save the page
		@Test(priority=2)
		public void VerifyAbleToSelectUserandUpdateOptionForInternallyCreatedInquiries()
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyAbleToSelectUserandUpdateOptionForInternallyCreatedInquiries", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			    GetnotificationSettingAssertResult2=NotificationSettingsPage.SelectUserAndNotificationOption();
				Assert.assertEquals(GetnotificationSettingAssertResult2,"True");
				System.out.println("VerifyAbleToSelectUserandUpdateOptionForInternallyCreatedInquiries ends");
		}
		
		//Verify user is able to associate user in Survey Notification option
		@Test(priority=3)
		public void VerifyAbleToSelectUserforSurvey()
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyAbleToSelectUserforSurvey", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			    GetnotificationSettingAssertResult3=NotificationSettingsPage.SelectSurveyListUser();
				Assert.assertEquals(GetnotificationSettingAssertResult3,"True");
				System.out.println("VerifyAbleToSelectUserforSurvey ends");
		}	
}
