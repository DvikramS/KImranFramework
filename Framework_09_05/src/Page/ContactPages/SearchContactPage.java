package Page.ContactPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BasePage;
import Util.CommonFunctions;
import Util.ErrorUtility;
import Util.UtilityFunctions;

public class SearchContactPage {

	private static String MenuSearchContacts="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Search Contacts')]";
	
	//Search contact screen varibales
	public static String SearchContactsAssertlabel1="//*[@id='divContact']/div[3]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]";
	public static String SearchContactsAssertlabel2="//*[@id='divContact']/div/div/div/h3[contains(text(),'Contacts')]";
	private static String SearchContactsAssertlabel3;
	private static String SearchByFirstName="FirstName";
	private static String SearchByLastName="LastName";
	private static String SearchByEmail="Email";
	private static String SearchButton="//*[@id='search-btn']";
	private static String FirstName="//*[@id='divContact']/div[3]/div[2]/div[2]/div/div[2]/table/tbody/tr/td[1]";
	private static String LastName="//*[@id='divContact']/div[3]/div[2]/div[2]/div/div[2]/table/tbody/tr/td[2]";
	private static String EditButtonFirstContact="//*[@id='divContact']/div[3]/div[2]/div[2]/div/div[2]/table/tbody/tr/td[9]/i[2]";       // xpath for Edit button for first contact in Grid
	public static String NumberOfContactsDisplayed="//*[@id='divContact']/div[3]/div[2]/div[2]/div/div[5]/div/div[1]/div/div/span[3]";
	private static String DirectoryDropdown="//*[@id='divInnerFieldContainer']/div[1]/div[9]/div/select";
	private static String DeleteButtonFirstContact="//*[@id='divContact']/div[3]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[9]/i[5]";  // xpath for delete button for first contact in Grid
	private static String DeletionConfirmationPopUpMessage="//*[@id='pMessage']";
	public static String DeletionConfirmationPopUpMessageLabel="Are you sure, you want to inactivate this contact?";
	private static String YesButton="//*[@id='confirmedOk']";
	private static String NoRecordsFound="//*[@id='divContact']/div[3]/div[2]/div[2]/div/div[3]/p";
	private static String DeletionMessage="html/body/div[8]/div/div/p";
	public static String DeletionMessageLabel="Success! Contact inactivated successfully.";
	public static WebElement DeleteMessageLocator;
	public static String ContactAssignedDirectory="//*[@id='divContact']/div[3]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[8]";
	
	private static String SearchContactsAssertlabel4;
	private static String SearchContactsAssertlabel5;
	private static String SearchContactsAssertlabel6;
	private static String SearchContactsAssertlabel7;
	private static String SearchContactsAssertlabel8;
	public static String SearchContactsAssertlabel9;
	public static String GetSearchContactsAssertlabel10;
	public static String GetSearchContactsAssertlabel11;
	
	        //Navigate to Search Contact Page
			public static String NavigateToSearchContacts()
			{
				 BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
		         BasePage.driver.findElement(By.xpath(MenuSearchContacts)).click(); 
		         try {
				 Thread.sleep(5000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
		         
		         UtilityFunctions.WaitUntilPresenceOfElement(SearchContactsAssertlabel1);
		         SearchContactsAssertlabel3= BasePage.driver.findElement(By.xpath(SearchContactsAssertlabel2)).getText();
		         return(SearchContactsAssertlabel3);
			}
			
			//Search a contact from firstname and lastname 
			public static String SearchContactByName(String FirstNameValue, String LastNameValue, String EmailValue)
			{
				
				 BasePage.driver.findElement(By.id(SearchByFirstName)).sendKeys(FirstNameValue);
				 BasePage.driver.findElement(By.id(SearchByLastName)).sendKeys(LastNameValue);
				 BasePage.driver.findElement(By.id(SearchByEmail)).sendKeys(EmailValue);
				 BasePage.driver.findElement(By.xpath(SearchButton)).click();
				 
				 try {
					 Thread.sleep(2000);
			    	 } catch (InterruptedException e) {
			  			
			  			e.printStackTrace();
			  		}
				 SearchContactsAssertlabel4=BasePage.driver.findElement(By.xpath(FirstName)).getText();
				 SearchContactsAssertlabel5=BasePage.driver.findElement(By.xpath(LastName)).getText();
				 SearchContactsAssertlabel6 = SearchContactsAssertlabel4+ " "+SearchContactsAssertlabel5;
				 return(SearchContactsAssertlabel6);
			}
			
			public static String EditContact()
			{
				BasePage.driver.findElement(By.xpath(EditButtonFirstContact)).click();
				
			
			try {
				 Thread.sleep(5000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
		         
		         UtilityFunctions.WaitUntilPresenceOfElement(EditContactPage.EditContactAssert);
		         SearchContactsAssertlabel7= BasePage.driver.findElement(By.xpath(EditContactPage.EditContactTab)).getText();
		         return(SearchContactsAssertlabel7);
			}
			
			public static String ValidateDirectoryPresenceInSearchContactOptions(String DirectoryNameValue)
			{
				SearchContactsAssertlabel8=CommonFunctions.ReturnPresenceOfTextInDropdown(DirectoryDropdown, DirectoryNameValue);
				return(SearchContactsAssertlabel8);
			}
			
			public static SearchContactPage DeleteContact(String FirstNameValue,String LastNameValue,String EmailValue)
			{
				BasePage.driver.findElement(By.xpath(DeleteButtonFirstContact)).click();
				try {
					 Thread.sleep(2000);
			    	 } catch (InterruptedException e) {
			  			
			  			e.printStackTrace();
			  		}
				
				SearchContactsAssertlabel9=BasePage.driver.findElement(By.xpath(DeletionConfirmationPopUpMessage)).getText();
				BasePage.driver.findElement(By.xpath(YesButton)).click();
				//By Msg = By.xpath("html/body/div[11]/img");
				
				/*Wait till success message label is visible
				//ErrorUtility.fluentWait(Msg);
				WebDriverWait wait = new WebDriverWait(BasePage.driver, 30);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(Msg));
				GetSearchContactsAssertlabel11=BasePage.driver.findElement(By.xpath(DeletionMessage)).getText();
				*/
			
				try {
				 Thread.sleep(5000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
		         
		         UtilityFunctions.WaitUntilPresenceOfElement(SearchContactsAssertlabel1);
		         BasePage.driver.findElement(By.id(SearchByFirstName)).clear();
				 BasePage.driver.findElement(By.id(SearchByLastName)).clear();
				 BasePage.driver.findElement(By.id(SearchByEmail)).clear();
				 
		         BasePage.driver.findElement(By.id(SearchByFirstName)).sendKeys(FirstNameValue);
				 BasePage.driver.findElement(By.id(SearchByLastName)).sendKeys(LastNameValue);
				 BasePage.driver.findElement(By.id(SearchByEmail)).sendKeys(EmailValue);
				 BasePage.driver.findElement(By.xpath(SearchButton)).click();
				 try {
					 Thread.sleep(4000);
			    	 } catch (InterruptedException e) {
			  			
			  			e.printStackTrace();
			  		}
				 GetSearchContactsAssertlabel10= BasePage.driver.findElement(By.xpath(NoRecordsFound)).getText();
		         return new SearchContactPage();
			}
}
