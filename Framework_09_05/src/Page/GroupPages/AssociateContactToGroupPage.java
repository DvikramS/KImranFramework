package Page.GroupPages;

import org.openqa.selenium.By;

import Base.BasePage;
import Page.ContactPages.EditContactPage;
import Page.ContactPages.SearchContactPage;
import Util.UtilityFunctions;

public class AssociateContactToGroupPage {

	public static String GridLoadAssert="//*[@id='divGroupContact']/div[3]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]";
	private static String AddButton="//*[@id='btnBottomAdd']";
	private static String FirstContactCheckbox="//*[@id='divGroupContact']/div[3]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/div/span/input";
	
	//Contact SearchBy Variables
	private static String FirstName="FirstName";
	private static String LastName="LastName";
	private static String Email="Email";
	private static String SearchButton="//*[@id='search-btn']";
	
	//Variables for SearchAndAssociateContacts
	private static String GetAssoicatedContactName;
	
	//Search Contact and Add to group
	public static String SearchAndAssociateContacts(String FirstNameValue, String LastNameValue, String EmailValue)
	{
		SearchContactOnAssociateContactGroup(FirstNameValue,LastNameValue,EmailValue);
		BasePage.driver.findElement(By.xpath(FirstContactCheckbox)).click();
		BasePage.driver.findElement(By.xpath(AddButton)).click();
		try {
			 Thread.sleep(7000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
	         
	     UtilityFunctions.WaitUntilPresenceOfElement(GroupDetailsPage.AssociatedContactGrid);
	     GetAssoicatedContactName= BasePage.driver.findElement(By.xpath(GroupDetailsPage.AssociatedContactGrid)).getText()+ " "+BasePage.driver.findElement(By.xpath(GroupDetailsPage.LastNameOfContact)).getText();
	     return(GetAssoicatedContactName);
	}
	
	public static void SearchContactOnAssociateContactGroup(String FirstNameValue, String LastNameValue, String EmailValue)
	{
		
		 BasePage.driver.findElement(By.id(FirstName)).sendKeys(FirstNameValue);
		 BasePage.driver.findElement(By.id(LastName)).sendKeys(LastNameValue);
		 BasePage.driver.findElement(By.id(Email)).sendKeys(EmailValue);
		 BasePage.driver.findElement(By.xpath(SearchButton)).click();
		 
		 try {
			 Thread.sleep(3000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
		 UtilityFunctions.WaitUntilPresenceOfElement(GridLoadAssert);
	}
	
	
}
