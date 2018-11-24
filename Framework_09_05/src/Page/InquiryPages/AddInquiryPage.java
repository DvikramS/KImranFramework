package Page.InquiryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;
import Page.ContactPages.DirectoryPage;
import Util.UtilityFunctions;

public class AddInquiryPage {

	private static String MenuAddInquiryForNewContact="//*[@id='navbar-collapse-1']/ul/li[4]/ul/ul/ul/li/ul/li/a[contains(text(),'For New Contact')]";
	private static String MenuAddInquiryForExistingContact="//*[@id='navbar-collapse-1']/ul/li[4]/ul/ul/ul/li/ul/li/a[contains(text(),'For Existing Contact')]";
	
	// Add Inquiry with new contact variables
	private static String AddInquiryAssertLabel1="//*[@id='Contact_Directory']/option[contains(text(),'Others')]";	
	private static String AddInquiryAssertLabel2;
	public static String AddInquiryAssertLabel3="//*[@id='divAddInquiry']/div[1]/div/h1/div[contains(text(),'Add Inquiry for new contact')]";
	private static String Directory ="//*[@id='Contact_Directory']";
	private static String FirstName="Contact_FirstName";
	private static String LastName="Contact_LastName";
	private static String Email="Contact_Email";
	private static String Phone="Contact_Phone";
	private static String Country="//*[@id='slCountry']";
	private static String Question="QuestionComments";
	private static String ResponseType="//*[@id='collapseThree']/div[1]/div[1]/div[4]/label/span[contains(text(),'Send Email Response to Inquirer')]/preceding-sibling::div/span";
	private static String ResponseText="//*[@id='collapseThree']/div[3]/div/div";
	private static String InquiryStatus="//*[@id='collapseThree']/div/div/label/span[contains(text(),'New')]/preceding-sibling::div/span";
	private static String SelectInquiryCategory="//*[@id='ddlCategories']/option[contains(text(),'Department')]";  // Change category name according to created in Category test case
	private static String SubmitButton="//*[@id='divAddInquiry']/div[2]/div/div/div/div/a[contains(text(),'Submit')]";
	//private static String AddInquiryAssertLabel4="//*[@id='divInquiryList']/div/div/h1[contains(text(),'Search Inquiry')]";
	private static String AddInquiryAssertLabel4="//*[@id='rowBody']/td[2]";
	private static String AddInquiryAssertLabel5;
	
	// Add Inquiry for existing contact variables 
	private static String AddInquiryAssertLabel6="//*[@id='divContact']/div[2]/div/div/h3[contains(text(),'Contacts')]";
	private static String AddInquiryAssertLabel7;
	private static String ContactSearch_FirstName="FirstName";
	private static String ContactSearch_LastName="LastName";
	private static String ContactSearch="//*[@id='search-btn']";
	private static String SelectContact="//*[@id='divContact']/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/div/span";
	private static String OkButton="//*[@id='divContactPopUp']/div/div/button[contains(text(),'Ok')]";
	private static String AddInquiryAssertLabel9;
	private static String CancelbuttononSearchContact="//*[@id='divContactPopUp']/div/div[3]/button[contains(text(),'Cancel')]";
	private static String AddInquiryAssertLabel10;
	
	
	  //Navigate to Add Contact Page
		public static String NavigateToAddInquiryForNewContact()
		{
			 BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
	         BasePage.driver.findElement(By.xpath(MenuAddInquiryForNewContact)).click(); 
	         try {
			 Thread.sleep(5000);
	    	 } catch (InterruptedException e) {
	  			
	  			e.printStackTrace();
	  		}
	         
	         UtilityFunctions.WaitUntilPresenceOfElement(AddInquiryAssertLabel1);
	         AddInquiryAssertLabel2= BasePage.driver.findElement(By.xpath(AddInquiryAssertLabel3)).getText();
	         return(AddInquiryAssertLabel2);
		}
		
	//Create Inquiry for new contact
		public static String CreateInquiryForNewContact(String FirstNameValue, String LastNameValue, String EmailValue, String MobileValue, String CountryValue, 
				String QuestionValue,String ResponseTextValue, String SelectedsResponseTypeValue, String DirectoryNameValue )
		{
			String AddInquiryAssertLabel6="//*[@id='rowBody']/td[3]/p[contains(text(),'"+ QuestionValue +"')]";
			String SelectedResponseType="//*[@id='collapseThree']/div[1]/div/div/label/span[contains(text(),'"+ SelectedsResponseTypeValue +"')]/preceding-sibling::div/span";
			
			Select directorydropdown = new Select(BasePage.driver.findElement(By.xpath(Directory)));
			directorydropdown.selectByVisibleText(DirectoryNameValue);
			//directorydropdown.selectByVisibleText("Others");
			
			 BasePage.driver.findElement(By.id(FirstName)).sendKeys(FirstNameValue);
			 BasePage.driver.findElement(By.id(LastName)).sendKeys(LastNameValue);
			 BasePage.driver.findElement(By.id(Email)).sendKeys(EmailValue);
			 BasePage.driver.findElement(By.id(Phone)).sendKeys(MobileValue);
			
			 Select Countrydropdown = new Select(BasePage.driver.findElement(By.xpath(Country)));
			 Countrydropdown.selectByVisibleText(CountryValue);

			 BasePage.driver.findElement(By.id(Question)).sendKeys(QuestionValue);
			 BasePage.driver.findElement(By.xpath(SelectedResponseType)).click();
			 BasePage.driver.findElement(By.xpath(ResponseText)).sendKeys(ResponseTextValue);
			 BasePage.driver.findElement(By.xpath(InquiryStatus)).click();
			 BasePage.driver.findElement(By.xpath(SubmitButton)).click();
			 
			 try {
				 Thread.sleep(10000);
		    	 } catch (InterruptedException e) {
		  			
		  			e.printStackTrace();
		  		}
		         
		     UtilityFunctions.WaitUntilPresenceOfElement(AddInquiryAssertLabel4);
			 AddInquiryAssertLabel5=BasePage.driver.findElement(By.xpath(AddInquiryAssertLabel6)).getText();
			 return(AddInquiryAssertLabel5);
			 
		}
		
