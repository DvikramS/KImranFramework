package TestCases.NotificationTests;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.NotificationPages.DistributionDetailspage;
import Page.NotificationPages.DistributionReportListPage;
import Page.NotificationPages.SendNotificationPage;
import Util.UtilityFunctions;

public class DistributionReportTests {
	
	String DistribtuionReportAssertText1;
	String DistribtuionReportAssertText2;
	String DistribtuionReportAssertText3;
	
	DistributionDetailspage DistributionDetailspageObject;

	//Navigate to Send Notification page
			@Test(priority=1)
			public void VerifyNavigateToDistributionReportPage()
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("VerifyNavigateToDistributionReportPage", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				    System.out.println("VerifyNavigateToDistributionReportPage Test Starts");
					DistribtuionReportAssertText1=DistributionReportListPage.NavigateToDistributionReportPage();
					Assert.assertEquals(DistribtuionReportAssertText1, "All Notifications");
					System.out.println("VerifyNavigateToDistributionReportPage ends");
			}
			
			@Test(priority=2,dataProvider = "getTestDataForVerifyGeofencingMapTab")
			public void VerifyGeofencingMapTab(Hashtable<String, String> TestDataSet)
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("VerifyGeofencingMapTab", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				
				   System.out.println("VerifyGeofencingMapTab Test Starts");
				   DistributionReportListPage.NavigateToDistributionDetails(TestDataSet.get("NotificationName"));
				   DistributionDetailspageObject=DistributionDetailspage.NavigateToGeofencingTab();
				   Assert.assertEquals(DistributionDetailspageObject.GetDistributionReportText1, "Geo Fenced");
				   Assert.assertEquals(DistributionDetailspageObject.GetDistributionReportText2, "50.00 mi buffer zone");
				   Assert.assertEquals(DistributionDetailspageObject.GetDistributionReportText, "Map");
				   System.out.println("VerifyGeofencingMapTab ends");
			}
			
			@DataProvider
			public Object[][] getTestDataForVerifyGeofencingMapTab()
			{
				Object[][] Data = UtilityFunctions.getData("VerifyGeofencingMapTab", BasePage.xls);
				return Data;
			}
			
			@Test(priority=3)
			public void VerifyNavigateToExceptionTab()
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("VerifyNavigateToExceptionTab", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				    System.out.println("VerifyNavigateToExceptionTab Test Starts");
				    DistribtuionReportAssertText2=DistributionDetailspage.NavigateToExceptionTab();
				    Assert.assertEquals(DistribtuionReportAssertText2, "Recipients with one or more errors");
					System.out.println("VerifyNavigateToExceptionTab ends");
			}
			
			@Test(priority=4)
			public void VerifyBackButtonFunctionalityOnDistributionDetails()
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("VerifyBackButtonFunctionalityOnDistributionDetails", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				    System.out.println("VerifyNavigateToDistributionReportPage Test Starts");
				    DistribtuionReportAssertText3=DistributionDetailspage.ClickBackButton();
				    Assert.assertEquals(DistribtuionReportAssertText3, "All Notifications");
					System.out.println("VerifyBackButtonFunctionalityOnDistributionDetails ends");
			}
}
