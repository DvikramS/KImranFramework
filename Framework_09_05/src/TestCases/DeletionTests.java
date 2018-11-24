package TestCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.ContactPages.SearchContactPage;
import Page.NotificationPages.DistributionDetailspage;
import Page.NotificationPages.DistributionReportListPage;
import Page.NotificationPages.SendNotificationPage;
import Util.UtilityFunctions;

public class DeletionTests {

	 SearchContactPage SearchContactPageObject;
	//Case for contact deletion
	@Test(priority=1,dataProvider = "getTestDataForVerifyContactDeletion")
	public  void VerifyContactDeletion(Hashtable<String, String> TestDataSet)
	{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("VerifyContactDeletion", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
			   System.out.println("VerifyContactDeletion Test Starts");
			   SearchContactPage.NavigateToSearchContacts();
			   SearchContactPage.SearchContactByName(TestDataSet.get("FirstNameValue"), TestDataSet.get("LastNameValue"), TestDataSet.get("EmailValue"));
			   SearchContactPageObject=SearchContactPage.DeleteContact(TestDataSet.get("FirstNameValue"), TestDataSet.get("LastNameValue"), TestDataSet.get("EmailValue"));
			   Assert.assertEquals(SearchContactPageObject.SearchContactsAssertlabel9,SearchContactPageObject.DeletionConfirmationPopUpMessageLabel); 
			   //Assert.assertEquals(SearchContactPageObject.GetSearchContactsAssertlabel11,SearchContactPageObject.DeletionMessageLabel);
			   Assert.assertEquals(SearchContactPageObject.GetSearchContactsAssertlabel10,"No record found.");
			   System.out.println("VerifyContactDeletion ends");
		}
		
		@DataProvider
		public Object[][] getTestDataForVerifyContactDeletion()
		{
			Object[][] Data = UtilityFunctions.getData("VerifyContactDeletion", BasePage.xls);
			return Data;
		}
	
		
		
}