		//Navigate to Add Inquiry for existing contact
				public static String NavigateToAddInquiryForExistingContact()
				{
					 BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
			         BasePage.driver.findElement(By.xpath(MenuAddInquiryForExistingContact)).click(); 
			         try {
					 Thread.sleep(5000);
			    	 } catch (InterruptedException e) {
			  			
			  			e.printStackTrace();
			  		}
			         
			         UtilityFunctions.WaitUntilPresenceOfElement(AddInquiryAssertLabel6);
			         AddInquiryAssertLabel7= BasePage.driver.findElement(By.xpath(AddInquiryAssertLabel6)).getText();
			         return(AddInquiryAssertLabel7);
				}
		  //Create Inquiry for Existing contact
				public static String CreateInquiryForExistingContact(String ContactSearch_FirstNameValue, String ContactSearch_LastNameValue, String CountryValue, String QuestionValue,String ResponseTextValue )
				{
					String AddInquiryAssertLabel8="//*[@id='rowBody']/td[3]/p[contains(text(),'"+ QuestionValue +"')]";
					
					 BasePage.driver.findElement(By.id(ContactSearch_FirstName)).sendKeys(ContactSearch_FirstNameValue);
					 BasePage.driver.findElement(By.id(ContactSearch_LastName)).sendKeys(ContactSearch_LastNameValue);
					 BasePage.driver.findElement(By.xpath(ContactSearch)).click();
					 
					 BasePage.driver.findElement(By.xpath(SelectContact)).click();	
					 BasePage.driver.findElement(By.xpath(OkButton)).click();
					 
					 try {
						 Thread.sleep(6000);
				    	 } catch (InterruptedException e) {
				  			
				  			e.printStackTrace();
				  		}
					 
					Select directorydropdown = new Select(BasePage.driver.findElement(By.xpath(Directory)));
					//directorydropdown.selectByVisibleText(DirectoryPage.DirectoryAssertLabel2);
					directorydropdown.selectByVisibleText("Others");
					
					 Select Countrydropdown = new Select(BasePage.driver.findElement(By.xpath(Country)));
					 Countrydropdown.selectByVisibleText(CountryValue);

					 BasePage.driver.findElement(By.id(Question)).sendKeys(QuestionValue);
					 BasePage.driver.findElement(By.xpath(ResponseType)).click();
					 BasePage.driver.findElement(By.xpath(ResponseText)).sendKeys(ResponseTextValue);
					 BasePage.driver.findElement(By.xpath(InquiryStatus)).click();
					 BasePage.driver.findElement(By.xpath(SubmitButton)).click();
					 
					 try {
						 Thread.sleep(10000);
				    	 } catch (InterruptedException e) {
				  			
				  			e.printStackTrace();
				  		}
				         
				     UtilityFunctions.WaitUntilPresenceOfElement(AddInquiryAssertLabel4);
					 AddInquiryAssertLabel9=BasePage.driver.findElement(By.xpath(AddInquiryAssertLabel8)).getText();
					 return(AddInquiryAssertLabel9);
					 
				}
				
				public static String AssertOnNavigatingToAddInquiryPage()
				{
					 UtilityFunctions.WaitUntilPresenceOfElement(AddInquiryAssertLabel1);
			         AddInquiryAssertLabel2= BasePage.driver.findElement(By.xpath(AddInquiryAssertLabel3)).getText();
			         return(AddInquiryAssertLabel2);
				}
				
				public static String AssertOnNavigatingToAddInquiryForExistingContactPage()
				{
					 UtilityFunctions.WaitUntilPresenceOfElement(AddInquiryAssertLabel6);
			         AddInquiryAssertLabel7= BasePage.driver.findElement(By.xpath(AddInquiryAssertLabel6)).getText();       
			         return(AddInquiryAssertLabel7);
				}
				
				public static String CancelSearchContactPopUp()
				{
					BasePage.driver.findElement(By.xpath(CancelbuttononSearchContact)).click(); 
			         try {
					 Thread.sleep(5000);
			    	 } catch (InterruptedException e) {
			  			
			  			e.printStackTrace();
			  		}
			         AddInquiryAssertLabel10=AssertOnNavigatingToAddInquiryPage();
			         return(AddInquiryAssertLabel10);   
				}
}
