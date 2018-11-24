package Page.OtherModulePages;

import org.openqa.selenium.By;

import Base.BasePage;
import Page.ContactPages.SearchContactPage;
import Page.Document.DocumentManagementPage;
import Page.GroupPages.GroupDetailsPage;
import Page.InquiryPages.InquiryDetailsPage;
import Page.InquiryPages.SearchInquiryPage;
import Util.UtilityFunctions;

public class WebsiteDashboardPage {

	private static String menuDashboardDNN="//*[@id='navbar-collapse-1']/ul/li[4]/ul/ul[3]/ul[1]/li/a";
	private static String menuDashboard="//*[@id='navbar-collapse-1']/ul/li[4]/ul/ul[3]/ul[1]/li/a";
	private static String inquiryGridFirstRow="//*[@id='divDashboard']/div[3]/div[1]/div/div[2]/div[1]/table/tbody/tr[1]/td[1]";
	private static String headerDashboard="//*[@id='divDashboard']/div[1]/div/h1/div[1]";
	
	private static String inquiryLabel="//*[@id='divDashboard']/div[2]/ul/li[1]/a/div[2]";
	private static String numberOfInquiries="//*[@id='divDashboard']/div[2]/ul/li[1]/a/div[1]/div/span/span";
	private static String contactLabel="//*[@id='divDashboard']/div[2]/ul/li[3]/a/div[2]";
	private static String numberofContacts="//*[@id='divDashboard']/div[2]/ul/li[3]/a/div[1]/div/span";
	private static String documentsLabel="//*[@id='divDashboard']/div[2]/ul/li[2]/a/div[2]";
	private static String numberOfDocuments="//*[@id='divDashboard']/div[2]/ul/li[2]/a/div[1]/div/span/span";
	private static String inquiryListGridLabelPath="//*[@id='divDashboard']/div[3]/div[1]/div/div[1]/div[1]";
	private static String firstInquiryExcerptFromInquiryList="//*[@id='divDashboard']/div[3]/div[1]/div/div[2]/div[1]/table/tbody/tr/td[3]/a";
	private static String inquiryListCount="//*[@id='divDashboard']/div[3]/div[1]/div/div[1]/div[1]/span";
	private static String contactDirectoryGridLabel="//*[@id='divDashboard']/div[3]/div[2]/div[1]/div/div[1]/div[1]";
	private static String firstContactDirectoryName="//*[@id='divDirectoryGrid']/div[2]/table/tbody/tr[1]/td[1]/a";
	private static String firstContactDirectoryNumber="//*[@id='divDirectoryGrid']/div[2]/table/tbody/tr[1]/td[2]/a";
	private static String contactGroupGridLabel="//*[@id='divDashboard']/div[3]/div[2]/div[2]/div/div[1]/div[1]";
	private static String firstContactGroupName="//*[@id='divGroupGrid']/div[2]/table/tbody/tr/td[1]/a";
	private static String firstContactGroupNumber="//*[@id='divGroupGrid']/div[2]/table/tbody/tr/td[3]/a";
	
	//Labels on Website Dashboard Page
	public static String headerDashboardLabel="Dashboard";
	public static String inquiriesTabLabel="Inquiries";
	public static String documentsTabLabel="Documents";
	public static String inquiryListGridLabel="Inquiry List";
	public static String contactDirectoriesLabel="Contact Directories";
	public static String contactGroupLabel="Contact Groups";
	public static String contactsTabLabel="Contacts";
	
