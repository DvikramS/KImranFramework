package TestCases.OtherModuleTests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import Base.BasePage;
import Page.InquiryPages.InquiryAnswerPage;
import Page.OtherModulePages.WebsiteDashboardPage;
import Util.UtilityFunctions;

public class WebsiteDashboardTests {

	private static String websiteDashboardAssertText1;
	
	WebsiteDashboardPage WebsiteDashboardPageObject;
	
	//Verify that user is able to navigate to Website dashboard successfully
		@Test(priority=1)
		public void verifyNavigationToWebsiteDashboard()
		{
			//Check for runmode
			if (UtilityFunctions.IsExecutable("verifyNavigationToWebsiteDashboard", BasePage.xls)!=true)
				throw new SkipException("Run Mode Set to No");
			
				System.out.println("verifyNavigationToWebsiteDashboard Start");
				websiteDashboardAssertText1=WebsiteDashboardPage.navigateToWebsiteDashboardFromDNN();
				Assert.assertEquals(websiteDashboardAssertText1,WebsiteDashboardPage.headerDashboardLabel);
				System.out.println("verifyNavigationToWebsiteDashboard ends");
		}
		
		//Verify count on inquiry tab is correct and on clicking on it user navigates to search inquiry page
			@Test(priority=2)
			public void verifyInquiryTabCountAndNavigation()
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("verifyInquiryTabCountAndNavigation", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				
					System.out.println("verifyInquiryTabCountAndNavigation Start");
					WebsiteDashboardPageObject=WebsiteDashboardPage.validateInquiryTabDisplayedNumberAndNavigation();
					WebsiteDashboardPage.navigateToWebsiteDashboard();
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText2, WebsiteDashboardPageObject.inquiriesTabLabel);
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText3, WebsiteDashboardPageObject.websiteDashboardAssertText4);
					System.out.println("verifyInquiryTabCountAndNavigation ends");
			}
			
			//Verify count on contacts tab is correct and on clicking on it user navigates to search contact page
			@Test(priority=3)
			public void verifyContactTabCountAndNavigation()
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("verifyContactTabCountAndNavigation", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				
					System.out.println("verifyContactTabCountAndNavigation Start");
					WebsiteDashboardPageObject=WebsiteDashboardPage.validateContactTabDisplayedNumberAndNavigation();
					WebsiteDashboardPage.navigateToWebsiteDashboard();
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText5, WebsiteDashboardPageObject.contactsTabLabel);
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText6, WebsiteDashboardPageObject.websiteDashboardAssertText7);
					System.out.println("verifyContactTabCountAndNavigation ends");
			}
			
			//Verify count on Documents tab and on clicking on it user navigates to document management page
			@Test(priority=4)
			public void verifyDocumentTabCountAndNavigation()
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("verifyDocumentTabCountAndNavigation", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				
					System.out.println("verifyDocumentTabCountAndNavigation Start");
					WebsiteDashboardPageObject=WebsiteDashboardPage.validateDocumentTabDisplayedNumberAndNavigation();
					WebsiteDashboardPage.navigateToWebsiteDashboardFromDNN();
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText8, WebsiteDashboardPageObject.documentsTabLabel);
					System.out.println("verifyDocumentTabCountAndNavigation ends");
			}
			
			//Verify count on inquiry list excerpt and on clicking on it user navigates to inquiry details page
			@Test(priority=5)
			public void verifyInquiryListExcerptNavigation()
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("verifyInquiryListExcerptNavigation", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				
					System.out.println("verifyInquiryListExcerptNavigation Start");
					WebsiteDashboardPageObject=WebsiteDashboardPage.validatenavigationFromInquiryList();
					WebsiteDashboardPage.navigateToWebsiteDashboard();
					Assert.assertTrue(WebsiteDashboardPageObject.websiteDashboardAssertText10.contains(WebsiteDashboardPageObject.inquiryListGridLabel));
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText11, WebsiteDashboardPageObject.websiteDashboardAssertText12);
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText13, WebsiteDashboardPageObject.websiteDashboardAssertText14);
					System.out.println("verifyInquiryListExcerptNavigation ends");
			}
			
			@Test(priority=6)
			public void verifyContactDirectoriesNavigation()
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("verifyContactDirectoriesNavigation", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				
					System.out.println("verifyContactDirectoriesNavigation Start");
					WebsiteDashboardPageObject=WebsiteDashboardPage.validatenavigationFromContactDirectories();
					WebsiteDashboardPage.navigateToWebsiteDashboard();
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText15, WebsiteDashboardPageObject.contactDirectoriesLabel);
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText16, WebsiteDashboardPageObject.websiteDashboardAssertText18);
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText17, WebsiteDashboardPageObject.websiteDashboardAssertText19);
					System.out.println("verifyContactDirectoriesNavigation ends");
			}
			
			@Test(priority=7)
			public void verifyContactGroupNavigation()
			{
				//Check for runmode
				if (UtilityFunctions.IsExecutable("verifyContactGroupNavigation", BasePage.xls)!=true)
					throw new SkipException("Run Mode Set to No");
				
					System.out.println("verifyContactGroupNavigation Start");
					WebsiteDashboardPageObject=WebsiteDashboardPage.validatenavigationFromContactGroup();
					WebsiteDashboardPage.navigateToWebsiteDashboard();
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText20, WebsiteDashboardPageObject.contactGroupLabel);
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText21, WebsiteDashboardPageObject.websiteDashboardAssertText23);
					Assert.assertEquals(WebsiteDashboardPageObject.websiteDashboardAssertText22, WebsiteDashboardPageObject.websiteDashboardAssertText24);
					System.out.println("verifyContactGroupNavigation ends");
			}
}
