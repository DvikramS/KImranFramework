package TestCases.ContactTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.EditContactPage;
import Page.ContactPages.SearchContactPage;
import Page.NotificationPages.DistributionReportListPage;
import Util.UtilityFunctions;

public class GuestUserTests {

	private static String guestUserAssertText1;
	
	//Verify email is trigerred when guest user is created (In this case guest user is created from guest info tab)

	@Test(priority=1,dataProvider = "getTestDataForverifyEmailFromGuestUserCreation")
	public void verifyEmailFromGuestUserCreation(Hashtable<String, String> TestDataSet)
	{
		//Check for runmode
		if (UtilityFunctions.IsExecutable("verifyEmailFromGuestUserCreation", BasePage.xls)!=true)
			throw new SkipException("Run Mode Set to No");
		
		   System.out.println("verifyEmailFromGuestUserCreation Test Starts");
		   SearchContactPage.NavigateToSearchContacts();
		   SearchContactPage.SearchContactByName(TestDataSet.get("FirstNameValue"),TestDataSet.get("LastNameValue"),TestDataSet.get("EmailValue"));
		   SearchContactPage.EditContact();
		   guestUserAssertText1=EditContactPage.CreateGuestuser(TestDataSet.get("PasswordValue"));
		   DistributionReportListPage.NavigateToDistributionReportPage();
		   DistributionReportListPage.ValidateSentNotificationOnList(TestDataSet.get("NotificationName"));
		   Assert.assertEquals(guestUserAssertText1,TestDataSet.get("EmailValue"));
		   System.out.println("verifyEmailFromGuestUserCreation ends");	
	}
	
	@DataProvider
	public Object[][] getTestDataForVerifyEmailFromGuestUserCreation()
	{
		Object[][] Data = UtilityFunctions.getData("VerifyEmailFromGuestUserCreation", BasePage.xls);
		return Data;
	}
}
