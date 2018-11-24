package Page.NotificationPages;

import org.openqa.selenium.By;

import Base.BasePage;
import Page.ContactPages.ChannelListPage;
import Util.UtilityFunctions;

public class DistributionReportListPage {

	public static String MenuDistributionReport="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Distribution Report')]";
	public static String FirstNotificationElementInDataGrid="//*[@id='rowBody']/td[2]";  //Xpath for data grid load
	public static String NotificationHeaderPath="//*[@id='divNotificationList']/div[1]/div/h1";
	public static String NotificationHeaderLabel="All Notifications";
	private static String SentNotification;
	private static String SentNotification1;
	private static String StartNotificationSubject="//*[@id='rowBody']/td/a[contains(text(),'";
	private static String EndNotificationSubject="')]";
	private static String EndNotificationStatus="')]/ancestor::td[1]/following-sibling::td[5]";
	
	private static String GetDistributionAssertText;
	private static String GetDistributionAssertText1;
	public static String GetDistributionAssertText2;
	public static String GetNotificationStatus;
	
	public static String NavigateToDistributionReportPage()
	{
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
        BasePage.driver.findElement(By.xpath(MenuDistributionReport)).click(); 
       try {
		 Thread.sleep(8000);
  	 	} catch (InterruptedException e) {
			
			e.printStackTrace();
  	 	}
       UtilityFunctions.WaitUntilPresenceOfElement(FirstNotificationElementInDataGrid);
       GetDistributionAssertText1= BasePage.driver.findElement(By.xpath(NotificationHeaderPath)).getText();
       return(GetDistributionAssertText1);
	}
	
	public static String ValidateSentNotificationOnList(String NotificationName)
	{
		SentNotification=StartNotificationSubject+NotificationName+EndNotificationSubject;
		GetDistributionAssertText=BasePage.driver.findElement(By.xpath(FirstNotificationElementInDataGrid)).getText();
		return(GetDistributionAssertText);
	}
	
	public static String NavigateToDistributionDetails(String NotificationName)
	{
		SentNotification1=StartNotificationSubject+NotificationName+EndNotificationSubject;
		BasePage.driver.findElement(By.xpath(SentNotification1)).click();
		try {
			 Thread.sleep(7000);
	  	 	} catch (InterruptedException e) {
				
				e.printStackTrace();
	  	 	}
	       UtilityFunctions.WaitUntilPresenceOfElement(DistributionDetailspage.DistributionDetailPageLoad);
		return(GetDistributionAssertText);
	}
	
	public static String ValidateNotificationStatus(String NotificationName)
	{
		GetNotificationStatus=StartNotificationSubject+NotificationName+EndNotificationStatus;
		GetDistributionAssertText2=BasePage.driver.findElement(By.xpath(SentNotification1)).getText();
		return(GetDistributionAssertText2);
	}
	
}