	public static String websiteDashboardAssertText1;
	public static String websiteDashboardAssertText2;
	public static String websiteDashboardAssertText3;
	public static String websiteDashboardAssertText4;
	public static String websiteDashboardAssertText5;
	public static String websiteDashboardAssertText6;
	public static String websiteDashboardAssertText7;
	public static String websiteDashboardAssertText8;
	public static String websiteDashboardAssertText9;
	public static String websiteDashboardAssertText10;
	public static String websiteDashboardAssertText11;
	public static String websiteDashboardAssertText12;
	public static String websiteDashboardAssertText13;
	public static String websiteDashboardAssertText14;
	public static String websiteDashboardAssertText15;
	public static String websiteDashboardAssertText16;
	public static String websiteDashboardAssertText17;
	public static String websiteDashboardAssertText18;
	public static String websiteDashboardAssertText19;
	public static String websiteDashboardAssertText20;
	public static String websiteDashboardAssertText21;
	public static String websiteDashboardAssertText22;
	public static String websiteDashboardAssertText23;
	public static String websiteDashboardAssertText24;
	
/********************************************************Website Dashboard Functions**********************************************************/
	
	
	public static String navigateToWebsiteDashboardFromDNN()
	{
		BasePage.driver.findElement(By.xpath(DocumentManagementPage.MenuPIERPro_DNN)).click();
        BasePage.driver.findElement(By.xpath(menuDashboardDNN)).click(); 
        try {
		 Thread.sleep(8000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(inquiryGridFirstRow);
        websiteDashboardAssertText1= BasePage.driver.findElement(By.xpath(headerDashboard)).getText();
        return(websiteDashboardAssertText1);
	}
	
	public static String navigateToWebsiteDashboard()
	{
		BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
        BasePage.driver.findElement(By.xpath(menuDashboard)).click(); 
        try {
		 Thread.sleep(8000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(inquiryGridFirstRow);
        websiteDashboardAssertText1= BasePage.driver.findElement(By.xpath(headerDashboard)).getText();
        return(websiteDashboardAssertText1);
	}
	
	//Verify that number on inquiry tab and Navigation on search inquiry page
	public static WebsiteDashboardPage validateInquiryTabDisplayedNumberAndNavigation()
	{
		websiteDashboardAssertText2=BasePage.driver.findElement(By.xpath(inquiryLabel)).getText();
		websiteDashboardAssertText3=BasePage.driver.findElement(By.xpath(numberOfInquiries)).getText();
		BasePage.driver.findElement(By.xpath(numberOfInquiries)).click();
		try {
			 Thread.sleep(8000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	        
	        UtilityFunctions.WaitUntilPresenceOfElement(SearchInquiryPage.SearchInquiry_InquiryListGridLoad);
	        websiteDashboardAssertText4= BasePage.driver.findElement(By.xpath(SearchInquiryPage.CountOnSearchInquiryPage)).getText();
	        return new WebsiteDashboardPage();
	}
	
	//Verify that number on contacts tab and Navigation on search contact page
		public static WebsiteDashboardPage validateContactTabDisplayedNumberAndNavigation()
		{
			websiteDashboardAssertText5=BasePage.driver.findElement(By.xpath(contactLabel)).getText();
			websiteDashboardAssertText6=BasePage.driver.findElement(By.xpath(numberofContacts)).getText();
			BasePage.driver.findElement(By.xpath(numberofContacts)).click();
			try {
				 Thread.sleep(8000);
		   	 } catch (InterruptedException e) {
		 			
		 			e.printStackTrace();
		 		}
		        
		        UtilityFunctions.WaitUntilPresenceOfElement(SearchContactPage.SearchContactsAssertlabel1);
		        websiteDashboardAssertText7= BasePage.driver.findElement(By.xpath(SearchContactPage.NumberOfContactsDisplayed)).getText();
		        return new WebsiteDashboardPage();
		}
		
		//Verify that number on Documents tab and Navigation on documents management page
				public static WebsiteDashboardPage validateDocumentTabDisplayedNumberAndNavigation()
				{
					websiteDashboardAssertText8=BasePage.driver.findElement(By.xpath(documentsLabel)).getText();
					websiteDashboardAssertText9=BasePage.driver.findElement(By.xpath(numberOfDocuments)).getText();
					BasePage.driver.findElement(By.xpath(numberOfDocuments)).click();
					try {
						 Thread.sleep(8000);
				   	 } catch (InterruptedException e) {
				 			
				 			e.printStackTrace();
				 		}
				        
				        UtilityFunctions.WaitUntilPresenceOfElement(DocumentManagementPage.DocumentManagementPageLoadAssert);
				        return new WebsiteDashboardPage();
				}
		
		//Verify that user is able to navigate by clicking on excerpt to inquiry response page
				public static WebsiteDashboardPage validatenavigationFromInquiryList()
				{
					websiteDashboardAssertText10=BasePage.driver.findElement(By.xpath(inquiryListGridLabelPath)).getText();
					websiteDashboardAssertText11=BasePage.driver.findElement(By.xpath(inquiryListCount)).getText();
					websiteDashboardAssertText12=BasePage.driver.findElement(By.xpath(numberOfInquiries)).getText();
					websiteDashboardAssertText13=BasePage.driver.findElement(By.xpath(firstInquiryExcerptFromInquiryList)).getText();
					BasePage.driver.findElement(By.xpath(firstInquiryExcerptFromInquiryList)).click();
					try {
						 Thread.sleep(8000);
				   	 } catch (InterruptedException e) {
				 			
				 			e.printStackTrace();
				 		}
				        
				        UtilityFunctions.WaitUntilPresenceOfElement(InquiryDetailsPage.InquiryDetailPageLoadAssertPoint);
				        websiteDashboardAssertText14= BasePage.driver.findElement(By.xpath(InquiryDetailsPage.InquiryTextLabel)).getText();
				        return new WebsiteDashboardPage();
				}
				
		//Verify that user is able to navigate by clicking on contact directories to search contact page
				public static WebsiteDashboardPage validatenavigationFromContactDirectories()
				{
					websiteDashboardAssertText15=BasePage.driver.findElement(By.xpath(contactDirectoryGridLabel)).getText();
					websiteDashboardAssertText16=BasePage.driver.findElement(By.xpath(firstContactDirectoryName)).getText();
					websiteDashboardAssertText17=BasePage.driver.findElement(By.xpath(firstContactDirectoryNumber)).getText();
					BasePage.driver.findElement(By.xpath(firstContactDirectoryNumber)).click();
					try {
						 Thread.sleep(8000);
				   	 } catch (InterruptedException e) {
				 			
				 			e.printStackTrace();
				 		}
				        
				        UtilityFunctions.WaitUntilPresenceOfElement(SearchContactPage.SearchContactsAssertlabel1);
				        websiteDashboardAssertText18= BasePage.driver.findElement(By.xpath(SearchContactPage.ContactAssignedDirectory)).getText();
				        websiteDashboardAssertText19= BasePage.driver.findElement(By.xpath(SearchContactPage.NumberOfContactsDisplayed)).getText();
				        return new WebsiteDashboardPage();
				}
				
				//Verify that user is able to navigate by clicking on contact group to search contact page
				public static WebsiteDashboardPage validatenavigationFromContactGroup()
				{
					websiteDashboardAssertText20=BasePage.driver.findElement(By.xpath(contactGroupGridLabel)).getText();
					websiteDashboardAssertText21=BasePage.driver.findElement(By.xpath(firstContactGroupName)).getText();
					websiteDashboardAssertText22=BasePage.driver.findElement(By.xpath(firstContactGroupNumber)).getText();
					BasePage.driver.findElement(By.xpath(firstContactGroupName)).click();
					try {
						 Thread.sleep(8000);
				   	 } catch (InterruptedException e) {
				 			
				 			e.printStackTrace();
				 		}
				        
				        UtilityFunctions.WaitUntilPresenceOfElement(GroupDetailsPage.AssociatedContactGrid);
				        websiteDashboardAssertText23= BasePage.driver.findElement(By.xpath(GroupDetailsPage.GroupName)).getText();
				        websiteDashboardAssertText24= BasePage.driver.findElement(By.xpath(GroupDetailsPage.ContactsCountOnGroupDetails)).getText();
				        return new WebsiteDashboardPage();
				}
}
