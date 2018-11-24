package Page.ContactPages;

import org.openqa.selenium.By;

import Base.BasePage;
import Page.GroupPages.GroupDetailsPage;
import Page.InquiryPages.SearchInquiryPage;
import Util.UtilityFunctions;

public class ContactDashboardPage {

	private static String MenuContactDashboard="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Contact Dashboard')]";
	
	private static String ContactDashboardLoad="//*[@id='divDirectoryGrid']/div[2]/table/tbody/tr[1]/td[1]";
	private static String ContactDashboardAssert= "//*[@id='divContactDashborad']/div[1]/div/h1/div[contains(text(),'Contact Dashboard')]";
	public  static String ContactDashboardAssertLabel="Contact Dashboard";
	private static String ContactDirectoryFirstCount="//*[@id='divDirectoryGrid']/div[2]/table/tbody/tr[1]/td[2]/a";
	private static String ContactDirectoryFirstRow="//*[@id='divDirectoryGrid']/div[2]/table/tbody/tr[1]/td[1]/a";
	private static String ContactGroupFirstRow="//*[@id='divGroupGrid']/div[2]/table/tbody/tr[1]/td[1]/a";
	private static String ContactGroupFirstCount="//*[@id='divGroupGrid']/div[2]/table/tbody/tr[1]/td[3]/a";
	private static String SubscriptionFirstRow="//*[@id='divChannelGrid']/div[2]/table/tbody/tr[1]/td[1]/a";
	private static String SearchContactButton="//*[@id='divContactDashborad']/div[1]/div/h1/div[2]/span[1]/a/i";
	private static String AddContactButton="//*[@id='divContactDashborad']/div[1]/div/h1/div[2]/span[2]/a/i";
	
	private static String ContactDashboardAssertLabel1; 
	private static String GetDirectoryCountCD;
	private static String ContactDashboardAssertLabel2;
	private static String GetGroupCountCD;
	private static String ContactDashboardAssertLabel3;
	private static Boolean VerifyPresence;
	private static String ContactDashboardAssertLabel4;
	private static String ContactDashboardAssertLabel5;
	private static String ContactDashboardAssertLabel6;
	
	public static String NavigateToContactDashboard()
	{
		 try {
			 Thread.sleep(3000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
		BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
        BasePage.driver.findElement(By.xpath(MenuContactDashboard)).click(); 
        try {
		 Thread.sleep(7000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        UtilityFunctions.WaitUntilPresenceOfElement(ContactDashboardLoad);
        ContactDashboardAssertLabel1= BasePage.driver.findElement(By.xpath(ContactDashboardAssert)).getText();
        return(ContactDashboardAssertLabel1);
	}
	
	public static String VerifyDirectoryNameIsClickableOnCD()
	{
		GetDirectoryCountCD=BasePage.driver.findElement(By.xpath(ContactDirectoryFirstCount)).getText();
		BasePage.driver.findElement(By.xpath(ContactDirectoryFirstRow)).click();
		try {
			 Thread.sleep(7000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	        
	        UtilityFunctions.WaitUntilPresenceOfElement(SearchContactPage.SearchContactsAssertlabel1);
	        ContactDashboardAssertLabel2= BasePage.driver.findElement(By.xpath(SearchContactPage.NumberOfContactsDisplayed)).getText();
	       // System.out.println(getDirectoryCount + "   "+ InquiryDashboardAssertLabel2);
	        if(GetDirectoryCountCD.equals(ContactDashboardAssertLabel2))
				return("True");
			else
				return("False");	
	}
	
	public static String VerifyGroupNameIsClickable()
	{
		GetGroupCountCD=BasePage.driver.findElement(By.xpath(ContactGroupFirstCount)).getText();
		BasePage.driver.findElement(By.xpath(ContactGroupFirstRow)).click();
		try {
			 Thread.sleep(7000);
	   	 } catch (InterruptedException e) {
	 			
	 			e.printStackTrace();
	 		}
	        
	        UtilityFunctions.WaitUntilPresenceOfElement(GroupDetailsPage.AssociatedContactGrid);
	        ContactDashboardAssertLabel3= BasePage.driver.findElement(By.xpath(GroupDetailsPage.ContactsCountOnGroupDetails)).getText();
	       // System.out.println(getCategoryCount + "   "+ InquiryDashboardAssertLabel3);
	        if(GetGroupCountCD.equals(ContactDashboardAssertLabel3))
				return("True");
			else
				return("False");	
	}
	
	//Verify Subscription link is clickable and Verify no. of contacts 
	//Need to connect database for fetching excat contact count assoicated with a channel
	//Return True is hard coded need to replace when we design excat case
	public static String VerifySubscriptionNameIsClickable()
	{
		VerifyPresence=BasePage.driver.findElement(By.xpath(SubscriptionFirstRow)).isDisplayed();
		if(VerifyPresence)
		{
			BasePage.driver.findElement(By.xpath(SubscriptionFirstRow)).click();
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
	 			
				e.printStackTrace();
				}
	        
			 UtilityFunctions.WaitUntilPresenceOfElement(SearchContactPage.SearchContactsAssertlabel1);
		     ContactDashboardAssertLabel4= BasePage.driver.findElement(By.xpath(SearchContactPage.NumberOfContactsDisplayed)).getText();
	         return("True");
		}
		else
			{
			System.out.println("No Subscription channel present on Dashboard");
			return("False");
			}
	}
	
	public static String NavigateToAddContactFromContactDashboard()
	{
		BasePage.driver.findElement(By.xpath(AddContactButton)).click();
		try {
			 Thread.sleep(5000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
	         
        UtilityFunctions.WaitUntilPresenceOfElement(AddContactPage.AddContactAssertLabel1);
        ContactDashboardAssertLabel5= BasePage.driver.findElement(By.xpath(AddContactPage.AddContactAssertLabel3)).getText();
        return(ContactDashboardAssertLabel5);
	}
	
	public static String NavigateToSearchContactFromContactDashboard()
	{
		BasePage.driver.findElement(By.xpath(SearchContactButton)).click();
		try {
			 Thread.sleep(10000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
	         
        UtilityFunctions.WaitUntilPresenceOfElement(SearchContactPage.SearchContactsAssertlabel1);
        ContactDashboardAssertLabel6= BasePage.driver.findElement(By.xpath(SearchContactPage.SearchContactsAssertlabel2)).getText();
        return(ContactDashboardAssertLabel6);
	}
}
