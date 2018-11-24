package Page.InquiryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Base.BasePage;
import Util.UtilityFunctions;

public class NotificationSettingsPage {

	private static String MenuNotificationSettings="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Notification Settings')]";
	private static String SelectUserFromInquiryNotificationList="//*[@id='collapseOne']/div/label[contains(text(),'The following users will be notified by email any time an inquiry is submitted.')]/ancestor::div[1]/following-sibling::div[1]/div/div/div/div[2]/div/div/ul/li/span[contains(text(),'Harper')]";
	private static String RecipientsUserFromInquiryNotificationList="//*[@id='collapseOne']/div/label[contains(text(),'The following users will be notified by email any time an inquiry is submitted.')]/ancestor::div[1]/following-sibling::div[1]/div/div/div/div[2]/div/div[2]/ul/li";
	private static String SendNotificationsforInternallyCreatedInquiriesSectionToggle="//*[@id='submit_form']/div/div/div[2]/h3/a/i";
	private static String NoOptionForInternallyCreatedInquiries="//*[@id='collapseThree']/div/div/div/label[2]/div/span";
	private static String Savebutton="//*[@id='search-btn']";
	private static String NotificationSettingPageLoadAssertForWait="//*[@id='ms-my_multi_select1']/div[1]/ul";
	private static String NotificationSettingPageNavigationAssert="//*[@id='divInquiry']/div/div[1]/div/h1/div";
	private static String RecipientsUserFromSurveyList="//*[@id='collapseSix']/div/label[contains(text(),'The following users will be notified by email any time a survey response is submitted from the public site.')]/ancestor::div[1]/following-sibling::div[1]/div/div/div/div[2]/div/div[2]/ul/li";
	
	
	//NavigateToNotificationSettingPage variables
	private static String NotificationSettingAssert1;
	
	//NavigateToNotificationSettingPage variables
	private static String NotificationSettingAssert2;
	static WebElement UserFromList;
	
	private static String ClickOnToggle;
	private static String SelectUser="//*[@id='collapseSix']/div/label[contains(text(),'The following users will be notified by email any time a survey response is submitted from the public site.')]/ancestor::div[1]/following-sibling::div[1]/div/div/div/div[2]/div/div/ul/li/span[contains(text(),'Harper')]";
	static WebElement UserFromList1;
	
	private static String NotificationSettingAssert3;
	static WebElement ReceipentUserFromList1;
	
	
	//Navigate to notification Setting page
	public static String NavigateToNotificationSettingPage()
	{
		BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
        BasePage.driver.findElement(By.xpath(MenuNotificationSettings)).click(); 
        try {
		 Thread.sleep(7000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(NotificationSettingPageLoadAssertForWait);
        NotificationSettingAssert1= BasePage.driver.findElement(By.xpath(NotificationSettingPageNavigationAssert)).getText();
        return(NotificationSettingAssert1);
	}
	
	//Function for assigning Inquiry Notification List user and Selecting option Send Notifications for Internally-Created Inquiries to No and Save the page
	public static String SelectUserAndNotificationOption()
	{
		UserFromList=BasePage.driver.findElement(By.xpath(SelectUserFromInquiryNotificationList));
		Actions action = new Actions(BasePage.driver); 
		action.moveToElement(UserFromList).doubleClick().build().perform();
		
		BasePage.driver.findElement(By.xpath(SendNotificationsforInternallyCreatedInquiriesSectionToggle)).click();
		try {
			 Thread.sleep(2000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		BasePage.driver.findElement(By.xpath(NoOptionForInternallyCreatedInquiries)).click();
		BasePage.driver.findElement(By.xpath(Savebutton)).click();	
		try {
			 Thread.sleep(5000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		UtilityFunctions.WaitUntilPresenceOfElement(NotificationSettingPageLoadAssertForWait);
		//RecipientsUserFromInquiryNotificationList
		NotificationSettingAssert2= BasePage.driver.findElement(By.xpath(RecipientsUserFromInquiryNotificationList)).getText();
		if(NotificationSettingAssert2.isEmpty())
			return("False");
		else
			return("True");
	}
	
	//Resuable function allows to select toggle section 
	public static void ClickOnToggle(String SectionValue)
	{
		ClickOnToggle="//*[@id='submit_form']/div/div/div/h3/a[contains(text(),'"+SectionValue+"')]/i";
		BasePage.driver.findElement(By.xpath(ClickOnToggle)).click();
		
	}
	
	public static String SelectSurveyListUser()
	{
		try {
			 Thread.sleep(3000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		ClickOnToggle("Survey Notification List");
		//AssoicateUserFromList("The following users will be notified by email any time a survey response is submitted from the public site.");
		try {
			 Thread.sleep(2000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		UserFromList1=BasePage.driver.findElement(By.xpath(SelectUser));
		Actions action = new Actions(BasePage.driver); 
		action.moveToElement(UserFromList1).doubleClick().build().perform();
		BasePage.driver.findElement(By.xpath(Savebutton)).click();	
		try {
			 Thread.sleep(8000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		UtilityFunctions.WaitUntilPresenceOfElement(NotificationSettingPageLoadAssertForWait);
		NotificationSettingAssert3= BasePage.driver.findElement(By.xpath(RecipientsUserFromSurveyList)).getText();
		if(NotificationSettingAssert3.isEmpty())
			return("False");
		else
			return("True");
		
	}
	
}
