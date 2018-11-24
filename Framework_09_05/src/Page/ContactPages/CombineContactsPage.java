package Page.ContactPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;
import Util.UtilityFunctions;

public class CombineContactsPage {

	private static String MenuCombineContacts="//*[@id='navbar-collapse-1']/ul/li/ul/ul/ul/li/a[contains(text(),'Combine Contacts')]";
	private static String NextButton="//*[@id='btn-Next']";
	private static String LoadingGrid="//*[@id='tblContactsToCombine']/tbody/tr[1]/th[1]";
	private static String SelectMoreContactsButton="//*[@id='divCombineContact']/div[1]/div/h1/div/span/a[contains(text(),'Select More Contacts')]";
	
	private static String CombineContactsAssertLabel1;
	
	//Variables of first contact selected
	private static String FirstColumnId="//*[@id='tblContactsToCombine']/tbody/tr[2]/td/label";
	private static String ResultColumnDirectory="//*[@id='tblInputCombineContact']/tbody/tr[3]/td/select";
	private static String FirstColumnFirstName="//*[@id='tblContactsToCombine']/tbody/tr[5]/td[1]";
	private static String FirstColumnLastName="//*[@id='tblContactsToCombine']/tbody/tr[6]/td[1]";
	private static String FirstColumnMobile="//*[@id='tblContactsToCombine']/tbody/tr[14]/td[1]";
	private static String FirstColumnEmail=".//*[@id='tblContactsToCombine']/tbody/tr[17]/td[1]";
	private static String CombineAllButton="//*[@id='divContact']/div/div/div/form/div[2]/a";
	private static String NextButtonCombine="//*[@id='submit_CombineContactform']/div/div[3]/div/a[4]";
	private static String SaveButton="//*[@id='submit_CombineContactform']/div/div[3]/div/a[5]";
	private static String GetCombinedContact;
	
	public static String NavigateToCombineContacts()
	{
		BasePage.driver.findElement(By.xpath(BasePage.HeaderMenuPIERPro)).click();
        BasePage.driver.findElement(By.xpath(MenuCombineContacts)).click(); 
        try {
		 Thread.sleep(4000);
   	 } catch (InterruptedException e) {
 			
 			e.printStackTrace();
 		}
        
        BasePage.driver.findElement(By.xpath(NextButton)).click();
        try {
   		 Thread.sleep(5000);
      	 } catch (InterruptedException e) {
    			
    			e.printStackTrace();
    		}
        UtilityFunctions.WaitUntilPresenceOfElement(SearchContactPopUpPage.SearchContactPopUpLoadAssertLabel);
        CombineContactsAssertLabel1=BasePage.driver.findElement(By.xpath(SearchContactPopUpPage.ContactHeader)).getText(); 
        return(CombineContactsAssertLabel1);
	}
	
	//Resuable function for searching contacts with below parameters on Search Contact Pop-up
	public static void SearchContactOnPopUp(String FirstNameValue, String LastNameValue, String EmailValue)
	{
		BasePage.driver.findElement(By.id(SearchContactPopUpPage.SearchByFirstName)).sendKeys(FirstNameValue);
        BasePage.driver.findElement(By.id(SearchContactPopUpPage.SearchByLastName)).sendKeys(LastNameValue);
        BasePage.driver.findElement(By.id(SearchContactPopUpPage.SearchByEmail)).sendKeys(EmailValue);
        BasePage.driver.findElement(By.xpath(SearchContactPopUpPage.SearchButton)).click();
        
        try {
   		 Thread.sleep(2000);
      	 } catch (InterruptedException e) {
    			
    			e.printStackTrace();
    		}   
	}
	
	public static void SelectContactsForCombining(String FirstNameValue, String LastNameValue, String EmailValue,String FirstNameValue2, String LastNameValue2, String EmailValue2)
	{
		SearchContactOnPopUp(FirstNameValue,LastNameValue,EmailValue);
		try {
	   		 Thread.sleep(2000);
	      	 } catch (InterruptedException e) {
	    			
	    			e.printStackTrace();
	    		} 
		BasePage.driver.findElement(By.xpath(SearchContactPopUpPage.SelectFirstContact)).click();
		BasePage.driver.findElement(By.xpath(SearchContactPopUpPage.OkButton)).click();
		UtilityFunctions.WaitUntilPresenceOfElement(LoadingGrid);
		
		try {
	   		 Thread.sleep(5000);
	      	 } catch (InterruptedException e) {
	    			
	    			e.printStackTrace();
	    		} 
		
		BasePage.driver.findElement(By.xpath(SelectMoreContactsButton)).click();
		SearchContactOnPopUp(FirstNameValue2,LastNameValue2,EmailValue2);
		try {
	   		 Thread.sleep(2000);
	      	 } catch (InterruptedException e) {
	    			
	    			e.printStackTrace();
	    		} 
		BasePage.driver.findElement(By.xpath(SearchContactPopUpPage.SelectFirstContact)).click();
		BasePage.driver.findElement(By.xpath(SearchContactPopUpPage.OkButton)).click();
		UtilityFunctions.WaitUntilPresenceOfElement(LoadingGrid);
		
	}
	
	public static String SelectColumnForCombiningContact(String DirectoryValue, String FirstNameValue, String LastNameValue, String EmailValue)
	{
		try {
	   		 Thread.sleep(5000);
	      	 } catch (InterruptedException e) {
	    			
	    			e.printStackTrace();
	    		} 
		BasePage.driver.findElement(By.xpath(FirstColumnId)).click();
		Select Directorydropdown = new Select(BasePage.driver.findElement(By.xpath(ResultColumnDirectory)));
		Directorydropdown.selectByVisibleText(DirectoryValue);
		BasePage.driver.findElement(By.xpath(FirstColumnFirstName)).click();
		BasePage.driver.findElement(By.xpath(FirstColumnLastName)).click();
		BasePage.driver.findElement(By.xpath(FirstColumnMobile)).click();
		BasePage.driver.findElement(By.xpath(FirstColumnEmail)).click();
		BasePage.driver.findElement(By.xpath(FirstColumnEmail)).click();
		//BasePage.driver.findElement(By.xpath(CombineAllButton)).click();
		BasePage.driver.findElement(By.xpath(NextButtonCombine)).click();
		try {
	   		 Thread.sleep(2000);
	      	 } catch (InterruptedException e) {
	    			
	    			e.printStackTrace();
	    		} 
		BasePage.driver.findElement(By.xpath(SaveButton)).click();
		try {
	   		 Thread.sleep(7000);
	      	 } catch (InterruptedException e) {
	    			
	    			e.printStackTrace();
	    		} 
		UtilityFunctions.WaitUntilPresenceOfElement(SearchContactPage.SearchContactsAssertlabel1);		
		
		GetCombinedContact=SearchContactPage.SearchContactByName(FirstNameValue,LastNameValue,EmailValue);
		return(GetCombinedContact);
	}
}
